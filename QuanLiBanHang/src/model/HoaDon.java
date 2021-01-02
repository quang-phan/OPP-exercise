/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class HoaDon implements Serializable{
    private KhachHang khachHang;
    private List<MatHang> matHang = new ArrayList<>();
    private List<Integer> soLuong = new ArrayList<>();

    public HoaDon(KhachHang khachHang, MatHang matHang, int soLuong) {
        this.khachHang = khachHang;
        this.matHang.add(matHang);
        this.soLuong.add(soLuong);
    }
    
    public void them(MatHang matHang, int soLuong){
        int x = kiemTra(matHang);
        if(x != -1){
            int temp = this.soLuong.get(x);
            this.soLuong.set(x, temp+soLuong);
        }
        else{
            this.matHang.add(matHang);
            this.soLuong.add(soLuong);
        }
    }
    
    private int kiemTra(MatHang matHang){
        for(int i = 0; i < this.matHang.size(); i++){
            if(this.matHang.get(i).getMa() == matHang.getMa()) return i;
        }
        return -1;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public List<MatHang> getMatHang() {
        return matHang;
    }

    public List<Integer> getSoLuong() {
        return soLuong;
    }
    
    
}
