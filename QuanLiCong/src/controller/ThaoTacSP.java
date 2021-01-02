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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class ThaoTacSP {
    public static List<SanPham> readFile(){
        File file = new File("SP.TXT");
        List<SanPham> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            SanPham sp = (SanPham)objectInputStream.readObject();
            while(sp != null){
                list.add(sp);
                sp = (SanPham)objectInputStream.readObject();
            }
            
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static void writeFile(List<SanPham> list){
        File file = new File("SP.TXT");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            for(int i = 0; i < list.size(); i++){
                objectOutputStream.writeObject(list.get(i));
            }
            
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean kiemTra(List<SanPham> list, String ten){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTen().compareTo(ten) == 0) return true;
        }
        return false;
    }
    
    public static SanPham tim(List<SanPham> list, String ma){
        if(ma.matches("\\d{5}")) return timMa(list, ma);
        else return timTen(list, ma);
    }
    
    private static SanPham timMa(List<SanPham> list, String ma){
        int x = Integer.parseInt(ma);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMa() == x) return list.get(i);
        }
        return null;
    }
    
    private static SanPham timTen(List<SanPham> list, String ten){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTen().compareTo(ten) == 0) return list.get(i);
        }
        return null;
    }
}
