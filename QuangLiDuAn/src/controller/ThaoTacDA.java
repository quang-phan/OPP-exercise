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
import model.DuAn;
import model.NhanVien;

/**
 *
 * @author ADMIN
 */
public class ThaoTacDA {
    public static List<DuAn> docFile(){
        File file = new File("DA.TXT");
        List<DuAn> list = new ArrayList<>();
        
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            DuAn an = (DuAn)objectInputStream.readObject();
            while(an != null){
                list.add(an);
                an = (DuAn)objectInputStream.readObject();
            }
            
            objectInputStream.close();
            fileInputStream.close();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return list;
    }
    
    public static void ghiFile(List<DuAn> list){
        File file = new File("DA.TXT");
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            int i = 0;
            while(i < list.size()){
                objectOutputStream.writeObject(list.get(i));
                i++;
            }
            
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static DuAn tim(List<DuAn> list, String ma){
        if(ma.matches("^\\d{5}")) return timMa(list, ma);
        else return timTen(list, ma);
    }
    
    private static DuAn timMa(List<DuAn> list, String ma){
        int x = Integer.parseInt(ma);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMa() == x) return list.get(i);
        }
        
        return null;
    }
    
    private static DuAn timTen(List<DuAn> list, String ten){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTenDA().compareTo(ten) == 0) return list.get(i);
        }
        return null;
    }
    
    public static void sua(DuAn duAn, String kieu, String tong){
        duAn.setKieuDA(kieu);
        duAn.setTong(tong);
    }
    
    public static void them(List<DuAn> list, String ten, String kieu, String tong){
        if(!list.isEmpty()) DuAn.setStMa(list.get(list.size()-1).getMa()+1);
        DuAn an = new DuAn(ten, kieu, tong);
        list.add(an);
    }
    
    public static boolean xoa(List<DuAn> listDA, List<NhanVien> listNV, String ma){
        DuAn an = tim(listDA, ma);
        if(an != null){
            //System.out.println("qqq");
            int i = 0;
            while(i < listNV.size()){
                if(listNV.get(i).getTenDA().contains(an)) {
                    listNV.get(i).xoaDA(an);
                }
                i++;
            }
            listDA.remove(an);
            return true;
        }
        return false;
    }
}
