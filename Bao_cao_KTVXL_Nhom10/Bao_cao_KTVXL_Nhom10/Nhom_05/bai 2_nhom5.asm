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
time macro 
 inc bx
 push bx
 
 mov ax,bx 
 xor bx,bx
 div minute ; ah la phut, al la giay
 mov bl,ah 
 xor ah,ah
 div minute
 mov dl,ah
 xor ah,ah
 mul decimal
 add ax,dx
 mul decimal
 add ax,bx
 out 199,ax
 pop bx 
endm 
 
jmp init

minute  db 60
decimal db 100


init:
turn 1
mov ax,0
out 199,ax  
c:
in al, 125
cmp al, 100
jl c

mov cx, 60; doi 60s 

start100:
time
push cx
mov dl,100
call giuam  
waiting 0Fh, 4240h; doi 1s  
;in ax, 127
;call print_num_uns
pop cx
loop start100

turn 0

mov cx, 120; doi 120s  
xor bx,bx

doi:
in al,125
cmp al,80
jge doi

start80:
time
push cx
mov dl, 80
call GiuAm
waiting 0Fh, 4240h; doi 1s 
;in ax, 127
;call print_num_uns
pop cx
loop start80

turn 0

waitrun:
in al,125
cmp al,60
jge waitrun

xor bx,bx 

start60:
time 
mov dl, 60
call GiuAm
;in ax, 127
;call print_num_uns  
waiting 0Fh, 4240h  
jmp start60


  
giuam proc
     
    in al, 125
    cmp al, dl
    jl low 
    jmp high
    
    low:
    turn 1
    jmp ok
    
    high:
    turn 0
    jmp ok
    
    ok: 
      ret
  endp  

