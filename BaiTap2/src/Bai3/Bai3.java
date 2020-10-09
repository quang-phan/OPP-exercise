
package Bai3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectange rectange = new Rectange();
        
        System.out.print("nhap chieu rong hinh chu nhat: ");
        rectange.setWidth(scanner.nextDouble());
        
        System.out.print("\nnhap chieu dai hinh chu nhat: ");
        rectange.setHeight(scanner.nextDouble());
        
        scanner.nextLine();
        
        System.out.print("\nnhap mau cua hinh chu nhat: ");
        rectange.setColor(scanner.nextLine());
        
        System.out.println("\ncac tinh chat hinh chu nhat da nhap:");
        System.out.println("chieu rong: "+rectange.getWidth());
        System.out.println("chieu dai: "+rectange.getHeight());
        System.out.println("mau sac: "+rectange.getColor());
        System.out.println("chu vi: "+rectange.findPerimeter());
        System.out.println("dien tich: "+rectange.findArea());
    }
    
    
}
