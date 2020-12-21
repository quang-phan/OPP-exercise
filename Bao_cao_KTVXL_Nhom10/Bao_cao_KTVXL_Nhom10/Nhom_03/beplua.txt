#start=thermometer.exe#
#start=LED_Display.exe#

.Model small
.Stack 100h
.Data
    gioiHan db 100
    thoiGian     dW 1
    phut db 0
    giay db 0

.Code
    jmp main
        
main:
    mov ax, @Data
    mov ds, ax
    mov es, ax 
    mov bx, 2
    
doc_thoi_gian:    
    mov ax, thoiGian
    out 199, ax
    
    mov ah, 2ch
    int 21h
    mov phut, cl
    mov giay, dh
    
lap:   
    mov ah, 2ch 
    int 21h    
    cmp phut, cl
    jne giam_so_phut
    cmp thoiGian,0
    je chuyen_trang_thai  

kiem_tra_nhiet_do:    
    ;kiem tra nhiet do
    in al, 125

    cmp al, gioiHan
    jl  low

    cmp al, gioiHan
    jle  lap
    jg   high
    
    jmp lap
    
low:
    mov al, 1
    out 127, al   ; bat bep
    jmp lap

high:
    mov al, 0
    out 127, al   ; tat bep 
    jmp lap 
    
giam_so_phut:

    dec thoiGian
     
    mov phut, cl 
    
    mov ax, thoiGian 
    out 199, ax 
    
    jmp kiem_tra_nhiet_do

chuyen_trang_thai:
cmp bx, 3

jb dun_80:
je giu_am60:

dun_80:
mov gioiHan, 80
mov thoiGian, 120
mov bx, 3
jmp doc_thoi_gian  

giu_am60:
mov gioiHan, 60
mov thoiGian, 3
jmp doc_thoi_gian         
endmain: 
    mov al, 0
    out 127, al
    mov ah, 4ch
    int 21h