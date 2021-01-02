/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class SanPham implements Serializable{
    private static int stMa = 10000;
    private int ma;
    private String ten;
    private double donGia;

    public SanPham() {
        ma = stMa++;
    }

    public SanPham(String ten, double donGia) {
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
        SanPham.stMa = stMa;
    }
    
    
}
