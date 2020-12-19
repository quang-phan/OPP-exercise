


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

; bin data for clock-wise
; half-step rotation:
datcw    db 0000_0110b
         db 0000_0100b    
         db 0000_0011b
         db 0000_0010b

; bin data for counter-clock-wise
; half-step rotation:
datccw   db 0000_0011b
         db 0000_0001b    
         db 0000_0110b
         db 0000_0010b


start: 
; mov bx offset datccw  ; test counter-clock-wise
mov bx, offset datcw ; start from clock-wise half-step.
mov si, 0
mov cx, 0 ; step counter
mov ax, 0
out 199, ax

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
mov si, 0

inc cx 
mov ax, cx
out 199, ax
jmp next_step



