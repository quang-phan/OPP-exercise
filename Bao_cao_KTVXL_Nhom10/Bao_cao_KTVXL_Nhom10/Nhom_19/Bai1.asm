include 'emu8086.inc'
#start=Traffic_Lights.exe#
name "traffic"

waiting MACRO c, d
    mov cx, c
    mov dx, d
    mov ah, 86h
    int 15h
ENDM

org 100h       
jmp start
;                  xvdx vdxv dxvd  
;             FEDC_BA98_7654_3210
s0    dw      0000_0011_0000_1100b
s1    dw      0000_0100_1001_0010b
s2    dw      0000_1000_0110_0001b
s3    dw      0000_0100_1001_0010b
sit_end = $
; add your code here
START:
mov si, offset s0

CONTINUE:
mov ah, 2Ch
int 21h

;mov cx, 0000_0110_0001_1101b; test thap diem
;mov cx, 0001_0111_0001_1111b

cmp cx, 0000_0110_0001_1110b;ch ? 6, cl ? 30
jl thapDiem; cx < 6:30
cmp cx, 0001_0111_0001_1110b;ch ? 23, cl ? 30
jg thapDiem; cx > 23:30

caoDiem:          

mov ax, [si]
out 4, ax
;waiting 0216h, 0EC0h; wait 35s = 0216_0EC0h microsecond
waiting 98h, 9680h; wait 10s

add si, 2
mov ax, [si]
out 4, ax
waiting 2Dh, 0C6C0h; wait 3s = 002D_C6C0h microsecond

add si, 2
cmp si, sit_end
jb caoDiem
mov si, offset s0
jmp continue

thapDiem:
mov ax, s1;turn on all yellow lights
out 4, ax
waiting 2h, 8B0Ah;wait 1/6s = 0002_8B0Ah microsecond
xor ax, ax; ax=0 -> turn off all lights
out 4, ax
waiting 2h, 8B0Ah;wait 1/6s

jmp continue
         
ret

END





