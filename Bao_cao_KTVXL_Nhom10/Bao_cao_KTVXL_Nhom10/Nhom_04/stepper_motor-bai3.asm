


; this is an example of out instruction.
; it writes values to virtual i/o port
; that controls the stepper-motor.
; c:\emu8086\devices\stepper_motor.exe is on port 7

#start=stepper_motor.exe#
#start=led_display.exe#

name "stepper"

#make_bin#

steps_before_direction_change = 20h ; 32 (decimal)

jmp start

; ========= data ===============

; bin data for clock-wise
; half-step rotation:


; bin data for counter-clock-wise
; half-step rotation:  
cout dw 0
datccw   db 0000_0011b
         db 0000_0001b    
         db 0000_0110b
         db 0000_0010b





start:
mov bx, offset datccw ; start from clock-wise half-step.
mov si, 0
mov ax, 0
mov di, 0
mov cx, 2 ; step counter
out 199, ax

next_step:

mov al, [bx][si]
out 7, al
inc si  

mov cx, 0h
mov dx, 4150h
mov ah,86h
int 15h

cmp si, 4
jb next_step
mov si, 0

inc di
cmp di, 8 
jb  nhay
mov di, 0
inc cout
nhay:
mov ax, cout
out 199,ax
mov cx,2
loop next_step




