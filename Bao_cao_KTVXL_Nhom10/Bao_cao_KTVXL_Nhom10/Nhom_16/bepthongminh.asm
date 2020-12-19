#start=thermometer.exe#
#start=led_display.exe#
#make_bin#
name "thermo"

hour dw 0h     	;Khoi tao gio phut la doubleword vi hien thi LED can dung thanh ghi 16bit
minute dw 0h 

mov ax, cs
mov ds, ax
mov ah, 2ch    	;Nap thoi gian he thong luc bat dau bat bep
int 21h
;Duy tri 100oC trong 1h
boil:
call timer	 ;Goi chuong trinh con ?em thoi gian
cmp hour, 1h    ;Gio > 1 thi chuyen sang giu am 80oC
jge warm80

in al, 125      	;Lay nhiet ?o hien tai cua bep tu cong 125 -> AL
cmp al, 100     ;AL <= 100 thi tat bep, nguoc lai bat bep
jle on1        	;Dieu khien bep bang cong 127

off1:           	;Tat bep
mov al, 0
out 127, al
jmp boil 	;Quay lai de duy tri nhiet do

on1:            	;Bat bep
mov al, 1
out 127, al 
jmp boil	;Quay lai de duy tri nhiet ?o

;Duy tri 80oC trong 2h
warm80:

call timer
cmp hour, 3h   ;Gio > 3 thi chuyen sang giu am 60oC
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

;Duy tri 60oC
warm60:         ;Vong lap vo han

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

;LED hien thi thoi gian 
led proc 
    push ax         	;Bao ve gia tri thanh ghi AX, DX vi lenh MUL dung 2 thanh ghi này
    push dx 
    mov si, 64h     	;64(hex) = 100(dec)
    mov ax, hour    	;AX = gio
    mul si          		;Nhan AX voi 100
    add ax, minute 	;Cong AX voi phut
    out 199, ax    	;Cong 199 nhan thanh ghi AX(hex) in ra dex 
    pop dx 
    pop ax
    ret
led endp    

;Hàm timer 
timer proc
    mov al, cl;    ;AL chua gia tri phut truoc do
  
    ;Nap thoi gian he thong vao thanh ghi CH = gio, CL = phut, DH = giay, DL = mili giay
    mov ah, 2ch
    int 21h
    call led
    
    cmp cl, al     	;So sanh phut truoc ?o va hien tai
    jne incMin     	;Neu 2 gia tri khac nhau thi tang phut
    jmp ok
    incMin:       		;Tang phut
        add minute, 1h
        cmp minute, 3ch 		;So sanh phut voi 3c<hex) = 60(dec)
        je incHour          		;Neu phut = 60 thi tang gio
        jmp ok
        incHour:  	;Tang gio
            mov minute, 0h  	;Reset phut
            add hour, 1h 
    ok: ret
timer endp
