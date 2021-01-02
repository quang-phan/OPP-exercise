/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.MatHang;

/**
 *
 * @author ADMIN
 */
public class ThaoTacMH {
    public static List<MatHang> readFile(){
        List<MatHang> list = new ArrayList<>();
        list = IOFile.readFile("MATHANG.TXT");
        return list;
    }
    
    public static void writeFile(List<MatHang> list){
        IOFile.writeFile(list, "MATHANG.TXT");
    }
    
    public static MatHang tim(List<MatHang> list, String ma){
        if(ma.matches("\\d{5}")) return timMa(list, ma);
        else return timTen(list, ma);
    }
    
    private static MatHang timMa(List<MatHang> list, String ma){
        int x = Integer.parseInt(ma);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMa() == x) return list.get(i);
        }
        return null;
    }
    
    private static MatHang timTen(List<MatHang> list, String ten){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTen().compareTo(ten) == 0) return list.get(i);
        }
        return null;
    }
}
