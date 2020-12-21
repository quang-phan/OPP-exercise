
include 'emu8086.inc'
#start=thermometer.exe#
#make-bin#  
#start=led_display.exe#
#make_bin#
name "thermo"


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

mov bx,0  
init:  
    in al, 125
    cmp al, 100
    jl init      

mov cx, 3600
start100:       
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
    mov dl, 100
    call GiuAm
    waiting 0fh, 4240h  
    
    popa
    loop start100

mov cx, 7200
mov bx,0
start80:  
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
    waiting 0fh, 4240h
    popa
    loop start80

start60:        
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

jmp start60

ret

GiuAm PROC
    in al, 125
    
    cmp al, dl  
    jl low      
    
    cmp al, dl
    jle ok
    jg high     
    
    low:
    turn 1
    jmp ok
    
    high:
    turn 0
    jmp ok
    
    ok: 
    ret
endp
 