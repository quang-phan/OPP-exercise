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
import java.util.Map;
import java.util.Vector;
import model.Cong;
import model.CongNhan;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class ThaoTacPC {
    public static List<Cong> readFile(){
        File file = new File("TINHCONG.TXT");
        List<Cong> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            Cong c = (Cong)objectInputStream.readObject();
            while(c != null){
                list.add(c);
                c = (Cong)objectInputStream.readObject();
            }
            
            objectInputStream.close();
            fileInputStream.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    } 
    
    public static void writeFile(List<Cong> list){
        File file = new File("TINHCONG.TXT");
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
    
    public static void phanTach(List<Cong> list, Vector<String> maCN, Vector<String> tenCN,
            Vector<String> tenSP, Vector<String> soLuong, Vector<String> donGia){
        maCN.clear();
        tenCN.clear();
        tenSP.clear();
        soLuong.clear();
        donGia.clear();
        
        for(int i = 0; i < list.size(); i++){
            Map<SanPham, Integer> map = list.get(i).getSanPham();
            
            for(Map.Entry<SanPham, Integer> entry : map.entrySet()){
                maCN.add(""+list.get(i).getCongNhan().getMa());
                tenCN.add(list.get(i).getCongNhan().getHoTen());
                tenSP.add(entry.getKey().getTen());
                soLuong.add(entry.getValue()+"");
                donGia.add(entry.getKey().getDonGia()+"");
            }
        }
    }
    
    public static Cong kiemTra(List<Cong> list, CongNhan cn){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCongNhan().getMa() == cn.getMa()) return list.get(i);
        }
        return null;
    }
//    vcMaCN = new Vector<>(), vcTenCN = new Vector<>(),
//            vcTenSP = new Vector<>(), vcSoLuong = new Vector<>(), vcDonGia = new Vector<>();
    public static void SXTheoTen(Vector<String> vcMaCN, Vector<String> vcTenCN, Vector<String> vcTenSP,
           Vector<String> vcSoLuong, Vector<String> vcDonGia){
        for(int i = 0; i < vcTenCN.size(); i++){
            for(int j = i+1; j< vcTenCN.size(); j++){
                String temp;
                if(vcTenCN.get(i).compareTo(vcTenCN.get(j)) > 0){
                    temp = vcTenCN.get(i);
                    vcTenCN.set(i, vcTenCN.get(j));
                    vcTenCN.set(j, temp);
                    
                    temp = vcTenSP.get(i);
                    vcTenSP.set(i, vcTenSP.get(j));
                    vcTenSP.set(j, temp);
                    
                    temp = vcSoLuong.get(i);
                    vcSoLuong.set(i, vcSoLuong.get(j));
                    vcSoLuong.set(j, temp);
                    
                    temp = vcMaCN.get(i);
                    vcMaCN.set(i, vcMaCN.get(j));
                    vcMaCN.set(j, temp);
                    
                    temp = vcDonGia.get(i);
                    vcDonGia.set(i, vcDonGia.get(j));
                    vcDonGia.set(j, temp);
                }
            }
        }
    }
    
    public static void SXTheoSoLuong(Vector<String> vcMaCN, Vector<String> vcTenCN, Vector<String> vcTenSP,
           Vector<String> vcSoLuong, Vector<String> vcDonGia){
        for(int i = 0; i < vcTenCN.size(); i++){
            for(int j = i+1; j< vcTenCN.size(); j++){
                String temp;
                if(vcSoLuong.get(i).compareTo(vcSoLuong.get(j)) > 0){
                    temp = vcTenCN.get(i);
                    vcTenCN.set(i, vcTenCN.get(j));
                    vcTenCN.set(j, temp);
                    
                    temp = vcTenSP.get(i);
                    vcTenSP.set(i, vcTenSP.get(j));
                    vcTenSP.set(j, temp);
                    
                    temp = vcSoLuong.get(i);
                    vcSoLuong.set(i, vcSoLuong.get(j));
                    vcSoLuong.set(j, temp);
                    
                    temp = vcMaCN.get(i);
                    vcMaCN.set(i, vcMaCN.get(j));
                    vcMaCN.set(j, temp);
                    
                    temp = vcDonGia.get(i);
                    vcDonGia.set(i, vcDonGia.get(j));
                    vcDonGia.set(j, temp);
                }
            }
        }
    }
}
