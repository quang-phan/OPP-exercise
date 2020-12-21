
#start=thermometer.exe#     
#start=led_display.exe#


#make_bin#

name "thermo"

hour_st db 0
minute_st db 0 
hour db 0
minute db 0 
time_troi db 0 
tmp db 0


mov ax, cs
mov ds, ax

mov ah,2ch
int 21h
mov hour_st, ch
mov minute_st, cl
mov al,0 
out 199, al

start:
mov al,1
out 127,al

in al,125
cmp al,100
jge soi
jl start

soi:
   in al, 125
   cmp al,100
   jl low
   jg heigh 
   
        
am:
   in al, 125
   cmp al,80
   jl low
   jg heigh 
   
giu:    
   in al, 125
   cmp al,60
   jl low
   jg heigh 
    
low:
    mov al,1
    out 127,al
    jmp time
heigh:
    mov al,0
    out 127,al
    jmp time

time:
    mov ah,2ch
    int 21h   
    sub ch, hour_st 
    sub cl, minute_st
    mov al, ch
    mov di,60
    mul di
    add al, cl  ; al la so phut da troi qua
    mov time_troi,al
    mov bl,al   ; gan 1 bien tam thoi la bl de luu gia tri al
    cmp al,60    
    jg hour_    ; neu AL > 60 jump den nhan~ hour
outLed:
    out 199, al                                
             
    cmp time_troi, 60
    jl soi
    cmp time_troi, 180
    jl am
    jmp giu
    
hour_:
    add al,40       ;ta cong al voi 40, vi du 61 phut thi chuyen thanh 101...etc   
    
    sub bl,60       ; while(bl>60){ bl -= 60;  al += 40}
    cmp bl,60
    jl  outLed
    jmp hour_