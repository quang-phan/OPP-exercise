#start=stepper_motor.exe#
name "stepper"
#make_bin#

steps_before_direction_change = 20h ; 32 (decimal)

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


; bin data for clock-wise
; full-step rotation:
datcw_fs db 0000_0001b
         db 0000_0011b    
         db 0000_0110b
         db 0000_0000b

; bin data for counter-clock-wise
; full-step rotation:
datccw_fs db 0000_0100b
          db 0000_0110b    
          db 0000_0011b
          db 0000_0000b


start:
mov bx, offset datcw         
mov si, 0                    
mov cx, 0                   

next_step:
;
wait:   
        in al, 7             
        test al, 10000000b   
        jz wait              

mov al, [bx][si]             
out 7, al                    

inc si                       

cmp si, 4                   
jb next_step                 
mov si, 0                    

inc cx                       
cmp cx, steps_before_direction_change     
jb  next_step               

mov cx, 0                   
add bx, 4                    

cmp bx, offset datccw_fs     
jbe next_step                

mov bx, offset datcw         

jmp next_step                



x][si]             ;chuyển [bx+1][si+1] vào thanh ghi al
out 7, al                    ;xuất dữ liệu từ thanh ghi al ra cổng 7

inc si                       ;cộng 1 vào thanh ghi si

cmp si, 4                    ;so sanh al với 4
jb next_step                 ; nếu si<=4 thì đi đến next_step
mov si, 0                    ; chuyển 0 vào thanh ghi si

inc cx                       ;cộng 1 vào trong thanh ghi cx
cmp cx, steps_before_direction_change     ;so sánh cx với steps_before_direction_change
jb  next_step                ;nếu cx <= cx+1 thì đi đến next_step

mov cx, 0                    ;chuyển 0 vào trong thanh ghi cx
add bx, 4                    ;cộng 4 vào bên trong thanh ghi bx

cmp bx, offset datccw_fs     ;so sánh bx với offset datccw_fs
jbe next_step                ;nhảy đến  next_step nếu (bx hoặc offset datccw_fs) =1

mov bx, offset datcw         ;chuyển offset datcw  vào bên trong thanh ghi bx

jmp next_step                ;nhảy không điều kiện đến next_step



