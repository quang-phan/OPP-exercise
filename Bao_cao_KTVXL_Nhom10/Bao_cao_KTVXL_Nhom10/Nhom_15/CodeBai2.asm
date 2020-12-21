#start=thermometer.exe#
#start=led_display.exe#
#make_bin#

name "thermo"

gio dw 0h    
phut dw 0h 

mov ax, cs
mov ds, ax

mov ah, 2ch    
int 21h

;Duy tri 100oC trong 1h
boil:

call time
cmp gio, 1h    
jge warm80

in al, 125     
cmp al, 100     
jle on1         

off1:          
mov al, 0
out 127, al
jmp boil 

on1:            
mov al, 1
out 127, al 
jmp boil

;Duy tri 80oC trong 2h
warm80:

call time
cmp gio, 3h    
jge warm60

in al, 125
cmp al, 80
jle on2

off2:           
mov al, 0
out 127, al
jmp warm80

on2:       
mov al, 1
out 127, al
jmp warm80  

;Duy tri 60oC
warm60:        

call time
in al, 125
cmp al, 60
jle on3

off3:       
mov al, 0
out 127, al
jmp warm60

on3:        
mov al, 1
out 127, al
jmp warm60




time proc
    mov al, dh;             
  
    ; DH = giay, CL = phut, CH = gio
    mov ah, 2ch
    int 21h
    call led                ;Hien thi led
    
    cmp dh, al              
    jne incMin              
    jmp ok
    incMin:                 
        add phut, 1h
        cmp phut, 3ch     
        je incgio          
        jmp ok
        incgio:            
            mov phut, 0h  
            add gio, 1h 
    ok: ret
time endp   
 
;Led hien thi            
led proc 
    push ax         
    push dx 
    mov si, 64h     
    mov ax, gio    
    mul si         
    add ax, phut 
    out 199, ax      
    pop dx 
    pop ax
    ret
led endp    

