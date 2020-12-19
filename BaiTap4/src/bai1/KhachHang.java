/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class KhachHang {
    static private int maKhachHang = 10000;
    private int maKhachHang1 = 0;
    private String tenKH, diaChiKH, soDT;
    private Vector<MatHang> vector;
    
    public KhachHang(){
        maKhachHang++;
        vector = new Vector<>();
    }
    
    public KhachHang(String tenKH, String diaChiKH, String soDT){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(tenKH);
        
        if(matcher.find()) this.tenKH = tenKH;
        else throw new ArithmeticException("ten trong");
        
        if(matcher.find()) this.diaChiKH = diaChiKH;
        else throw new ArithmeticException("dia chia trong");
        
        if(soDT.matches("\\d{4,}")) this.soDT = soDT;
        else throw new NumberFormatException("so dien thoai khong dung");
        
        
    }
    
    public KhachHang(int maKH, String tenKH, String diaChiKH, String soDT){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(tenKH);
        
        if(matcher.find()) this.tenKH = tenKH;
        else throw new ArithmeticException("ten trong");
        
        if(matcher.find()) this.diaChiKH = diaChiKH;
        else throw new ArithmeticException("dia chi trong");
        
        if(soDT.matches("\\d{4,}")) this.soDT = soDT;
        else throw new NumberFormatException("so dien thoai khong dung");
        
        
        
        if(10000 <= maKH && maKH <= 99999) this.maKhachHang1 = maKH;
        else throw new NumberFormatException("nhap sai ma KH");
    }
}
