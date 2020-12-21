include 'emu8086.inc'
#start=Traffic_Lights.exe#

waiting MACRO c, d 
    mov dx, d
    mov cx, c
    mov ah, 86h
    int 15h
ENDM

org 100h       
jmp start
;                   xvdx vdxv dxvd  
;              FEDC_BA98_7654_3210
s0     dw      0000_0010_0100_1100b
s1     dw      0000_0010_0100_1010b
s2     dw      0000_0010_0110_0001b
s3     dw      0000_0010_0101_0001b
s4     dw      0000_0011_0000_1001b
s5     dw      0000_0010_1000_1001b
s6     dw      0000_1000_0100_1001b
s7     dw      0000_0100_0100_1001b

sit_end = $         



START:
mov si, offset s0

continue:
    mov ah, 2Ch
    int 21h


    cmp cx, 0000_0110_0001_1110b     ; kiem tra gio ch:gio , cl : phut , 6h30
    jl thapdiem     ; cx < 6:30     
  
    cmp cx, 0001_0111_0001_1110b     ; kiem tra gio ch:gio , cl : phut , 23h30
    jg thapdiem     ; cx > 23:30   
    

; tu 6h30 den 23h30          
binhthuong:          

    mov ax, [si]
    out 4, ax     
    waiting 0216h, 0EC0h ;doi 35s = 0216_0EC0h microsecond  
    add si, 2
    mov ax, [si]
    out 4, ax
    waiting 2Dh, 0C6C0h ; wait 3s = 002D_C6C0h microsecond
    add si, 2
    
    cmp si, sit_end
    jb binhthuong
    mov si, offset s0
    jmp continue  
    
    

; tu 23h30 den 6h30                    
thapdiem:      
    ; nhay 3 lan 1 s
    ; tat 1/6s bat 1/6 -> 1s nhay 3 lan
    mov ax, 0000_0100_1001_0010b  ;bat tat ca den vang
    out 4, ax
    waiting 2h, 8B0Ah   ;doi 1/6s = 0002_8B0Ah microsecond
    xor ax, ax; ax=0 -> tat tat ca den
    out 4, ax
    waiting 2h, 8B0Ah   ;doi 1/6s

    jmp continue
              
         
ret

END