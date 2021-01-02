/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class NhanVien implements Serializable{
    private static int stMa = 10000;
    private int ma;
    private String hoTen, diaChi, chuyenMon;
    private List<DuAn> tenDA;
    private List<String> viTri;
    private List<Integer> soNgayTG;
    
    
    public NhanVien(){
        ma = stMa++;
        tenDA = new ArrayList<>();
        viTri = new ArrayList<>();
        soNgayTG = new ArrayList<>();
    }
    
    public NhanVien(String hoTen, String diaChi, String chuyenMon){
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.chuyenMon = chuyenMon;
        ma = stMa++;
        tenDA = new ArrayList<>();
        viTri = new ArrayList<>();
        soNgayTG = new ArrayList<>();
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

    public String getChuyenMon() {
        return chuyenMon;
    }

    public List<DuAn> getTenDA() {
        return tenDA;
    }

    public List<String> getViTri() {
        return viTri;
    }

    public List<Integer> getSoNgayTG() {
        return soNgayTG;
    }

    public static void setStMa(int stMa) {
        NhanVien.stMa = stMa;
    }

    public void setTenDA(DuAn tenDA) {
        this.tenDA.add(tenDA);
    }

    public void setViTri(String viTri) {
        this.viTri.add(viTri);
    }

    public void setSoNgayTG(int soNgayTG) {
        this.soNgayTG.add(soNgayTG);
    }
    
    public void xoaDA(DuAn an){
        int i = tenDA.indexOf(an);
        viTri.remove(i);
        soNgayTG.remove(i);
        tenDA.remove(i);
    }
    
    public void themDA(DuAn da, String viTri, int soNgay){
        tenDA.add(da);
        this.viTri.add(viTri);
        this.soNgayTG.add(soNgay);
    }
    
}
