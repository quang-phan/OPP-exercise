#start=stepper_motor.exe#
#start=led_display.exe#

name "stepper_motor"

out 199, al
jmp start

datcw    db 0000_0110b
         db 0000_0100b    
         db 0000_0011b
         db 0000_0010b
    start:
mov bx, offset datcw; 
mov si, 0
mov cx, 0; dem vong

next_step:
wait:   in al, 7         
        test al, 10000000b
        jz wait

mov al, [bx][si]
out 7, al
mov al, dh
inc si
cmp si, 4
jb next_step
mov si, 0

inc cx       
mov ax, cx 
mov bl, 8 
div bl
mov bx, offset datcw
out 199, al 

jmp next_step

