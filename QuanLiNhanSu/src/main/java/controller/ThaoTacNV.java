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
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import model.NhanVien;
import model.PhongBan;

public class ThaoTacNV {

    public static void themNV(List<NhanVien> list, String ten, String diaChi,
            String sdt, String bacLuong, PhongBan phongBan) {

        NhanVien nhanVien;
        if (!list.isEmpty()) {
            NhanVien.setStMa(list.get(list.size() - 1).getMa() + 1);
        }
        nhanVien = new NhanVien(ten, diaChi, sdt, Integer.parseInt(bacLuong), phongBan);
        list.add(nhanVien);

    }
    
    public static boolean boNV(List<NhanVien> list, String maNV){
        if(maNV.matches("\\d{4}")){
            int x = timTheoMa(list, maNV);
            
            if(x != -1){
                list.remove(x);
                return true;
            }
            else return false;
        }else{
            int x = timTheoTen(list, maNV);
            
            if(x != -1){
                list.remove(x);
                return true;
            }else return false;
        }
    }
    
    
    private static int timTheoMa(List<NhanVien> list, String maNV){
        int i = 0;
        while(i < list.size()){
            if(list.get(i).getMa() == Integer.parseInt(maNV)) return i;
            i++;
        }
        return -1;
    }
    
    private static int timTheoTen(List<NhanVien> list, String ten){
        int i = 0;
        
        while(i < list.size()){
            if(list.get(i).getTen().compareTo(ten) == 0) return i;
            i++;
        }
        return -1;
    }

    public static int kt(List<NhanVien> list, String ten, String sdt) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).getTen().compareTo(ten) == 0
                    && list.get(i).getSdt().compareTo(sdt) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public static void ghiFile(List<NhanVien> list){
        File file = new File("NV.TXT");
        
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            Iterator<NhanVien> iterator = list.iterator();
            
            while(iterator.hasNext()){
                objectOutputStream.writeObject(iterator.next());
            }
            
            objectOutputStream.close();
            fileOutputStream.close();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    
    public static List<NhanVien> docFile(){
        File file = new File("NV.TXT");
        List<NhanVien> list = new ArrayList<>();
        
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            NhanVien nv = (NhanVien)objectInputStream.readObject();
            while(nv != null){
                list.add(nv);
                nv = (NhanVien)objectInputStream.readObject();
            }
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        
        return list;
    }
}
