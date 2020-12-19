; controlling external device with 8086 microprocessor.
; realistic test for c:\emu8086\devices\Traffic_Lights.exe
	
#start=Traffic_Lights.exe#


waiting macro i,j
    mov dx, j
    mov cx, i
    mov ah, 86h
    int 15h
endm

org 100h
jmp start

s0               dw      0000_0010_0100_1100b
s1               dw      0000_0010_0100_1010b
s2               dw      0000_0010_0110_0001b
s3               dw      0000_0010_0101_0001b
s4               dw      0000_0011_0000_1001b
s5               dw      0000_0010_1000_1001b
s6               dw      0000_1000_0100_1001b
s7               dw      0000_0100_0100_1001b
sit_end = $

Start:
mov si, offset s0

continue:
    mov ah, 2Ch
    int 21h
    
    cmp cx, 0000_0110_0001_1110b
    jl thapdiem 
     
     cmp cx, 0001_0111_0001_1110b
    jg thapdiem       
    
binhthuong:
    mov ax, [si]
    out 4, ax
    waiting 0216h, 0EC0h
    add si, 2
    mov ax, [si]
    out 4, ax
    waiting 2Dh, 0C6C0h
    add si, 2
    
    cmp si, sit_end
    jb binhthuong
    mov si, offset s0
    jmp continue
thapdiem:
    mov ax, 0000_0100_1001_0010b
    out 4, ax
    waiting 2h, 8B0Ah
    xor ax, ax 
    out 4, ax
    waiting  2h, 8B0Ah
    jmp continue
  ret
  END
