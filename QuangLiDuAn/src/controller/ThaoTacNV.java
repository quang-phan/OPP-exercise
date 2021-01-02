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
import java.util.Vector;
import model.DuAn;

import model.NhanVien;

/**
 *
 * @author ADMIN
 */
public class ThaoTacNV {
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
            
            objectInputStream.close();
            fileInputStream.close();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return list;
    }
    
    public static void ghiFile(List<NhanVien> list){
        File file = new File("NV.TXT");
        
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
    
    public static void themNV(List<NhanVien> list, String ten, String diaChi, String chuyenMon){
        if(!list.isEmpty()) NhanVien.setStMa(list.get(list.size()-1).getMa()+1);
        NhanVien nv = new NhanVien(ten, diaChi, chuyenMon);
        list.add(nv);
    }
    
    public static boolean themDA(NhanVien nv, DuAn da,String viTri, int soNgay){
        if(nv.getTenDA().contains(da)){
            return false;
        }
        else{
            nv.themDA(da, viTri, soNgay);
            return true;
        }
    }
    
    public static NhanVien timNV(List<NhanVien> list, String ma){
        if(ma.matches("^\\d{5}")){
            return timMa(list, Integer.parseInt(ma));
        }
        else {
            return timTen(list, ma);
        }
        
    }
    
    private static NhanVien timMa(List<NhanVien> list, int ma){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMa() == ma) return list.get(i);
        }
        return null;
    }
    
    private static NhanVien timTen(List<NhanVien> list, String ten){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getHoTen().compareTo(ten) == 0) return list.get(i);
        }
        return null;
    }
    
    
    public static boolean xoaDA(List<NhanVien> list, String maNV, String maDA){
        NhanVien nv = timNV(list, maNV);
        if(list.contains(nv)){
            List<DuAn> listDA = nv.getTenDA();
            DuAn da = ThaoTacDA.tim(listDA, maDA);
            if(listDA.contains(da)){
                nv.xoaDA(da);
                return true;
            }
            else return false;
        }
        return false;
    }
    
    public static void phanTach(List<NhanVien> list, Vector<String> vcTenNV, Vector<String> vcTenDA,
            Vector<String> vcViTri, Vector<String> vcNgayTG){
        vcTenNV.clear();
        vcTenDA.clear();
        vcViTri.clear();
        vcNgayTG.clear();
        for(int i = 0; i < list.size(); i++){
            NhanVien nv = list.get(i);
            List<DuAn> listDA = list.get(i).getTenDA();
            List<String> listVT = list.get(i).getViTri();
            List<Integer> listNG = list.get(i).getSoNgayTG();
            
            for(int j = 0; j < listDA.size(); j++){
                vcTenNV.add(nv.getHoTen());
                vcTenDA.add(listDA.get(j).getTenDA());
                vcViTri.add(listVT.get(j));
                vcNgayTG.add(listNG.get(j).toString());
            }
        }
    }
    
    
    public static void sapXepTheoTen( Vector<String> vcTenNV, Vector<String> vcTenDA,
            Vector<String> vcViTri, Vector<String> vcNgayTG){
        for(int i = 0; i < vcTenNV.size(); i++){
            for(int j = i+1; j < vcTenNV.size(); j++){
                if(vcTenNV.get(i).compareTo(vcTenNV.get(j)) > 0){
                    String temp = vcTenNV.get(i);
                    vcTenNV.set(i, vcTenNV.get(j));
                    vcTenNV.set(j, temp);
                    
                    temp = vcTenDA.get(i);
                    vcTenDA.set(i, vcTenDA.get(j));
                    vcTenDA.set(j, temp);
                    
                    temp = vcViTri.get(i);
                    vcViTri.set(i, vcViTri.get(j));
                    vcViTri.set(j, temp);
                    
                    temp = vcNgayTG.get(i);
                    vcNgayTG.set(i, vcNgayTG.get(j));
                    vcNgayTG.set(j, temp);
                }
            }
        }
    }
    
    public static void sapXepTheoNgay( Vector<String> vcTenNV, Vector<String> vcTenDA,
            Vector<String> vcViTri, Vector<String> vcNgayTG){
        for(int i = 0; i < vcTenNV.size(); i++){
            for(int j = i+1; j < vcTenNV.size(); j++){
                if(vcNgayTG.get(i).compareTo(vcNgayTG.get(j)) > 0){
                    String temp = vcTenNV.get(i);
                    vcTenNV.set(i, vcTenNV.get(j));
                    vcTenNV.set(j, temp);
                    
                    temp = vcTenDA.get(i);
                    vcTenDA.set(i, vcTenDA.get(j));
                    vcTenDA.set(j, temp);
                    
                    temp = vcViTri.get(i);
                    vcViTri.set(i, vcViTri.get(j));
                    vcViTri.set(j, temp);
                    
                    temp = vcNgayTG.get(i);
                    vcNgayTG.set(i, vcNgayTG.get(j));
                    vcNgayTG.set(j, temp);
                }
            }
        }
    }
}
