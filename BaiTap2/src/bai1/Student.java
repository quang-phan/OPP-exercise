
package bai1;

import java.util.StringTokenizer;

public class Student implements Comparable<Student>{
    private String maSv;
    private String ten;
    private String lop;
    private int khoa = 0;

    public Student(String maSv, String ten, String lop, int khoa) {
        if(maSv.equals("")|| ten.equals("")) 
            throw new ArithmeticException("\nten, lop va ma sinh vien khong "
                    + "duoc de trong!");
        this.maSv = maSv;
        this.ten = ten;
        this.khoa = khoa;
        this.lop = lop;
    }
    
    public Student(String maSv, String ten) {
        if(maSv.equals("")|| ten.equals("")) 
            throw new ArithmeticException("\nten va ma sinh vien khong "
                    + "duoc de trong!");
        this.maSv = maSv;
        this.ten = ten;
    }
    
    public Student() {
    }

    public Student(String maSv, String ten, String lop) {
        if(maSv.equals("")|| ten.equals("")) 
            throw new ArithmeticException("\nten, lop va ma sinh vien khong "
                    + "duoc de trong!");
        this.maSv = maSv;
        this.ten = ten;
        this.lop = lop;
    }

    public void setLop(String lop) {
        if(lop.equals(""))
            throw new ArithmeticException("lop kong duoc de trong");
        this.lop = lop;
    }
    

    public void setMaSv(String maSv) {
        if(maSv.equals("")) 
            throw new ArithmeticException("\nMa sinh vien khong duoc de trong");
        this.maSv = maSv;
    }

    public void setTen(String ten) {
        if(ten.equals(""))
            throw new ArithmeticException("\nTen sinh vien khong"
                    + " duoc de trong");
        this.ten = ten;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }
    
    @Override
    public String toString() {
        return "\nmaSv: " + maSv + "\nten: " + ten + 
                "\nLop: "+lop+"\nkhoa: " + khoa;
    }
    
    public void show(){
        System.out.println("\nmaSv: " + maSv + "\nten: " + ten + 
                "\nLop: "+lop+"\nkhoa: " + khoa);
    }

    @Override
    public int compareTo(Student o) {
        StringTokenizer tokenizer = new StringTokenizer(ten);
        tokenizer.nextToken();
        tokenizer.nextToken();
        String x = "", y = "";
        while(tokenizer.hasMoreTokens()){
            x += tokenizer.nextToken();
        }
        tokenizer = new  StringTokenizer(o.ten);
        tokenizer.nextToken();
        tokenizer.nextToken();
        while(tokenizer.hasMoreTokens()){
            y += tokenizer.nextToken();
        }
        int result = x.compareTo(y);
        if(result != 0) return result;
        result = lop.compareTo(o.lop);
        return result;
    }
    
}
