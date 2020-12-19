; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt
include 'emu8086.inc'
#start=Traffic_Lights.exe#
name "traffic"

waiting MACRO c, d
    pusha
    mov cx, c
    mov dx, d
    mov ah, 86h
    int 15h
    popa
ENDM

org 100h       
jmp start
;                  xvdx vdxv dxvd  
;             FEDC_BA98_7654_3210
s0    dw      0000_0010_0100_1100b
s1    dw      0000_0010_0100_1010b
s2    dw      0000_0010_0110_0001b
s3    dw      0000_0010_0101_0001b  
s4    dw      0000_0011_0000_1001b
s5    dw      0000_0010_1000_1001b
s6    dw      0000_1000_0100_1001b
s7    dw      0000_0100_0100_1001b

sit_end = $
; add your code here
START:
mov si, offset s0

CONTINUE:
mov ah, 2Ch
int 21h


cmp cx, 0000_0110_0001_1110b;ch ? 6, cl ? 30
jl thapDiem; cx < 6:30
cmp cx, 0001_0111_0001_1110b;ch ? 23, cl ? 30
jg thapDiem; cx > 23:30

caoDiem:          

mov ax, [si]
out 4, ax
;waiting 32s
waiting 1E8h, 4800h

mov cx, 9;3s = 9 * (1/6 + 1/6) s 
nhapNhayXanh:
push ax
and ax, 1111_0110_1101_1011b; turn off all green light
out 4, ax  
waiting 2h, 8B0Ah;wait 1/6s
pop ax 
out 4, ax
waiting 2h, 8B0Ah;wait 1/6s
loop nhapNhayXanh

add si, 2
mov ax, [si]
out 4, ax
waiting 2Dh, 0C6C0h; wait 3s = 002D_C6C0h microsecond

add si, 2
cmp si, sit_end
jb continue
mov si, offset s0
jmp continue

thapDiem:
mov ax, 0000_0100_1001_0010b;turn on all yellow lights
out 4, ax
waiting 2h, 8B0Ah;wait 1/6s = 0002_8B0Ah microsecond
xor ax, ax; ax=0 -> turn off all lights
out 4, ax
waiting 2h, 8B0Ah;wait 1/6s

jmp continue
         
ret

END
