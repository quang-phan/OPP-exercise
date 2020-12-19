#start=Traffic_Lights.exe#


;the rush hour             BA98_7654_3210
south_green_other_red  equ 0010_0100_1100b  ;only south light is green, others are red
east_green_other_red   equ 0010_0110_0001b
north_green_other_red  equ 0011_0000_1001b
west_green_other_red   equ 1000_0100_1001b

south_blink_other_red  equ 0010_0100_1000b  ;only south light blinks, others are red
east_blink_other_red   equ 0010_0100_0001b
north_blink_other_red  equ 0010_0000_1001b  
west_blink_other_red   equ 0000_0100_1001b

south_yellow_other_red equ 0010_0100_1010b  ;only south light is yellow, others are red
east_yellow_other_red  equ 0010_0101_0001b
north_yellow_other_red equ 0010_1000_1001b
west_yellow_other_red  equ 0100_0100_1001b

;other hours
all_yellow    equ    0100_1001_0010b ;all lanes'light are yellow
no_lights     equ    0000_0000_0000b ;all lanes'lights are off


;wait function  
waitMacro macro t1, t2
    mov cx, t1
    mov dx, t2
    mov ah, 86h
    int 15h   
waitMacro endm

;blink green light
blinkGreen3Sec macro s1, s2 
    LOCAL blinkGreen
    mov bh, 9
    blinkGreen:
    dec bh
    mov ax, s2 
    out 4, ax
    waitMacro 2h, 8B0Ah  ;2_8B0Ah = 166_666 microseconds= 1/6 s
    mov ax, s1 
    out 4, ax 
    waitMacro 2h, 8B0Ah
    cmp bh, 0
    jg blinkGreen
blinkGreen3Sec endm

;blink yellow light
blinkYellow3Hz:
    mov bh, 3
    blinkYellow:
    dec bh
    mov ax, all_yellow
    out 4, ax
    waitMacro 2h, 8B0Ah
    mov ax, no_lights
    out 4, ax
    waitMacro 2h, 8B0Ah
    cmp bh, 0
    jg blinkYellow
    endm
        

START:  
    ;get time and compare
    mov ah, 2ch
    int 21h
    cmp ch, 23
    je cmpMin
    jl cmpHr
    cmpMin:
        cmp cl, 30
        jge blinkYellow3Hz
        jmp green
    cmpHr:
        cmp ch, 6
        jl blinkYellow3Hz
        jg green
        cmp cl, 30
        jl blinkYellow3Hz
        jge green 
    
    
    green: 
    
    ; 0,1,2
        
    mov ax, south_green_other_red
    out 4, ax
    ;waitMacro 98h, 9680h  ;98_9680h = 10_000_000
    waitMacro 1E8h, 4800h ;1E8_4800h = 32_000_000 microseconds 
    blinkGreen3Sec south_blink_other_red, south_green_other_red
    mov ax, south_yellow_other_red
    out 4, ax
    waitMacro 2Dh, 0C6C0h  ;2Dh_C6C0h = 3_000_000
    
        
    ; 3,4,5
    
    mov ax, east_green_other_red 
    out 4, ax
    waitMacro 1E8h, 4800h
    blinkGreen3Sec east_blink_other_red, east_green_other_red
    mov ax, east_yellow_other_red
    out 4, ax
    waitMacro 2Dh, 0C6C0h
    
        
    ; 6,7,8
    
    mov ax, north_green_other_red
    out 4, ax
    waitMacro 1E8h, 4800h
    blinkGreen3Sec north_blink_other_red, north_green_other_red
    mov ax, north_yellow_other_red
    out 4, ax
    waitMacro 2Dh, 0C6C0h
    
        
    ; 9,A,B
    
    mov ax, west_green_other_red
    out 4, ax
    waitMacro 1E8h, 4800h
    blinkGreen3Sec west_blink_other_red, west_green_other_red
    mov ax, west_yellow_other_red
    out 4, ax
    waitMacro 2Dh, 0C6C0h

       
jmp start