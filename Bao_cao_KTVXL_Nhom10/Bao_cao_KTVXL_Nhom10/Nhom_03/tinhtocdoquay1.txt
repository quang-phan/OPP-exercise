#start=stepper_motor.exe#
#start=led_display.exe#

#make_bin#

jmp MAIN

;BIEN
hienthi_thoigian_batdau   db 'thoi gian: $'
dau_haicham               db 58
dau_enter                 db 13,10,'$'

hangchuc        db 0
donvi           db 0

gio_batdau      db 0
phut_batdau     db 0
giay_batdau     db 0
tictac_batdau   db 0

dem_vong_quay    dw 0

quay_thuan    db 0000_0110b
              db 0000_0100b    
              db 0000_0011b
              db 0000_0010b
              
MAIN:  
    mov si, 0
    mov ax, 0
    out 199, ax
    mov di, 0
    
    call lay_thoi_gian
    call lay_thoi_gian
    cai_dat_quay_thuan:
    mov bx, offset quay_thuan

    buoc_ke:
        wait:   in al, 7           ; kiem tra bit 7 cua step motor
            test al, 10000000b
            jz wait

        mov al, [bx+si] ; lay buoc tiep theo
        out 7, al
        inc si

        cmp si, 4   ; kiem tra da het mot chu ky chua
        jb buoc_ke
        mov si, 0   ; khi het 1 chu ky thi quay ve

        inc di      ; tang so lan chay 1 chu ky
        cmp di, 8   ; kiem tra xem da quay het 1 vong chua
        jb buoc_ke
        
        call lay_thoi_gian
        mov di, 0   ; khi het 1 vong thi xoay nguoc
        inc dem_vong_quay
        mov ax,dem_vong_quay 
        out 199,ax 

        jmp ketthuc
; ket thuc ham

        
;ham in thoi gian
lay_thoi_gian proc
    mov ah, 2CH
    int 21h
    mov gio_batdau, ch
    mov phut_batdau, cl
    mov giay_batdau, dh
    mov tictac_batdau, dl
    
    mov ah, 9h
    lea dx, hienthi_thoigian_batdau
    int 21h
    
    call in_gio 
    mov ah, 2
    mov dl, dau_haicham
    int 21h
    
    call in_phut
    mov dl, dau_haicham
    int 21h
    
    call in_giay
    mov dl, dau_haicham
    int 21h
    
    call in_tictac
    mov ah, 9
    lea dx, dau_enter
    int 21h
    ret
    lay_thoi_gian endp

;cac ham lay thoi gian
in_gio proc
    push bx
    mov ax, 0
    mov al, gio_batdau
    mov bl, 10
    idiv bl
    mov hangchuc, al
    mov donvi, ah
    add hangchuc,48
    add donvi,48
    
    mov ah, 2
    mov dl, hangchuc
    int 21h
    mov dl, donvi
    int 21h
    pop bx
    ret
    in_gio endp

in_phut proc
    push bx
    mov ax, 0
    mov al, phut_batdau
    mov bl, 10
    idiv bl
    mov hangchuc, al
    mov donvi, ah
    add hangchuc,48
    add donvi,48
    
    mov ah, 2
    mov dl, hangchuc
    int 21h
    mov dl, donvi
    int 21h 
    pop bx
    ret
    in_phut endp

in_giay proc
    push bx
    mov ax, 0
    mov al, giay_batdau
    mov bl, 10
    idiv bl
    mov hangchuc, al
    mov donvi, ah
    add hangchuc,48
    add donvi,48
    
    mov ah, 2
    mov dl, hangchuc
    int 21h
    mov dl, donvi
    int 21h
    pop bx
    ret
    in_giay endp

in_tictac proc
    push bx
    mov ax, 0
    mov al, tictac_batdau
    mov bl, 10
    idiv bl
    mov hangchuc, al
    mov donvi, ah
    add hangchuc,48
    add donvi,48
    
    mov ah, 2
    mov dl, hangchuc
    int 21h
    mov dl, donvi
    int 21h
    pop bx
    ret
    in_tictac endp 

ketthuc: