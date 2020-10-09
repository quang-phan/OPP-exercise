
package bai1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        
        System.out.print("Nhap ma sinh vien: ");
        student.setMaSv(scanner.nextLine());
        
        System.out.print("\nNhap ten sinh vien: ");
        student.setTen(scanner.nextLine());
        
        System.out.print("\nNhap lop sinh vien: ");
        student.setLop(scanner.nextLine());
        try{
            System.out.print("\nKhoa sinh vien hoc:");
            student.setKhoa(Integer.parseInt(scanner.nextLine()));
        }catch(Exception e){
            System.out.println("\n nhap sai dinh dang!");
        }
        System.out.println("\nThong tin sinh vien duoc nhap:"+student);
    }
}
