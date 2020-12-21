#start=stepper_motor.exe#
#start=led_display.exe#

name "stepper motor"

out 199, al
jmp start

datccw   db 0000_0011b
         db 0000_0001b    
         db 0000_0110b
         db 0000_0010b

start:
mov bx, offset datccw
mov si, 0
mov cx, 0   

next_step:
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
mov bl, 8 
div bl
mov bx, offset datccw
out 199, al 

jmp  next_step
