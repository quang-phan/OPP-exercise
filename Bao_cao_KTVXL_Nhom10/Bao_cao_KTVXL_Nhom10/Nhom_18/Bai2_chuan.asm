#start=thermometer.exe#
#start=led_display.exe#
#make_bin#

name "bepdun"

gio dw 0h     ;do led hien thi su dung thanh ghi 16bit
phut dw 0h  ; nen ta khoi tao gio phut doubleword
mov ax, cs
mov ds, ax
mov ah, 2ch    ;Nhap thoi gian he thong bat dau
int 21h

;Bep soi trong 1 gio dong ho
soi:
    call dongho
    cmp gio, 1h    ; neu gio > 1 thi chuyen sang giu am 80oC
    jge am80do
    in al, 125      ;Bep bat vatat lien tuc 
    cmp al, 100     ;Nhiet do <= 100 thi bat bep, lon hon thi tat bep
    jle bat         
    tat:           
        mov al, 0
        out 127, al
        jmp soi
    bat:           
        mov al, 1
        out 127, al 
        jmp soi   

;Duy tri nhiet do o 80oC trong 2h
am80do:
    call dongho
    cmp gio, 3h    ;Gio > 3 thi chuyen sang giu am bep 60oC
    jge am60do
    in al, 125
    cmp al, 80
    jle bat2
    tat2:           
        mov al, 0
        out 127, al
        jmp am80do
    bat2:       
        mov al, 1
        out 127, al
        jmp am80do  

;Duy tri nhiet do o 60oc
am60do:         ; duy tri nho vong lap vo han 
     call dongho
     in al, 125
     cmp al, 60
     jle bat3
     tat3:       
        mov al, 0
        out 127, al
        jmp am60do
     bat3:        
        mov al, 1
        out 127, al
        jmp am60do

dongHo proc
    mov al, cl;    ;AL chua gia tri phut truoc do
    ;Nap thoi gian he thong
    mov ah, 2ch
    int 21h
    call led    
    cmp cl, al     ;So sanh gia tri phut truoc do va phut hien tai
    jne tangPhut     ;Neu 2 gia tri khac nhau thi tang phut
    jmp nhay
    tangPhut:        ;Tang phut
        add phut, 1h
        cmp phut, 3ch     ;So sanh phut voi 3c<hex) = 60(dec)
        je tangGio          ;Neu = 60 thi tang gio
        jmp nhay
        tangGio:   ;Tang gio
            mov phut, 0h  ;Reset phut
            add gio, 1h 
    nhay: ret
dongHo endp 

;Led hien thi thoi gian             
led proc 
    push ax         ; mul se ghi de ax nen can push ax
    push dx 
    mov si, 64h     ;64(hex) = 100(dec)
    mov ax, gio    ;AX = gio
    mul si          ;Nhan AX voi 100
    add ax, phut  ;Cong AX voi phut
    out 199, ax     ;Cong 199 nhan thanh ghi AX(hex) in ra dex 
    pop dx 
    pop ax
    ret
led endp    
