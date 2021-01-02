/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author ADMIN
 */
public class ThaoTacKH {
    public static List<KhachHang> readFile(){
        List<KhachHang> list = new ArrayList<>();
        list = IOFile.readFile("KH.TXT");
        return list;
    }
    
    public static void writeFile(List<KhachHang> list){
        IOFile.writeFile(list, "KH.TXT");
    }
    
    
    public static KhachHang tim(List<KhachHang> list, String ma){
        if(ma.matches("\\d{5}")) return timMa(list, ma);
        else return timTen(list, ma);
    }
    
    private static KhachHang timMa(List<KhachHang> list, String ma){
        int x = Integer.parseInt(ma);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMa() == x) return list.get(i);
        }
        return null;
    }
    
    private static KhachHang timTen(List<KhachHang> list, String ten){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getHoTen().compareTo(ten) == 0) return list.get(i);
        }
        return null;
    }
}
