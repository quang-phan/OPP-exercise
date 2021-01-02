/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.HoaDon;
import model.KhachHang;
import model.MatHang;

/**
 *
 * @author ADMIN
 */
public class ThaoTacHD {
    public static List<HoaDon> readFile(){
        List<HoaDon> list = new ArrayList<>();
        
        list = IOFile.readFile("HOADON.TXT");
        return list;
    }
    
    public static void writeFile(List<HoaDon> list){
        IOFile.writeFile(list, "HOADON.TXT");
    }
    
    public static HoaDon tim(List<HoaDon> list, KhachHang kh){
        for(int i = 0; i < list.size(); i++) 
            if(list.get(i).getKhachHang().getMa() == kh.getMa()) 
                return list.get(i);
        return null;
    }
    
    public static void phanTach(List<HoaDon> list, Vector<String> vcMaKH, Vector<String> vcTenKH,
            Vector<String> vcTenSP, Vector<String> vcSoLuong){
        vcMaKH.clear();
        vcTenKH.clear();
        vcTenSP.clear();
        vcSoLuong.clear();
        for(int i = 0; i < list.size(); i++){
            List<MatHang> listMH = list.get(i).getMatHang();
            List<Integer> listSL = list.get(i).getSoLuong();
            
            for(int j = 0; j < listMH.size(); j++){
                vcMaKH.add(list.get(i).getKhachHang().getMa()+"");
                vcTenKH.add(list.get(i).getKhachHang().getHoTen());
                vcTenSP.add(listMH.get(j).getTen());
                vcSoLuong.add(listSL.get(j)+"");
            }
        }
    }
    
    public static void SXTheoTen(Vector<String> vcMaKH, Vector<String> vcTenKH,
            Vector<String> vcTenSP, Vector<String> vcSoLuong){
        String temp;
        for (int i = 0; i < vcTenKH.size(); i++) {
            for (int j = i+1; j < vcTenKH.size(); j++) {
                if(vcTenKH.get(i).compareTo(vcTenKH.get(j)) > 0){
                    temp = vcMaKH.get(i);
                    vcMaKH.set(i, vcMaKH.get(j));
                    vcMaKH.set(j, temp);
                    
                    temp = vcTenKH.get(i);
                    vcTenKH.set(i, vcTenKH.get(j));
                    vcTenKH.set(j, temp);
                    
                    temp = vcTenSP.get(i);
                    vcTenSP.set(i, vcTenSP.get(j));
                    vcTenSP.set(j, temp);
                    
                    temp = vcSoLuong.get(i);
                    vcSoLuong.set(i, vcSoLuong.get(j));
                    vcSoLuong.set(j, temp);
                }
                
            }
            
        }
    }
    
    public static void SXTheoSoLuong(Vector<String> vcMaKH, Vector<String> vcTenKH,
            Vector<String> vcTenSP, Vector<String> vcSoLuong){
        String temp;
        for (int i = 0; i < vcTenKH.size(); i++) {
            for (int j = i+1; j < vcTenKH.size(); j++) {
                int x = Integer.parseInt(vcSoLuong.get(i));
                int y = Integer.parseInt(vcSoLuong.get(j));
                if(x < y){
                    temp = vcMaKH.get(i);
                    vcMaKH.set(i, vcMaKH.get(j));
                    vcMaKH.set(j, temp);
                    
                    temp = vcTenKH.get(i);
                    vcTenKH.set(i, vcTenKH.get(j));
                    vcTenKH.set(j, temp);
                    
                    temp = vcTenSP.get(i);
                    vcTenSP.set(i, vcTenSP.get(j));
                    vcTenSP.set(j, temp);
                    
                    temp = vcSoLuong.get(i);
                    vcSoLuong.set(i, vcSoLuong.get(j));
                    vcSoLuong.set(j, temp);
                }
                
            }
            
        }
    }
}
