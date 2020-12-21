; controlling external device with 8086 microprocessor.
; realistic test for c:\emu8086\devices\Traffic_Lights.exe

#start=Traffic_Lights.exe#

name "traffic"

;khoi tao, tat ca deu den do  

mov     ax, all_red
out     4, ax

batdau:
mov si, offset situation ;tuyen 1 , 3 di
mov bh, 0h
lap:
mov ax, [si]
out 4, ax
inc bh

; den xanh 32s (32 trieu microseconds, do tre he thong)
mov     cx, 01e8h    ;   0x216ec0h = 35000000 micro   
mov     dx, 04800h
mov     ah ,86h
int     15h
mov     bl, 0h
cmp     bh, 2 
jz      nhay2
jmp     nhay1
 
;den xanh nhay khi con 3s
nhay2: ;tuyen duong 2, 4
mov     ax, green2
out     4, ax   
mov     cx, 03h        
mov     dx, 0d090h
mov     ah ,86h
int     15h

mov     ax, reset_3
out     4, ax
mov     cx, 03h        
mov     dx, 0d090h
mov     ah ,86h
int     15h
inc     bl
cmp     bl, 12
jb      nhay2
jmp denvang
 
nhay1: ;tuyen duong 1, 3 
mov     ax, green1
out     4, ax   
mov     cx, 03h        
mov     dx, 0d090h
mov     ah ,86h
int     15h

mov     ax, reset_2
out     4, ax
mov     cx, 03h        
mov     dx, 0d090h
mov     ah ,86h
int     15h
inc     bl
cmp     bl, 12
jb      nhay1

; den vang
denvang:
mov ax, [si]
add si, 2 ; (den vang )
mov ax, [si]
out 4, ax
;den vang sang 3s
mov     cx, 02dh     ;0x2dc6c0h = 3000000 micro
mov     dx, 0c6c0h
mov     ah ,86h
int     15h

add si, 2 ;situation ke tiep (tuyen 2, 4 di ) 
cmp si, sit_end
jb lap: ;lap lai den o tuyen 2, 4

;kiem tra thoi gian, sau 1 chu ki di
mov ah, 2ch
int 21h

;so sanh thoi gian, gio >= 23h30 va gio <= 6h30
cmp     cx, 0171eh  ; 17h = 23, 1eh = 30
jb      cmp2        ;
jmp     thapdiem
;so sanh thoi gian, gio <= 6h30
cmp2: 
cmp     cx, 061eh   ;6h = 6, 1eh = 30
jb      thapdiem    ; khung gio thap diem
jmp batdau:         ; khung gio binh thuong

;gio thap diem
thapdiem:
mov     bl, 0h ; khoi tao bo dem chu ki nhay cua den vang 
; den vang sang 3 lan 1 s
lap2:
inc     bl
mov     ax, all_yel_gre  ; tat ca den vang o cac duong
out     4, ax   
mov     cx, 03h        
mov     dx, 0d090h
mov     ah ,86h
int     15h

mov     ax, reset_
out     4, ax
mov     cx, 03h        
mov     dx, 0d090h
mov     ah ,86h
int     15h

cmp     bl, 03h
jnz     lap2
mov     ah, 2ch
int     21h
;so sanh thoi gian, gio >= 23h30 va gio <= 6h30
cmp     cx, 0171eh  ; 17h = 23, 1eh = 30
jb      cmp3
jmp     thapdiem
;so sanh thoi gian, gio <= 6h30
cmp3: 
cmp     cx, 061eh   ;6h = 6, 1eh = 30
jb      thapdiem
jmp batdau:



;                        FEDC_BA98_7654_3210
situation        dw      0000_0011_0000_1100b ;xanh 1, 3
s1               dw      0000_0010_1000_1010b ;vang 1,3
s2               dw      0000_1000_0110_0001b ;xanh 2, 4
s3               dw      0000_0100_0101_0001b ;vang 2,4
sit_end = $


all_red          equ     0000_0010_0100_1001b
all_yel_gre      equ     0000_0100_1001_0010b
green1           equ     0000_0011_0000_1100b
reset_2          equ     0000_0010_0000_1000b
green2           equ     0000_1000_0110_0001b 
reset_3          equ     0000_0000_0100_0001b
reset_           equ     0000_0000_0000_0000b

