#start=thermometer.exe#
#start=led_display.exe#
#make_bin#

name "thermo"

hour dw 0h     
minute dw 0h 
second dw 0h
mov ax, cs
mov ds, ax

mov ah, 2ch    
int 21h


boil:

call timer
cmp minute, 1h      
;cmp hour, 1h
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


warm80:

call timer
cmp minute, 3h      	
				  
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


warm60:         		 

call timer
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



timer proc
    mov al, dh;             
  
    
    mov ah, 2ch
    int 21h
    call led                   
    
    cmp dh, al              
    jne incSec              
    jmp ok  
    incSec:
        add second, 1h            
        cmp second, 3ch         
        je incMin
        jmp ok
        incMin:                 
            mov second, 0h             
            add minute, 1h        
            cmp minute, 3ch     
            je incHour               
            jmp ok
            incHour:            	
                mov minute, 0h   
                add hour, 1h 
    ok: ret

timer endp   
 
            
led proc 
    push ax                 
    push dx 
    mov si, 64h         	
    mov ax, minute    

    mul si              	
    add ax, second     

    out 199, ax         	 
    pop dx 
    pop ax
    ret
led endp    
 


