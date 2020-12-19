; controlling external device with 8086 microprocessor.
; realistic test for c:\emu8086\devices\Traffic_Lights.exe

#start=Traffic_Lights.exe#

name "traffic"




.Model small
.Stack 100H
.Data
; GYR GYR GYR GYR  
R01 DW 0000_0010_0000_1000b
R03 DW 0000_0000_0100_0001b
R05 DW 0000_0000_0000_0000b
R1 DW 0000_0011_0000_1100b
R2 DW 0000_0010_1000_1010b
R3 DW 0000_1000_0110_0001b
R4 DW 0000_0100_0101_0001b
R5 DW 0000_0100_1001_0010b
; FEDC_BA9 876 543 210
all_red equ 0000_0010_0100_1001b
PORT EQU 4 ; output port

;wait 3 seconds (3 million microseconds)
WAIT_3_SEC_BX EQU 2Dh       
WAIT_3_SEC_DX EQU 0C6C0h

;wait 32 seconds (32 million microseconds)    
WAIT_32_SEC_BX EQU 1E8h
WAIT_32_SEC_DX EQU 4800h 

;wait 1/3 seconds (1/3 million microseconds)
WAIT_13_SEC_BX EQU 4h
WAIT_13_SEC_DX EQU 93E0h

.code
; define a macro
waitMacro macro t1, t2
mov cx, t1
mov dx, t2
mov ah, 86h
int 15h
waitMacro endm

main proc
; initilize the ds and es registers
mov ax, @Data
mov ds,ax

; set lights to Red for all direction
mov ax, all_red
out PORT, ax
waitMacro WAIT_3_SEC_BX, WAIT_3_SEC_DX 


Start:
    ; lay thoi gian tu he thong 
    mov ah, 2ch    ; Chuc nang so 2Ch: doc thoi gian
    int 21h        ; Goi ngat
    
    cmp ch, 06
    jl toi
    je sosanh1 
    cmp ch, 23
    jg toi
    je sosanh2
    jmp sang
    sosanh2:
        cmp cl,30
        jg toi
    jmp sang    
    sosanh1: 
        cmp cl,30
        jl toi
    
        
    
    Sang:
        lea si, R1
        mov ax, [si]
        out PORT, ax

        waitMacro WAIT_32_SEC_BX, WAIT_32_SEC_DX 
        ; nhap nhay xanh trong 3s cuoi
        mov bl,9 
            Lap:
                
                lea si, R01
                mov ax, [si]
                out PORT, ax
                
                lea si, R1
                mov ax, [si]
                out PORT, ax

                waitMacro WAIT_13_SEC_BX, WAIT_13_SEC_DX
                 
                sub bl,1
                cmp bl,0
                jnz lap  

        lea si, R2
        mov ax, [si]
        out PORT, ax

        waitMacro WAIT_3_SEC_BX, WAIT_3_SEC_DX

        lea si, R3
        mov ax, [si]
        out PORT, ax
        waitMacro WAIT_32_SEC_BX, WAIT_32_SEC_DX
        ; nhap nhay xanh trong 3s cuoi tan so 
        mov bl,9 
            Lap1:
            
                lea si, R03
                mov ax, [si]
                out PORT, ax
                
                lea si, R3
                mov ax, [si]
                out PORT, ax   

                waitMacro WAIT_13_SEC_BX, WAIT_13_SEC_DX
 
                sub bl,1
                cmp bl,0
                jnz lap1 

        lea si, R4
        mov ax, [si]
        out PORT, ax

        waitMacro WAIT_3_SEC_BX, WAIT_3_SEC_DX
        jmp Start
        ;

    Toi:
        lea si, R5
        mov ax, [si]
        out PORT, ax
        
        lea si, R05
        mov ax, [si]
        out PORT, ax

        waitMacro WAIT_13_SEC_BX, WAIT_13_SEC_DX 
           

    jmp Start
; end program
mov ah, 4CH
int 21H
main endp
end main
