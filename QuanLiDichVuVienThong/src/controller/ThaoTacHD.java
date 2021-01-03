/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Vector;
import model.DichVu;
import model.HoaDon;
import model.KhachHang;

/**
 *
 * @author ADMIN
 */
public class ThaoTacHD {
    public static void writeFile(List<HoaDon> list){
        IOFile.writeFile(list, "HOADON.TXT");
    }
    
    public static List<HoaDon> readFile(){
        return IOFile.readFile("HOADON.TXT");
    }
    
    public static HoaDon tim(List<HoaDon> list, KhachHang kh){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getKh().getMa() == kh.getMa()) return list.get(i);
        }
        return null;
    }
    
    public static void phanTach(List<HoaDon> list, Vector<String> vcMaKH, Vector<String> vcTenKH,
            Vector<String> vcTenDV, Vector<String> vcSoLuong){
        vcMaKH.clear();
        vcSoLuong.clear();
        vcTenDV.clear();
        vcTenKH.clear();
        for(int i = 0; i < list.size(); i++){
            List<DichVu> listDV = list.get(i).getListDV();
            List<Integer> listSL = list.get(i).getListsSL();
            
            for(int j = 0; j < listDV.size(); j++){
                vcMaKH.add(list.get(i).getKh().getMa()+"");
                vcTenKH.add(list.get(i).getKh().getTen());
                vcTenDV.add(listDV.get(j).getTen());
                vcSoLuong.add(listSL.get(j).toString());
            }
        }
    }
    
    public static void sxTheoTen(Vector<String> vcMaKH, Vector<String> vcTenKH,
            Vector<String> vcTenDV, Vector<String> vcSoLuong){
        for(int i = 0; i < vcTenKH.size(); i++){
            for(int j = i+1; j < vcTenKH.size(); j++){
                String temp;
                if(vcTenKH.get(i).compareTo(vcTenKH.get(j)) > 0){
                    
                    temp = vcTenKH.get(i);
                    vcTenKH.set(i, vcTenKH.get(j));
                    vcTenKH.set(j, temp);
                    
                    temp = vcMaKH.get(i);
                    vcMaKH.set(i, vcMaKH.get(j));
                    vcMaKH.set(j, temp);
                    
                    temp = vcTenDV.get(i);
                    vcTenDV.set(i, vcTenDV.get(j));
                    vcTenDV.set(j, temp);
                    
                    temp = vcSoLuong.get(i);
                    vcSoLuong.set(i, vcSoLuong.get(j));
                    vcSoLuong.set(j, temp);
                }
            }
        }
    }
    
    public static void sxTheoSL(Vector<String> vcMaKH, Vector<String> vcTenKH,
            Vector<String> vcTenDV, Vector<String> vcSoLuong){
        for(int i = 0; i < vcTenKH.size(); i++){
            for(int j = i+1; j < vcTenKH.size(); j++){
                String temp;
                int x = Integer.parseInt(vcSoLuong.get(i));
                int y = Integer.parseInt(vcSoLuong.get(j));
                if(x < y){
                    
                    temp = vcTenKH.get(i);
                    vcTenKH.set(i, vcTenKH.get(j));
                    vcTenKH.set(j, temp);
                    
                    temp = vcMaKH.get(i);
                    vcMaKH.set(i, vcMaKH.get(j));
                    vcMaKH.set(j, temp);
                    
                    temp = vcTenDV.get(i);
                    vcTenDV.set(i, vcTenDV.get(j));
                    vcTenDV.set(j, temp);
                    
                    temp = vcSoLuong.get(i);
                    vcSoLuong.set(i, vcSoLuong.get(j));
                    vcSoLuong.set(j, temp);
                }
            }
        }
    }
}
