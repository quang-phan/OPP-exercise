/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.DichVu;

/**
 *
 * @author ADMIN
 */
public class ThaoTacDV {
    public static List<DichVu> readFile(){
        return IOFile.readFile("DV.TXT");
    }
    
    public static void writeFile(List<DichVu> list){
        IOFile.writeFile(list, "DV.TXT");
    }
    
    public static DichVu tim(List<DichVu> list, String ma){
        if(ma.matches("\\d{3}")) return timMa(list, ma);
        else return timTen(list, ma);
    }
    
    private static DichVu timMa(List<DichVu> list, String ma){
        int x = Integer.parseInt(ma);
        for(int i = 0; i < list.size(); i++) 
            if(list.get(i).getMa() == x) return list.get(i);
        return null;
    }
    
    private static DichVu timTen(List<DichVu> list, String ten){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).getTen().compareTo(ten) == 0) return list.get(i);
        return null;
    }
}
