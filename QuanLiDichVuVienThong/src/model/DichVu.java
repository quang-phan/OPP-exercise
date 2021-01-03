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
public class DichVu implements Serializable{
    private static int stMa = 100;
    private int ma;
    private String ten, donViTinh;
    private double giaCuoc;

    public DichVu() {
        ma = stMa++;
    }

    public DichVu(String ten,  double giaCuoc, String donViTinh) throws InputExeption {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(ten);
        if(!matcher.find()) throw new InputExeption("Ten trong");
        
        matcher = pattern.matcher(donViTinh);
        if(!matcher.find()) throw new InputExeption("don vi tinh trong");
        
        if(giaCuoc < 0) throw new NumberFormatException("gia cuoc am");
        
        this.ten = ten;
        this.donViTinh = donViTinh;
        this.giaCuoc = giaCuoc;
        ma = stMa++;
    }
    
    public void sua(double giaCuoc, String donVi) throws InputExeption{
        Pattern pattern = Pattern.compile("\\w+");
        
        Matcher matcher = pattern.matcher(donVi);
        if(!matcher.find()) throw new InputExeption("don vi tinh trong");
        
        if(giaCuoc < 0) throw new NumberFormatException("gia cuoc am");
        
        this.donViTinh = donVi;
        this.giaCuoc = giaCuoc;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public double getGiaCuoc() {
        return giaCuoc;
    }

    public static void setStMa(int stMa) {
        DichVu.stMa = stMa;
    }
    
    
    
}
