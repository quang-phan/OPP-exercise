#start=thermometer.exe#
#start=led_display.exe#
#make_bin#
name "thermo"

hour dw 0h     	;Kh?i t?o gi? phút là doubleword vì hi?n th? LED c?n dùng thanh ghi 16bit
minute dw 0h 

mov ax, cs
mov ds, ax

mov ah, 2ch    	;N?p th?i gian h? th?ng lúc b?t ??u b?t b?p
int 21h

;Duy trì 100oC trong 1h
boil:

call timer	 ;G?i ch??ng trình con ??m th?i gian
cmp hour, 1h    ;Gi? > 1 thì chuy?n sang gi? ?m 80oC
jge warm80

in al, 125      	;L?y nhi?t ?? hi?n t?i c?a b?p t? c?ng 125 -> AL
cmp al, 100     ;AL <= 100 thì t?t b?p, ng??c l?i b?t b?p
jle on1        	;?i?u khi?n b?p b?ng c?ng 127

off1:           	;T?t b?p
mov al, 0
out 127, al
jmp boil 	;Quay l?i ?? duy trì nhi?t ??

on1:            	;B?t b?p
mov al, 1
out 127, al 
jmp boil	;Quay l?i ?? duy trì nhi?t ??

;Duy trì 80oC trong 2h
warm80:

call timer
cmp hour, 3h   ;Gi? > 3 thì chuy?n sang gi? ?m 60oC
jge warm60

in al, 125
cmp al, 80
jle on2

off2:           
mov al, 0
out 127, al
jmp warm80

on2:       
mov al, 1
out 127, al
jmp warm80  

;Duy trì 60oC
warm60:         ;Vòng l?p vô h?n

call timer
in al, 125
cmp al, 60
jle on3

off3:       
mov al, 0
out 127, al
jmp warm60

on3:        
mov al, 1
out 127, al
jmp warm60

;LED hi?n th? th?i gian 
led proc 
    push ax         	;B?o v? giá tr? thanh ghi AX, DX vì l?nh MUL dùng 2 thanh ghi này
    push dx 
    mov si, 64h     	;64(hex) = 100(dec)
    mov ax, hour    	;AX = gi?
    mul si          		;Nhân AX v?i 100
    add ax, minute 	;C?ng AX v?i phút
    out 199, ax    	;C?ng 199 nh?n thanh ghi AX(hex) in ra dex 
    pop dx 
    pop ax
    ret
led endp    

;Hàm timer 
timer proc
    mov al, cl;    ;AL ch?a giá tr? phút tr??c ?ó

    ;N?p th?i gian h? th?ng vào thanh ghi CH = gi?, CL = phút, DH = giây, DL = mili giây
    mov ah, 2ch
    int 21h
    call led
    
    cmp cl, al     	;So sánh phút tr??c ?ó và hi?n t?i
    jne incMin     	;N?u 2 giá tr? khác nhau thì t?ng phút
    jmp ok
    incMin:       		;T?ng phút
        add minute, 1h
        cmp minute, 3ch 		;So sánh phút v?i 3c<hex) = 60(dec)
        je incHour          		;N?u phút = 60 thì t?ng gi?
        jmp ok
        incHour:  	;T?ng gi?
            mov minute, 0h  	;Reset phút
            add hour, 1h 
    ok: ret
timer endp




