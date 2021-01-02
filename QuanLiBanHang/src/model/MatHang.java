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
public class MatHang implements Serializable{
    private static int stMa = 10000;
    private int ma;
    private String ten;
    private double donGia;

    public MatHang() {
        ma = stMa++;
    }

    public MatHang(String ten, double donGia) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(ten);
        if(!matcher.find()) throw new ArithmeticException("Ten trong");
        if(donGia < 0) throw new ArithmeticException("don gia sai");
        this.ten = ten;
        this.donGia = donGia;
        ma = stMa++;
    }

    public static int getStMa() {
        return stMa;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public double getDonGia() {
        return donGia;
    }

    public static void setStMa(int stMa) {
        MatHang.stMa = stMa;
    }
    
    
    
}
