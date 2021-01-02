/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class KhachHang implements Serializable{
    private static int stMa = 10000;
    private int ma;
    private String hoTen, diaChi, nhom;

    public KhachHang() {
        ma = stMa++;
    }

    public KhachHang(String hoTen, String diaChi, String nhom) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(hoTen);
        if(!matcher.find()) throw new ArithmeticException("ten trong");
        matcher = pattern.matcher(diaChi);
        if(!matcher.find()) throw new NumberFormatException("dia chi trong");
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.nhom = nhom;
        ma = stMa++;
    }
    
    public void nhap(String hoTen, String diaChi, String nhom) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(hoTen);
        if(!matcher.find()) throw new ArithmeticException("ten trong");
        matcher = pattern.matcher(diaChi);
        if(!matcher.find()) throw new ArithmeticException("dia chi trong");
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.nhom = nhom;
        ma = stMa++;
    }

    public static int getStMa() {
        return stMa;
    }

    public int getMa() {
        return ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNhom() {
        return nhom;
    }

    public static void setStMa(int stMa) {
        KhachHang.stMa = stMa;
    }
    
    

    @Override
    public String toString() {
        return hoTen+"\n"+diaChi+"\n"+nhom; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
