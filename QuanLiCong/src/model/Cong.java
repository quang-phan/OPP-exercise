/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Cong implements Serializable{
    private CongNhan congNhan;
    private Map<SanPham, Integer> listSP;
    private int capital = 5;
    
    public Cong(){
        listSP = new HashMap<>();
    }
    
    public Cong(CongNhan congNhan){
        this.congNhan = congNhan;
        listSP = new HashMap<>();
    }
    
    public Map<SanPham, Integer> getSanPham(){
        return listSP;
    }
    
    public boolean themSanPham(SanPham  sanPham, int soLuong){
        if(!listSP.containsKey(sanPham)){
            if(capital <= 0) return false;
            listSP.put(sanPham, soLuong);
            capital--;
            return true;
        }
        else{
            listSP.put(sanPham, listSP.get(sanPham)+soLuong);
            return true;
        }
    }
    
    public void themCongNhan(CongNhan congNhan, SanPham  sanPham, int soLuong){
        this.congNhan = congNhan;
        if(!listSP.containsKey(sanPham)){
            listSP.put(sanPham, soLuong);
            capital--;
        }
        else{
            listSP.put(sanPham, listSP.get(sanPham)+soLuong);
        }
    }
    
    public CongNhan getCongNhan(){
        return congNhan;
    }

    public int getCapital() {
        return capital;
    }
    
    
}
