#start=Traffic_Lights.exe#
name "trafficlight"


.Model small
.Stack 100H
.Data
 ; cac trang thai cua lights
 R1 DW 0000_0011_0000_1100b
 R2 DW 0000_0010_1000_1010b
 R3 DW 0000_1000_0110_0001b
 R4 DW 0000_0100_0101_0001b

dendo equ 0000_0010_0100_1001b; cai dat den tat ca mau do
denvang equ 0000_0100_1001_0010b; tat ca vang

PORT EQU 4 
 ;thoi gian cho
 cho_35_S_CX EQU 0216h
 cho_35_S_DX EQU 0EC0h
 cho_3_S_CX EQU 2Dh
 cho_3_S_DX EQU 0C6C0h
 cho_x_S_CX EQU 2h
 cho_x_S_DX EQU 8B0Ah

.code
;CHO macro
CHO macro t1, t2
 mov cx, t1
 mov dx, t2
 mov ah, 86h
 int 15h
CHO endm

main proc
 mov ax, @Data
 mov ds,ax
 ; tat ca den cua cac huong deu mau do
  mov ax, dendo
 out PORT, ax
 CHO cho_3_S_CX, cho_3_S_DX
 
 START:
 mov ah, 2Ch
 int 21h
 ; so sanh thoi f
 cmp cx, 0000_0110_0001_1110b
 jl ThapDiem		; cx < 6:30
 cmp cx, 0001_0111_0001_1110b
 jg ThapDiem		; cx > 23:30
 
 BinhThuong:
  lea si, R1
  mov ax, [si]
  out PORT, ax
  CHO cho_35_S_CX, cho_35_S_DX
  
  lea si, R2
  mov ax, [si]
  out PORT, ax
  CHO cho_3_S_CX, cho_3_S_DX
  
  lea si, R3
  mov ax, [si]
  out PORT, ax
  CHO cho_35_S_CX, cho_35_S_DX
  
  lea si, R4
  mov ax, [si]
  out PORT, ax
   CHO cho_3_S_CX, cho_3_S_DX
  
  jmp START
 
 Thapdiem:
  mov ax, denvang; tat ca den deu mau vang
  out PORT, ax
  CHO cho_x_S_CX, cho_x_S_DX
              
  xor ax, ax; tat den ve mau den
  out PORT,ax
  
  jmp START
 
 
main endp
end main