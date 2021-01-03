/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exeption.CapitalExeption;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDon implements Serializable{

    private KhachHang kh;
    private List<DichVu> listDV = new ArrayList<>();
    private List<Integer> listsSL = new ArrayList<>();
    private int capital = 5;

    public HoaDon(KhachHang kh, DichVu dv, int soLuong) throws CapitalExeption {
        if (capital == 0) {
            throw new CapitalExeption("khach hang da su dung toi da dich vu");
        }
        if (soLuong < 0) {
            throw new NumberFormatException("so luong nho hon 0");
        }
        this.kh = kh;
        this.listDV.add(dv);
        this.listsSL.add(soLuong);
        this.capital--;
    }

    public void them(DichVu dv, int soLuong) throws CapitalExeption {
        int x = kiem(dv);
        if (x != -1) {
            if (soLuong < 0) {
                throw new NumberFormatException("so luong nho hon 0");
            }
            int temp = listsSL.get(x);
            this.listsSL.set(x, temp + soLuong);
        } else {
            if (capital == 0) {
                throw new CapitalExeption("khach hang da su dung toi da dich vu");
            }
            if (soLuong < 0) {
                throw new NumberFormatException("so luong nho hon 0");
            }
            this.listDV.add(dv);
            this.listsSL.add(soLuong);
            this.capital--;

        }
    }

    private int kiem(DichVu dv) {
        for (int i = 0; i < listDV.size(); i++) {
            if (listDV.get(i).getMa() == dv.getMa()) {
                return i;
            }
        }
        return -1;
    }

    public KhachHang getKh() {
        return kh;
    }

    public List<DichVu> getListDV() {
        return listDV;
    }

    public List<Integer> getListsSL() {
        return listsSL;
    }
    
    
}
