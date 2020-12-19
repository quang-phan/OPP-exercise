; controlling external device with 8086 microprocessor.
; realistic test for c:\emu8086\devices\Traffic_Lights.exe
; Copyright by Quang Minh - teacher Duy's student
#start=Traffic_Lights.exe#

name "traffic"


.Model small 
.Stack 100H 
.Data 

h       DB ?  ;ch
m       DB ?  ;cl
s       DB ?  ;dh 
                       
R1      DW              0000_0011_0000_1100b   
R2      DW              0000_0010_1000_1010b   
R3      DW              0000_1000_0110_0001b   
R4      DW              0000_0100_0101_0001b   
;                       FEDC_BA98_7654_3210 

N1      DW              0000_0010_0000_1000b    
N3      DW              0000_0000_0100_0001b

all_light        equ    0000_1111_1111_1111b
all_off          equ    0000_0000_0000_0000b
all_red          equ    0000_0010_0100_1001b
all_yellow       equ    0000_0100_1001_0010b 
PORT EQU  4    ; output port 
 
  ; time constants (in secs)
  WAIT_1_6_SEC_CX EQU   2h
  WAIT_1_6_SEC_DX EQU   08B0Bh
     
  WAIT_3_SEC_CX   EQU   2Dh   
  WAIT_3_SEC_DX   EQU   0C6C0h 
 
  WAIT_10_SEC_CX  EQU   98h   
  WAIT_10_SEC_DX  EQU   9680h 
  
  WAIT_32_SEC_CX  EQU   1E8h
  WAIT_32_SEC_DX  EQU   4800h   
.code 
; define a macro waitMacro 
waitMacro macro t1, t2   
mov cx, t1   
mov dx, t2   
mov ah, 86h   
int 15h    
endm 

flash1 macro  
  mov ax, R1
  out PORT, ax
  waitMacro WAIT_1_6_SEC_CX, WAIT_1_6_SEC_DX
  mov ax, N1
  out PORT, ax
  waitMacro WAIT_1_6_SEC_CX, WAIT_1_6_SEC_DX
endm

flash3 macro
  mov ax, R3
  out PORT, ax
  waitMacro WAIT_1_6_SEC_CX, WAIT_1_6_SEC_DX
  mov ax, N3
  out PORT, ax
  waitMacro WAIT_1_6_SEC_CX, WAIT_1_6_SEC_DX
endm 

main proc              
    ; initilize the ds and es registers   
mov ax, @Data   
mov ds,ax                                                                

Start:  

  mov ah, 2ch
  int 21h  
   
  mov h, ch
  mov m, cl
  mov s, dh
      
  cmp h, 23
  je Loop1
  jmp Loop2  

;Activate in 6h30-23h30
Daytime proc    
  mov ax, R1   
  out PORT, ax     
  waitMacro WAIT_32_SEC_CX, WAIT_32_SEC_DX 
  flash1
  flash1
  flash1
  flash1
  flash1
  flash1
  flash1
  flash1
  flash1 
    
  mov ax, R2   
  out PORT, ax                           
  waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX 
     
  mov ax, R3   
  out PORT, ax   
  waitMacro WAIT_32_SEC_CX, WAIT_32_SEC_DX 
  flash3
  flash3
  flash3
  flash3
  flash3
  flash3
  flash3
  flash3
  flash3
     
  mov ax, R4   
  out PORT, ax                               
  waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX

  jmp Start
Daytime endp

;Activate in 23h30-6h30
Nighttime proc 
  mov ax,all_yellow
  out PORT, ax
  waitMacro WAIT_1_6_SEC_CX, WAIT_1_6_SEC_DX
  mov ax,all_off
  out PORT, ax
  waitMacro WAIT_1_6_SEC_CX, WAIT_1_6_SEC_DX
  jmp Start
Nighttime endp

Loop1 proc
  cmp m,30
  jge Nighttime
  jmp Daytime
Loop1 endp   

Loop2 proc
  cmp h,6
  jl  Nighttime
  jmp Loop3
Loop2 endp

Loop3 proc
  cmp h,6
  jg  Daytime
  jmp Loop4
Loop3 endp

Loop4 proc
  cmp m,30
  jge Nighttime
  jmp Daytime
Loop4 endp

  ; end program   
mov ah, 4CH   
int 21H        
 
end main 