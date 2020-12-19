#start=thermometer.exe#

#make_bin#

name "thermo"
.Data
    TimeHour    DB  0
    TimeMin     DB  0
    TimeSec     DB  0
.Code     
; Nhap du lieu vao thanh ghi
MAIN Proc
mov ax, @Data
mov ds, ax
; Thiet dat hen gio
mov     ah,2Ch
int     21h
mov     TimeHour,ch
mov     TimeMin,cl
mov     TimeSec,dh
add     TimeHour,1

buoc1:      
    in      al, 125   
    cmp     al, 100
    jg      tat                     ; kiem tra nhiet do
    jl      bat
    bat:
        mov     al, 1
        out     127, al             ; bat bep  
        jmp     kiemtra1

    tat:
        mov     al, 0
        out     127, al             ; tat bep
        jmp     kiemtra1             

    kiemtra1:
        mov     ah,2Ch
        int     21h
        cmp     TimeHour,ch         ; so sanh thoi gian
        je      checkmin
        jne     buoc1
    checkmin:
        cmp     TimeMin,cl
        jne     buoc1
        je      checksec
    checksec:
        cmp     TimeSec,dh
        jne     buoc1
        je      thietdat
        
    thietdat:  
        mov     al, 0
        out     127, al
        in      al, 125
        cmp     al, 80
        jl      tmp
        jmp     thietdat
    tmp:
        mov     ah,2Ch
        int     21h
        mov     TimeHour,ch         ; thiet dat hen gio buoc 2
        mov     TimeMin,cl
        mov     TimeSec,dh
        add     TimeHour,2
       
buoc2:
    in      al, 125   
    cmp     al, 80
    jg      tat2                    ; kiem tra nhiet do
    jl      bat2
    bat2:                                                                                                                        
        mov     al, 1
        out     127, al             ; bat bep  
        jmp     kiemtra2

    tat2:
        mov     al, 0
        out     127, al             ; tat bep
        jmp     kiemtra2             

    kiemtra2:
        mov     ah,2Ch
        int     21h
        cmp     TimeHour,ch
        je      checkmin2
        jne     buoc2
    checkmin2:
        cmp     TimeMin,cl
        jne     buoc2
        je      checksec2
    checksec2:
        cmp     TimeSec,dh
        jne     buoc2
        je      thietdat2
        
    thietdat2:
        mov     al, 0
        out     127, al

buoc3:           
    in      al, 125
    cmp     al, 60
    jg      tat3
    jl      bat3
    bat3:
        mov     al, 1
        out     127, al             ; bat bep.  
        jmp     lap

    tat3:
        mov     al, 0
        out     127, al
        jmp     lap                 ; tat bep.
    lap:
        jmp     buoc3               ; lap vo han
MAIN Endp
END MAIN