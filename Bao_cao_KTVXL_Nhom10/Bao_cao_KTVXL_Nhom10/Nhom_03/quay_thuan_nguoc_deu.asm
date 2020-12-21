

#start=stepper_motor.exe#
#start=led_display.exe#

#make_bin#


jmp MAIN
 
dem_vong_quay dw 0

quay_thuan    db 0000_0110b
              db 0000_0100b    
              db 0000_0011b
              db 0000_0010b

quay_nguoc    db 0000_0011b
              db 0000_0001b    
              db 0000_0110b
              db 0000_0010b


MAIN:
    mov si, 0
    mov ax, 0
    out 199, ax
    mov di, 0

    cai_dat_quay_thuan:
    mov bx, offset quay_thuan
    jmp buoc_ke
    cai_dat_quay_nguoc:
    mov bx, offset quay_nguoc

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

    mov di, 0   ; khi het 1 vong thi xoay nguoc
    inc dem_vong_quay
    mov ax,dem_vong_quay 
    out 199,ax 

    cmp bx, offset quay_thuan    ; het 1 vong thi quay nguoc
    je  cai_dat_quay_nguoc
    jne cai_dat_quay_thuan