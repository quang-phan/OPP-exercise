include 'emu8086.inc'
#start=thermometer.exe#
#make-bin#  
#start=led_display.exe#
#make_bin#
name "thermo"

; add your code here
turn MACRO x
    mov al, x
    out 127, al
endm

waiting MACRO c, d
    mov cx, c
    mov dx, d
    mov ah, 86h
    int 15h
endm

org 100h 

turn 1
;in ax, 127
;call print_num_uns 
mov bx,0  
init:  ; bep duoc dun den 100 do
    in al, 125
    cmp al, 100
    jl init      ; <100

mov cx, 3600; doi 3600s
start100:       ; bat dau dun soi 1h o 100 do
    mov dl,100 ; bx bieu thi second
    inc bx     ; tang bx -> bx + 1
    push bx
    mov ax,bx
    mov bl,60 
    div bl    ; ah la minutes, al la second
    mov dh,ah
    mul dl 
    add al,dh
    out 199,ax   ; 3 chu dau la minutes, 2 so cuoi la second
    pop bx
    pusha
    mov dl, 100
    call GiuAm
    waiting 0fh, 4240h; doi 1s  
    ;in ax, 127
    ;call print_num_uns
    popa
    loop start100

mov cx, 7200; doi 7200s  
mov bx,0
start80:  ; giu am o 80 do trong 2h
    mov dl,100
    inc bx 
    push bx
    mov ax,bx
    mov bl,60 
    div bl
    mov dh,ah
    mul dl
    add al,dh
    out 199,ax
    pop bx
    pusha
    mov dl, 80
    call GiuAm
    waiting 0fh, 4240h; doi 1s  
    ;in ax, 127
    ;call print_num_uns
    popa
    loop start80

start60:        ; giu am vo thoi han o 60 do
    mov dl,100
    inc bx 
    push bx
    mov ax,bx
    mov bl,60 
    div bl
    mov dh,ah
    mul dl
    add al,dh
    out 199,ax
    pop bx
    mov dl, 60
    call GiuAm
;in ax, 127
;call print_num_uns
jmp start60

ret

GiuAm PROC
    in al, 125
    
    cmp al, dl  
    jl low      ; khi > dl tat bep
    
    cmp al, dl
    jle ok
    jg high     ; khi < dl bap bep
    
    low:
    turn 1
    jmp ok
    
    high:
    turn 0
    jmp ok
    
    ok: 
    ret
endp
