#start=stepper_motor.exe#
#start=led_display.exe#


name "stepper"

#make_bin#

steps_before_direction_change = 8 ; 32 (decimal)

jmp start

; ========= data ===============
cout dw 0
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
mov si,0
mov cx,0 
mov ax,0;
out 199,ax
  
set_datcw:
mov bx,offset datcw
jmp next_step
set_datccw:
mov bx,offset datccw
jmp next_step

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
cmp cx, 8
jb  next_step

mov cx,0
inc cout
mov ax, cout
out 199,ax

cmp bx, offset datcw
je set_datccw
jne set_datcw



