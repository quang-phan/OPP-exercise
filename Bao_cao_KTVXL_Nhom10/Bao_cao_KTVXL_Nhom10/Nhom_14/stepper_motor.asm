
#start=stepper_motor.exe#
#start=led_display.exe#

name "stepper"

#make_bin#

steps_before_direction_change = 20h ; 32 (decimal)

jmp start

; ========= data ===============
count dw 0
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
mov bx, offset datcw ; start from clock-wise half-step.
mov si, 0
mov ax, 0
mov di, 0
mov cx, 2 ; step counter
out 199,ax

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

inc di
cmp di,8
je nhay
jb next_step

nhay: 
inc count
mov ax, count
mov di, 0
out 199,ax
        
cmp cx, steps_before_direction_change
jb  next_step
              
mov cx, 0
add bx, 4 ; next bin data              
              
cmp bx, offset datccw
jbe next_step
                           
mov bx, offset datcw ; return to clock-wise half-step.
                     
jmp next_step



