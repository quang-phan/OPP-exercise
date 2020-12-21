#start=thermometer.exe#

#make_bin#

name "thermo"

mov ax, cs
mov ds, ax

; Dieu chinh bep o 100 do    
                                
mov ch,3ch   ; ch de luu phut
mov cl,00h  ; cl de luu giay

start:
cmp ch, 00h
jz start80    

cmp cl,00h    
jz control_time

dec cl
 
in al, 125                                            -
cmp al, 100
jl  low


cmp al, 100
jle  ok
jg   high

low:
mov al, 1
out 127, al   ; bat bep
jmp ok

high:
mov al, 0
out 127, al   ; tat bep 

ok:jmp start  
; gan lai cl(giay) = 3ch(60)
; giam ch(phut) di 1
control_time: 
      mov cl,3ch
      dec ch
      jmp start

; dieu chinh bep o 80 do

start80:

mov ch,3ch
mov cl,00h 

start1:
cmp ch, 00h
jz start60  

cmp cl,00h
jz control_time1

dec cl
in al, 125
cmp al, 80
jl  low1

cmp al, 80
jle  ok1
jg   high1

low1:
mov al, 1
out 127, al   ; bat bep
jmp ok1

high1:
mov al, 0
out 127, al   ; tat bep 

ok1:jmp start1  
; gan lai cl(phut) = 3ch(60)
; giam ch(gio) di 1
control_time1: mov cl,3ch
      dec ch
      jmp start1
      
; dieu chinh bep o 60 do

start60:
  
start2:
in al, 125
cmp al, 60
jl  low2

cmp al, 60
jle  ok2
jg   high2

low2:
mov al, 1
out 127, al   ; bat bep
jmp ok2

high2:
mov al, 0
out 127, al   ; tat bep 

ok2:jmp start2   
; gan lai cl(phut) = 3ch(60)
; giam ch(gio) di 1
temp2: mov cl,3ch
       dec ch
       jmp start2 