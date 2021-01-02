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
public class CongNhan implements Serializable{
    private static int stMa = 10000;
    private int ma;
    private String hoTen, diaChi, caSX;
    
    public CongNhan(){
        ma = stMa++;
    }

    public CongNhan(String hoTen, String diaChi, String caSX) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.caSX = caSX;
        ma = stMa++;
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

    public String getCaSX() {
        return caSX;
    }

    public static int getStMa() {
        return stMa;
    }

    public static void setStMa(int stMa) {
        CongNhan.stMa = stMa;
    }
    
    
}
