.Model small
.Stack 100H
.Data
#start=Traffic_Lights.exe#                                   
R1 DW                     0000_0011_0000_1100b    ; xanh 1
R2 DW                     0000_0010_1000_1010b   
R3 DW                     0000_1000_0110_0001b    ; xanh 2
R4 DW                     0000_0100_0101_0001b
R5 dw                     0000_0100_1001_0010b    ;all vang nhay
all_null       dw         0000_0000_0000_0000     ; all trang
R11 dw                    0000_0010_0000_1000b    ; xanh 1 nhay 
R33 dw                    0000_0000_0100_0001b    ; xanh 2 nhay
;                         FEDC_BA9 876 543 210
all_red          equ     0000_0010_0100_1001b
; time constants (in secs)
WAIT_3_SEC_CX   EQU   2Dh
WAIT_3_SEC_DX   EQU   0C6C0h
WAIT_45_SEC_CX   EQU   2EAh
WAIT_45_SEC_DX   EQU   A540h
WAIT_03_SEC_CX   EQU   1h
WAIT_03_SEC_DX   EQU   86a0h
WAIT_32_SEC_CX   EQU   1e8h
WAIT_32_SEC_DX   EQU   4800h   
                                                       
.code
; define a macro
waitMacro macro t1, t2
mov cx, t1
mov dx, t2
mov     ah, 86h
int     15h
waitMacro endm

;--------  

nhay_3hz macro t1, t2
lea si, t2
mov ax, [si]
out 4, ax
waitMacro WAIT_03_SEC_CX, WAIT_03_SEC_DX
lea si, t1
mov ax, [si]
out 4, ax
waitMacro WAIT_03_SEC_CX, WAIT_03_SEC_DX
lea si, t2
mov ax, [si]
out 4, ax
waitMacro WAIT_03_SEC_CX, WAIT_03_SEC_DX
lea si, t1
mov ax, [si]
out 4, ax
waitMacro WAIT_03_SEC_CX, WAIT_03_SEC_DX
lea si, t2
mov ax, [si]
out 4, ax
waitMacro WAIT_03_SEC_CX, WAIT_03_SEC_DX
lea si, t1
mov ax, [si]
out 4, ax
waitMacro WAIT_03_SEC_CX, WAIT_03_SEC_DX
nhay_3hz endm                           


;-----------

den_xanh macro t1  
lea si,t1
mov ax,[si]
out 4,ax
waitMacro WAIT_32_SEC_CX, WAIT_32_SEC_DX
den_xanh endm  
;--------

main proc

mov ax, @Data
mov ds,ax

mov ax,all_red
out 4,ax
jmp time 

ngay:
    den_xanh  R1
    nhay_3hz R1,R11  
    nhay_3hz R1,R11
    nhay_3hz R1,R11
    lea si,R2
    mov ax,[si]
    out 4, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX  
    
    den_xanh  R3
    nhay_3hz R3,R33  
    nhay_3hz R3,R33
    nhay_3hz R3,R33
    
    lea si,R4
    mov ax,[si]
    out 4, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    
    jmp time  
    
    
dem:
    mov di,0
    nhay_3hz R5 ,  all_null
    jmp time
    
    
time:
    mov ah, 2ch
    int 21h
    cmp cx,061eh   ;so sanh voi 6:30
    jl dem
    cmp cx,171eh   ; so sanh voi 11:30
    jg dem
    jmp ngay 
     
end main

