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

start:

in al, 125  ;doc du lieu tu cong 125 vao thanh ghi al

cmp al, 80  ;so sanh al vs 80
jb  low     ;neu al<80 thi di den nhan low

cmp al, 100  ;so sanh al vs 100
jbe  ok     ;neu al<=100 thi di den nhan ok
ja   high   ;neu al>100 thi di den nhan high

low:
mov al, 1   ;chuyen 1 vao thanh ghi al
out 127, al ;bat lo / ghi du lieu tu thanh ghi al ra cong 127
jmp ok      ;nhay vo dieu kien den nhan ok

high:
mov al, 0   ;chuyen 0 vao thanh ghi al
out 127, al ;tat lo / ghi du lieu tu thanh ghi al ra cong 127

ok:
jmp start   ;nhay vo dieu kien den nhan start


