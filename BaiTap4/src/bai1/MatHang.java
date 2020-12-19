
package bai1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatHang {
    static private int ma = 1000;
    private String tenHang, nhomHang;
    private double giaBan;
    
    public MatHang(){
        ma++;
    }

    public void setMa(int ma) {
        MatHang.ma = ma;
    }
    
    public void nhap(int ma, String ten, String nhomHang, double giaBan){
        if(1000 <= ma && ma <= 9999) this.ma = ma;
        else throw new ArithmeticException("ma hang sai");
        
        Pattern pattern = Pattern.compile("(\\d+)?\\w+");
        Matcher matcher = pattern.matcher(ten);
        if(matcher.find()) this.tenHang = ten;
        else throw new ArithmeticException("ten hang trong");
        
        if(giaBan < 0){
            this.giaBan = giaBan;
        }
        else throw new ArithmeticException("gia ban khong dung");
    }
    
    public void nhap(String tenHang, String nhomHang, double giaBan){
        Pattern pattern = Pattern.compile("(\\d+)?w+");
        Matcher matcher = pattern.matcher(tenHang);
        if(matcher.find()) this.tenHang = tenHang;
        else throw new ArithmeticException("ten hang trong");
        
        if(giaBan < 0){
            this.giaBan = giaBan;
        }
        else throw new ArithmeticException("gia ban khong dung");
    }
    
    protected String getMa(){
        return ""+ma;
    }
    
    protected String getTen(){
        return tenHang;
    }
    
    protected String getNhom(){
        return nhomHang;
    }
    
    protected String getGia(){
        return ""+giaBan;
    }
    @Override
    public String toString() {
        return ma+"\n"+tenHang+"\n"+nhomHang+"\n"+giaBan;
    }
    
    
}
