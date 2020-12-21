; this short program for emu8086 shows how to keep constant temperature
; using heater and thermometer (between 60° to 80°),
; it is assumed that air temperature is lower 60°.

; thermometer.exe is started automatically from c:\emu8086\devices.
; it is also accessible from the "virtual devices" menu of the emulator.

#start=thermometer.exe#

; temperature rises fast, thus emulator should be set to run at the maximum speed.

; if closed, the thermometer window can be re-opened from emulator's "virtual devices" menu.

   

#make_bin#

name "thermo"

; set data segment to code segment:
mov ax, cs
mov ds, ax                 

;macro   : Bat , tat heater
turn_ macro p1
    mov al,p1
    out 127,al
    
    endm 

 
start:

in al, 125

cmp al, 100
jl turn_on

                                 
u_number: 
in al,125

cmp al,100
jg u_100

u2:

in al,125

cmp al,80
jg u2
jmp u_80

u3: 
in al,125

cmp al,60
jg u3
jmp u_60

;; XOng
rett:
jmp start 


turn_on:
turn_ 1
jmp start
                                  
                                   ; U am o nhiet do 100 voi time= Cx (s)
u_100:
  
  ;; PUSH CX
                 ; delay 1s vxl
mov     cx, 0fh
mov     dx, 4240h
mov     ah, 86h
int     15h

mov cx,1 ; Thu nghiem voi loop= 1

turn_ 1
turn_ 0
  ;; POP CX
  

loop u_100

jmp u2 
    
u_80:           ; U am o nhiet do 80 voi time= Cx (s)
                 ; delay 1s vxl
mov     cx, 0fh
mov     dx, 4240h
mov     ah, 86h
int     15h
 
mov cx,1
 
turn_ 1
turn_ 0


loop u_80

jmp u3

u_60:   ; U am o nhiet do 60 voi time= Cx (s)
                 ; delay 1s vxl
mov     cx, 0fh
mov     dx, 4240h
mov     ah, 86h
int     15h

turn_ 1
turn_ 0
          
          
loop u_60 
jmp rett