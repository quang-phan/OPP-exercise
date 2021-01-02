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
public class DuAn implements Serializable{
    private static int stMa = 10000;
    private int ma;
    private String tenDA, kieuDA, tong;
    
    public DuAn(){
        ma = stMa++;
    }
    
    public DuAn(String tenDA, String kieuDA, String tong){
        ma = stMa++;
        this.tenDA = tenDA;
        this.kieuDA = kieuDA;
        this.tong = tong;
    }

    public int getMa() {
        return ma;
    }

    public String getTenDA() {
        return tenDA;
    }

    public String getKieuDA() {
        return kieuDA;
    }

    public String getTong() {
        return tong;
    }

    public static int getStMa() {
        return stMa;
    }

    public static void setStMa(int stMa) {
        DuAn.stMa = stMa;
    }

    public void setKieuDA(String kieuDA) {
        this.kieuDA = kieuDA;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }
    
    
}
