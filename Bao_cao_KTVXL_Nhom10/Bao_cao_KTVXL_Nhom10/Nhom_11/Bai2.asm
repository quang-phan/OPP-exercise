#start=thermometer.exe#
#start=led_display.exe#

#make_bin#    

name "bep_dun_nuoc_ml"
  
.model small
.data
    hour dw 0h ; Luu lai thoi gian dun theo gio
    minute dw 0h ; Luu lai thoi gian dun theo phut
    second dw 0h ; Luu lai thoi gian dun theo giay
    heaterMode db 0 ; Luu lai che do dun: 0 = Dun soi 100 do, 1 = Giu am 80 do, 2 = Giu am 60 do
    
    heaterTempWhenProgStart db 0 ; Nhiet do cua bep khi bat
                 
    ; Hang thoi gian cho delay macro (3s)
    WAIT_3_SEC_CX EQU 2Dh
    WAIT_3_SEC_DX EQU 0C6C0h
.code

; Macro delay chuong trinh
delayMacro macro t1, t2
    mov cx, t1
    mov dx, t2
    mov ah, 86h
    int 15h
delayMacro endm
         
main proc
    mov ax, cs
    mov ds, ax
               
    ; Kiem tra bep da bat hay chua (Phan nang cao)
    checkHeater:
        in al, 125
        mov heaterTempWhenProgStart, al
        delayMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
        mov ah, 2ch
        int 21h
        in al, 125
        cmp al, heaterTempWhenProgStart
        jle on

      
    bolingAndKeep100:
        call timer
        mov [heaterMode], 0 ; Gan che do dun = 0: Dun soi den 100 do   
        cmp hour, 1h
        jge keepWarm80
        
        in al, 125
        cmp al, 100
        jle on
        jg off
        jmp bolingAndKeep100
    
    keepWarm80: 
        call timer  
        mov [heaterMode], 1 ; Gan che do dun = 1: Giu am 80 do
        cmp hour, 3h
        jge keepWarm60
        
        in al, 125
        cmp al, 80
        jle on
        jg off
        jmp keepWarm80
        
    keepWarm60:
        call timer
        mov [heaterMode], 2 ; Gan che do dun = 2: Giu am 60 do
        in al, 125
        cmp al, 60
        jle on
        jg off
        jmp keepWarm60
    
    ; Bat bep dun bang cach gui bit 1 ra cong 127
    ; So sanh che do bep dun de nhay ve nhan lenh thich hop    
    on:
        mov al, 1
        out 127, al
        
        cmp heaterMode, 0
        jge bolingAndKeep100
        
        cmp heaterMode, 1
        jge keepWarm80
        
        cmp heaterMode, 2
        jge keepWarm60
    
    
    ; Tat bep dun bang cach gui bit 1 ra cong 127
    ; So sanh che do bep dun de nhay ve nhan lenh thich hop    
    off:
        mov al, 0
        out 127, al
        
        cmp heaterMode, 0
        jge bolingAndKeep100
        
        cmp heaterMode, 1
        jge keepWarm80
        
        cmp heaterMode, 2
        jge keepWarm60             
                                            
main endp

; Bo dem thoi gian
timer proc
    mov al, dh
    mov ah, 2ch
    int 21h
    
    call showLed
    
    cmp dh, al
    jg incSec
    jmp ok
    
    incSec:
        add second, 1h
        cmp second, 3ch ; 3ch (hex) = 60 (dec)
        je incMin
        jmp ok
    
    incMin: 
        mov second, 0h ; reset giay ve 0
        add minute, 1h
        cmp minute, 3ch ; 3ch (hex) = 60 (dec)
        je incHour
        jmp ok
    
    incHour:
        mov minute, 0h ; reset phut ve 0
        add hour, 1h
    
    ok:
        ret
timer endp
    
; Hien thi den led
showLed proc
    push ax
    push dx
    mov si, 64h ; 64h = 100 (dec)
    mov ax, hour ; chuyen gio vao ax de nhan 100
    mul si
    add ax, minute
    out 199, ax
    pop dx
    pop ax
    ret
showLed endp
end main