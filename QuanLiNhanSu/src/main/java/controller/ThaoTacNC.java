/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.NhanVien;

/**
 *
 * @author ADMIN
 */
public class ThaoTacNC {
    public static void phanTach(List<NhanVien> list, Vector<String> maNV, Vector<String> tenNV,
            Vector<String> tenPB, Vector<String> ngayLam, Vector<String> thuNhap) {
        int i = 0;
        maNV.clear();
        tenNV.clear();
        tenPB.clear();
        ngayLam.clear();
        thuNhap.clear();
        NhanVien nv;
        while (i < list.size()) {
            nv = list.get(i);

            maNV.add("" + nv.getMa());
            tenNV.add(nv.getTen());
            tenPB.add(nv.getPhongBan().getTen());
            ngayLam.add("" + nv.getNgayCong());
            thuNhap.add(""
                    + (1450000*(2+(float)nv.getBacLuong()/3)
                    *nv.getPhongBan().getHeSo()*((float)nv.getNgayCong()/22)));
            i++;
        }
    }

    public static void sXTheoTen(Vector<String> maNV, Vector<String> tenNV,
            Vector<String> tenPB, Vector<String> ngayLam, Vector<String> thuNhap) {
        String temp;

        for (int i = 0; i < tenNV.size(); i++) {
            for (int j = i + 1; j < tenNV.size(); j++) {
                if (tenNV.get(i).compareTo(tenNV.get(j)) > 0) {
                    temp = tenNV.get(i);
                    tenNV.set(i, tenNV.get(j));
                    tenNV.set(j, temp);

                    temp = tenPB.get(i);
                    tenPB.set(i, tenPB.get(j));
                    tenPB.set(j, temp);

                    temp = maNV.get(i);
                    maNV.set(i, maNV.get(j));
                    maNV.set(j, temp);

                    temp = ngayLam.get(i);
                    ngayLam.set(i, ngayLam.get(j));
                    ngayLam.set(j, temp);

                    temp = thuNhap.get(i);
                    thuNhap.set(i, thuNhap.get(j));
                    thuNhap.set(j, temp);
                }
            }
        }
    }

    public static void sXTheoPB(Vector<String> maNV, Vector<String> tenNV,
            Vector<String> tenPB, Vector<String> ngayLam, Vector<String> thuNhap) {
        String temp;

        for (int i = 0; i < tenNV.size(); i++) {
            for (int j = i + 1; j < tenNV.size(); j++) {
                if (tenPB.get(i).compareTo(tenPB.get(j)) > 0) {
                    temp = tenNV.get(i);
                    tenNV.set(i, tenNV.get(j));
                    tenNV.set(j, temp);

                    temp = tenPB.get(i);
                    tenPB.set(i, tenPB.get(j));
                    tenPB.set(j, temp);

                    temp = maNV.get(i);
                    maNV.set(i, maNV.get(j));
                    maNV.set(j, temp);

                    temp = ngayLam.get(i);
                    ngayLam.set(i, ngayLam.get(j));
                    ngayLam.set(j, temp);

                    temp = thuNhap.get(i);
                    thuNhap.set(i, thuNhap.get(j));
                    thuNhap.set(j, temp);
                }
            }
        }
    }
}
