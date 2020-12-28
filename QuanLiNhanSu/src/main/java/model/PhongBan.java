/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class PhongBan implements Serializable{
    private static int stMa = 100;
    private int ma;
    private String ten, moTa;
    private double heSo;

    public PhongBan() {
        ma = stMa++;
    }

    public PhongBan(String ten, String moTa, double heSo) {
        this.ten = ten;
        this.moTa = moTa;
        this.heSo = heSo;
        ma = stMa++;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public double getHeSo() {
        return heSo;
    }

    public static void setStMa(int stMa) {
        PhongBan.stMa = stMa;
    }
    
    public void setMoTa(String moTa){
        this.moTa = moTa;
    }
    
    public void setHeSo(String heSo){
        this.heSo = Double.parseDouble(heSo);
    }
}
