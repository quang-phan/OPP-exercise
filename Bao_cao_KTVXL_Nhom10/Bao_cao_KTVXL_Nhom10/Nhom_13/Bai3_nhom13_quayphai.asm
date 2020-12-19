; this is an example of out instruction.
; it writes values to virtual i/o port
; that controls the stepper-motor.
; c:\emu8086\devices\stepper_motor.exe is on port 7

#start=stepper_motor.exe#
#start=led_display.exe#

name "stepper"

#make_bin#

jmp start

; ========= data ===============

; buoc nua sang phai
datcw    db 0000_0110b
         db 0000_0100b    
         db 0000_0011b
         db 0000_0010b

; buoc nua sang trai
datccw   db 0000_0011b
         db 0000_0001b    
         db 0000_0110b
         db 0000_0010b


; full-step sang phai
datcw_fs db 0000_0001b
         db 0000_0011b    
         db 0000_0110b
         db 0000_0000b

; full-step sang trai
datccw_fs db 0000_0100b
          db 0000_0110b    
          db 0000_0011b
          db 0000_0000b

half_step_counter      dw     0
cycle_counter     dw     0h
start:
mov bx, offset datcw ; neu sang trai thi thay bang datccw
mov si, 0

next_step:
; motor sets top bit when it's ready to accept new command
wait:   in al, 7     
        test al, 10000000b
        jz wait

mov al, [bx][si]
out 7, al

inc si

cmp si, 4
jb next_step
jmp next_half_step

next_half_step proc
    mov si,0
    inc half_step_counter
    cmp half_step_counter,8
    jb next_step
    jmp next_cycle
endp

next_cycle proc
    mov half_step_counter,0
    inc cycle_counter
    mov ax, cycle_counter
    out 199,ax
    jmp next_step
endp