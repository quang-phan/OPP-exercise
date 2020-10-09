
package bai2;

import bai1.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> list = new ArrayList<>();
        while(n > 0){
            n--;
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
            list.add(student);
        }
        Collections.sort(list);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println("---------------"+iterator.next());
                
        }
    }

}
