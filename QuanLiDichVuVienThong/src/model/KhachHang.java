/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exeption.InputExeption;
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
    private String ten, diaChi, loai;

    public KhachHang() {
        ma = stMa++;
    }

    public KhachHang(String ten, String diaChi, String loai) throws InputExeption {
        
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(ten), 
                matcher1 = pattern.matcher(diaChi),
                matcher2 = pattern.matcher(loai);
        
        if(!matcher.find()) throw new InputExeption("ten trong");
        if(!matcher1.find()) throw new InputExeption("dia chi trong");
        if(!matcher2.find()) throw new InputExeption("loai khach hang trong");
        
        this.ten = ten;
        this.diaChi = diaChi;
        this.loai = loai;
        
        ma = stMa++;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getLoai() {
        return loai;
    }
    
    

    public static void setStMa(int stMa) {
        KhachHang.stMa = stMa;
    }
    
    
}
