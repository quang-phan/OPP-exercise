#start=Traffic_Lights.exe#
       
.Model small
.Stack 100H
.Data 

;     FEDC BA98 7654 3210
;           xvdx vdxv dxvd
;Huong tay phai
R1  DW 0000_0010_0110_0001b   ; xanh sang
R2  DW 0000_0010_0100_0001b   ; xanh tat
R3  DW 0000_0010_0101_0001b   ; vang sang
;Huong tren

R4  DW 0000_0011_0000_1001b   ; xanh sang
R5  DW 0000_0010_0000_1001b   ; xanh tat 
R6 DW 0000_0010_1000_1001b   ; vang sang

;Huong phai
R7  DW 0000_1000_0100_1001b   ; xanh sang
R8  DW 0000_0000_0100_1001b   ; xanh tat
R9  DW 0000_0100_0100_1001b   ; vang sang

;Huong duoi

R10 DW 0000_0010_0100_1100b   ; xanh sang
R11 DW 0000_0010_0100_1000b   ; xanh tat
R12 DW 0000_0010_0100_1010b   ; vang sang

R13 DW 0000_0100_1001_0010b   ; 4 huong bat den vang

PORT EQU 4

WAIT_3_SEC_CX EQU 2Dh
WAIT_3_SEC_DX EQU 0C6C0h

WAIT_32_SEC_CX EQU 1E8h
WAIT_32_SEC_DX EQU 4800h  

.code

waiting macro c, d
    mov cx, c
    mov dx, d
    mov ah, 86h
    int 15h       
waiting endm   
             
main proc
; initilize the ds and es registers
mov ax, @Data
mov ds,ax

CONTINUE:
mov ah, 2Ch
int 21h

;mov cx, 0000_0110_0001_1101b; test thap diem
;mov cx, 0001_0111_0001_1111b

cmp cx, 0000_0110_0001_1110b;ch ? 6, cl ? 30
jl thapDiem; cx < 6:30
cmp cx, 0001_0111_0001_1110b;ch ? 23, cl ? 30
jg thapDiem; cx > 23:30

Caodiem:
lea si, R1         ; Bat den xanh huong ben phai
mov ax, [si]
out PORT, ax
waiting WAIT_32_SEC_CX, WAIT_32_SEC_DX
;Nhap nhay den xanh voi tan so 3Hz
mov cx,30
lap:lea si,R2      ; Tat den xanh huong ben phai
     mov ax, [si]
     out PORT, ax
     lea si,R1
     mov ax, [si]
     out PORT, ax
loop lap:
;Chuyen han sang den vang  
lea si, R3         ; Bat den vang huong ben phai
mov ax, [si]
out PORT, ax
waiting WAIT_3_SEC_CX, WAIT_3_SEC_DX
lea si, R4
mov ax, [si]
out PORT, ax 
waiting WAIT_32_SEC_CX, WAIT_32_SEC_DX  

;Nhap nhay den xanh voi tan so 3Hz
mov cx,30
lap1: lea si,R5
     mov ax, [si]
     out PORT, ax
     lea si,R4
     mov ax, [si]
     out PORT, ax
loop lap1:
;Chuyen han sang den vang  
lea si, R6
mov ax, [si]
out PORT, ax
waiting WAIT_3_SEC_CX, WAIT_3_SEC_DX
lea si, R7
mov ax, [si]
out PORT, ax
waiting WAIT_32_SEC_CX, WAIT_32_SEC_DX
;Nhap nhay den xanh voi tan so 3Hz
mov cx,30
lap2: lea si,R8
     mov ax, [si]
     out PORT, ax
     lea si,R7
     mov ax, [si]
     out PORT, ax
loop lap2:
;Chuyen han sang den vang     
lea si, R9
mov ax, [si]
out PORT, ax
waiting WAIT_3_SEC_CX, WAIT_3_SEC_DX
lea si, R10
mov ax, [si]
out PORT, ax
waiting WAIT_32_SEC_CX, WAIT_32_SEC_DX
;Nhap nhay den vang voi tan so 3Hz
mov cx,30
lap3: lea si,R11
     mov ax, [si]
     out PORT, ax
     lea si,R10
     mov ax, [si]
     out PORT, ax
loop lap3:
;Chuyen han sang den vang     
lea si, R12
mov ax, [si]
out PORT, ax
waiting WAIT_3_SEC_CX, WAIT_3_SEC_DX

jmp continue

thapDiem:
lea si, R13
mov ax, [si];bat tat ca cac den vang
out 4, ax
waiting 5h, 1615h;doi 1/3s = 0002_1615h microsecond
xor ax, ax; ax=0 -> tat tat ca cac den
out 4, ax
waiting 2h, 8B0Ah;doi 1/3s

jmp continue

; end program
mov ah, 4CH
int 21H
main endp
end main
