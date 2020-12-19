; this short program for emu8086 shows how to keep constant temperature
; using heater and thermometer (between 60° to 80°),
; it is assumed that air temperature is lower 60°.

; thermometer.exe is started automatically from c:\emu8086\devices.
; it is also accessible from the "virtual devices" menu of the emulator.

#start=thermometer.exe# 
#start=led_display.exe#

; temperature rises fast, thus emulator should be set to run at the maximum speed.

; if closed, the thermometer window can be re-opened from emulator's "virtual devices" menu.



#make_bin#

name "thermo"

; set data segment to code segment:
mov ax, cs
mov ds, ax  
xor ax, ax  
out 199, ax 
mov bx, 0


start: 
; doc nhiet do va thoi gian hien tai
in al, 125
mov ah, 2Ch
int 21h  

; neu nuoc soi, dat moc thoi gian = bx
; neu da co moc thoi gian(bx > 0) bo qua buoc nay
cmp bx, 0
jg continue
cmp al, 100 
jge ganmoc  
mov cx, 0
jmp low 

ganmoc:
mov bx, cx 
         
         
continue:
sub cx, bx ; tinh thoi gian da troi qua ke tu moc thoi gian bx 
cmp cx, 0000_0000_0000_0001b  ;1minute
;cmp cx, 0000_0001_0000_0000b  1hour
jl dun100


cmp cx, 0000_0000_0000_0011b  ;3minute
;cmp cx, 0000_0011_0000_0000b  3hour
jl dun80
jge dun60


dun100:
cmp al, 99
jl  low

cmp al, 100
jl  ok
jge   high 

dun80:
cmp al, 79
jl low

cmp al, 80
jl ok
jge high  

dun60:
cmp al, 59
jl low

cmp al, 60
jl ok
jge high

low:
mov al, 1
out 127, al   ; turn heater "on".
jmp ok

high:
mov al, 0
out 127, al   ; turn heater "off".     
   
ok:
mov ax, cx
out 199, ax
jmp start   ; endless loop.



   



