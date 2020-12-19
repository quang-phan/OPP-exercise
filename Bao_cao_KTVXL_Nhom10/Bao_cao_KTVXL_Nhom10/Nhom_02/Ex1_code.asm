#start=Traffic_Lights.exe#
name "traffic"

.Model small
.Stack 100H
.Data
    ;          GYRG YRGY RGYR
    R1 DW 0000_0011_0000_1100b
    R2 DW 0000_0010_1000_1010b
    R3 DW 0000_1000_0110_0001b
    R4 DW 0000_0100_0101_0001b
    ;     FEDC BA98 7654 3210
    all_red     EQU 0000_0010_0100_1001b
    all_yellow  EQU 0000_0100_1001_0010b
    all_off     EQU 0000_0000_0000_0000b;
    PORT        EQU 4 ; output port

    ; time constants (in secs)
    BLINK_3HZ_CX   EQU 05h
    BLINK_3HZ_DX   EQU 1615h
    WAIT_3_SEC_CX  EQU 2Dh
    WAIT_3_SEC_DX  EQU 0C6C0h
    WAIT_35_SEC_CX EQU 216h
    WAIT_35_SEC_DX EQU 0EC0h

.code

; time uait
waitMacro macro cx_sec, dx_sec
    mov cx, cx_sec
    mov dx, dx_sec
    mov ah, 86h
    int 15h
waitMacro endm

blinkWaitMacro macro cx_sec, dx_sec
    mov cx, cx_sec
    mov dx, dx_sec
    mov ah, 86h
    int 15h
main proc
    ;Khoi tao thanh ghi DS, ES
    mov ax, @Data
    mov ds,ax
    ;Lay thoi gian he thong 
    mov ah, 2ch
    int 21h
    mov dx, cx
    ;--night_mode--(6:30)--day_mode--(23:30)--night_mode--
    cmp dx, 171Eh         
    jl KiemTra ;Kiem tra thoi gian trong khoang 6:30->23:30 
    jg ChuTrinhThapDiem

    KiemTra:
       mov ah, 2ch
       int 21h
       mov dx, cx
       cmp dx, 061Eh
       jg ChuTrinhBinhThuong
       jl ChuTrinhThapDiem
    DayMode:    
       call ChayChuTrinhBinhThuong
    ChuTrinhThapDiem:
        mov ax, all_yellow
        out PORT, ax
        waitMacro  BLINK_3HZ_CX, BLINK_3HZ_DX
        mov ax, all_off
        out PORT, ax
        waitMacro  BLINK_3HZ_CX, BLINK_3HZ_DX
        jmp ChuTrinhThapDiem
    ; end program
    mov ah, 4CH
    int 21H
main endp
;--------Delay------
ChayChuTrinhBinhThuong proc 
    mov ax, all_red
    out PORT, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    Start:
    lea si, R1
    mov ax, [si]
    out PORT, ax
    waitMacro WAIT_35_SEC_CX, WAIT_35_SEC_DX
    lea si, R2
    mov ax, [si]
    out PORT, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    lea si, R3
    mov ax, [si]
    out PORT, ax
    waitMacro WAIT_35_SEC_CX, WAIT_35_SEC_DX
    lea si, R4
    mov ax, [si]
    out PORT, ax
    waitMacro WAIT_3_SEC_CX, WAIT_3_SEC_DX
    jmp Start
    ret 
RunDayMode endp    
end main