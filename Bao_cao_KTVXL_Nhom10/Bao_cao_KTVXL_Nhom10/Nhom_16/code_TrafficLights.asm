#start=Traffic_Lights.exe#



; CONSTANTS


; time constants (microseconds)
WAIT_3_SEC_CX   EQU   2Dh                  ; 2Dh0C6C0h = 3,000,000            
WAIT_3_SEC_DX   EQU   0C6C0h          

WAIT_32_SEC_CX   EQU   1E8h                ; 1E84800h = 32,000,000
WAIT_32_SEC_DX   EQU   4800h

WAIT_ONE_SIXTH_SEC_CX   EQU   2h           ; 28B0Ah = 166,666 
WAIT_ONE_SIXTH_SEC_DX   EQU   8B0Ah
 

; lights's status
                          ; BA98_7654_3210
; turning on green                           
down_green_others_red   equ 0010_0100_1100b 
right_green_others_red  equ 0010_0110_0001b
up_green_others_red     equ 0011_0000_1001b
left_green_others_red   equ 1000_0100_1001b

; turning on blink
down_blink_others_red   equ 0010_0100_1000b
right_blink_others_red  equ 0010_0100_0001b
up_blink_others_red     equ 0010_0000_1001b
left_blink_others_red   equ 0000_0100_1001b

; turning on yellow
down_yellow_others_red  equ 0010_0100_1010b
right_yellow_others_red equ 0010_0101_0001b
up_yellow_others_red    equ 0010_1000_1001b
left_yellow_others_red  equ 0100_0100_1001b

; blinking yellow 
all_yellow       equ      0100_1001_0010b
no_lights        equ      0000_0000_0000b



; MACROS


; suspend system  
waitMacro macro m1, m2
    mov cx, m1
    mov dx, m2
    mov ah, 86h
    int 15h   
waitMacro endm


; blinking green light
blinkGreen3Seconds macro g1, g2 
    LOCAL blinkGreen
    mov bh, 9
    blinkGreen:
    dec bh
    mov ax, g2 
    out 4, ax
    waitMacro WAIT_ONE_SIXTH_SEC_CX, WAIT_ONE_SIXTH_SEC_DX
    mov ax, g1 
    out 4, ax
    waitMacro WAIT_ONE_SIXTH_SEC_CX, WAIT_ONE_SIXTH_SEC_DX 
    cmp bh, 0
    jg blinkGreen                               ; jump if great
blinkGreen3Seconds endm



;blinking yellow light
blinkYellow3Seconds:
    mov bh, 4
    blinkYellow:
    dec bh
    mov ax, all_yellow
    out 4, ax
    waitMacro WAIT_ONE_SIXTH_SEC_CX, WAIT_ONE_SIXTH_SEC_DX
    mov ax, no_lights
    out 4, ax
    waitMacro WAIT_ONE_SIXTH_SEC_CX, WAIT_ONE_SIXTH_SEC_DX
    cmp bh, 0
    jg blinkYellow
    endm
    
    
    
; MAIN


start:

  
    ; get time and compare
    mov ah, 2ch
    int 21h
    cmp ch, 23                                  ; ch = gio
    je cmpMinute                                ; jump if equal
    jl cmpHour                                  ; jump if low
    
    cmpMinute:
        cmp cl, 30                              ; cl = phut
        jge blinkYellow3Seconds                 ; jump if great or equal
        jmp green
    
    cmpHour:
        cmp ch, 6
        jl blinkYellow3Seconds
        jg green
        cmp cl, 30
        jge green
        jl blinkYellow3Seconds 
    
    green:
    
    ; 0, 1, 2
    mov ax, down_green_others_red
    out 4, ax
    waitMacro WAIT_32_SEC_CX, WAIT_32_SEC_DX
    blinkGreen3Seconds down_blink_others_red, down_green_others_red
    mov ax, down_yellow_others_red
    out 4, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    
    ; 3, 4, 5
    mov ax, right_green_others_red 
    out 4, ax
    waitMacro WAIT_32_SEC_CX, WAIT_32_SEC_DX
    blinkGreen3Seconds right_blink_others_red, right_green_others_red
    mov ax, right_yellow_others_red
    out 4, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    
    ; 6, 7, 8
    mov ax, up_green_others_red
    out 4, ax
    waitMacro WAIT_32_SEC_CX, WAIT_32_SEC_DX
    blinkGreen3Seconds up_blink_others_red, up_green_others_red
    mov ax, up_yellow_others_red
    out 4, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    
    ; 9, A, B
    mov ax, left_green_others_red
    out 4, ax
    waitMacro WAIT_32_SEC_CX, WAIT_32_SEC_DX
    blinkGreen3Seconds left_blink_others_red, left_green_others_red
    mov ax, left_yellow_others_red
    out 4, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    
jmp start
