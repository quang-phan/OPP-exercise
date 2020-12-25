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
import model.PhongBan;

/**
 *
 * @author User
 */
public class ThaoTacPB {
    public static PhongBan timPB(List<PhongBan> list, String ma){
        if(ma.matches("\\d{3}")){
            return timMa(list, ma);
        }
        else return timTen(list, ma);
    }
    
    private static PhongBan timMa(List<PhongBan> list, String ma){
        int i = 0;
        while(i < list.size()){
            
            if(list.get(i).getMa() == Integer.parseInt(ma)) return list.get(i);
            i++;
        }
        return null;
    }
    
    private static PhongBan timTen(List<PhongBan> list, String ten){
        int i = 0;
        while(i < list.size()){
            if(list.get(i).getTen().compareTo(ten) == 0) return list.get(i);
            i++;
        }
        
        return null;
    }
    
    public static List<PhongBan> docFile(){
        File file = new File("PB.TXT");
        List<PhongBan> list = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            PhongBan temp = (PhongBan)objectInputStream.readObject();
            while(temp != null){
                list.add(temp);
                temp = (PhongBan)objectInputStream.readObject();
            }
            
            objectInputStream.close();
            fileInputStream.close();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        
        return list;
    }
    
    public static void writeFile(List<PhongBan> list){
        File file = new File("PB.TXT");
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            int i = 0;
            while(i < list.size()){
                objectOutputStream.writeObject(list.get(i));
                i++;
            }
            
            objectOutputStream.close();
            fileOutputStream.close();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
