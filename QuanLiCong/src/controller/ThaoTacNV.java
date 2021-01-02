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
import model.CongNhan;

/**
 *
 * @author ADMIN
 */
public class ThaoTacNV {
    public static List<CongNhan> readFile(){
        File file = new File("CN.TXT");
        List<CongNhan> list = new ArrayList<>();
        
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            CongNhan cn = (CongNhan)objectInputStream.readObject();
            while(cn != null){
                list.add(cn);
                cn = (CongNhan)objectInputStream.readObject();
            }
            
            objectInputStream.close();
            fileInputStream.close();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        
        return list;
    }
    
    public static void writeFile(List<CongNhan> list){
        File file = new File("CN.TXT");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            for(int i = 0; i < list.size(); i++) 
                objectOutputStream.writeObject(list.get(i));
            
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static CongNhan tim(List<CongNhan> list, String ma){
        if(ma.matches("\\d{5}")){
            return timMa(list, ma);
        }else return timTen(list, ma);
    }
    
    private static CongNhan timMa(List<CongNhan> list, String ma){
        int x = Integer.parseInt(ma);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMa() == x) return list.get(i);
        }
        return null;
    }
    
    private static CongNhan timTen(List<CongNhan> list, String ten){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getHoTen().compareTo(ten) == 0) return list.get(i);
        }
        return null;
    }
}
