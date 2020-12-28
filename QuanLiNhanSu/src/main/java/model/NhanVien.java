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
public class NhanVien implements Serializable{
    private static int stMa = 1000;
    private int ma, bacLuong, ngayCong = 0;
    private String ten, diaChi, sdt;
    private PhongBan phongBan;
    
    public NhanVien(){
        ma = stMa++;
    }
    
    public NhanVien(String ten, String diaChi, String sdt, int bacLuong, PhongBan phongBan){
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.bacLuong = bacLuong;
        this.phongBan = phongBan;
        ma = stMa++;
    }

    public int getMa() {
        return ma;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }
    
    

    public static void setStMa(int stMa) {
        NhanVien.stMa = stMa;
    }
      
    
}
