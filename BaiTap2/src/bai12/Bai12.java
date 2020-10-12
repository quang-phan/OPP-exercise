
package bai12;

import java.util.Scanner;

public class Bai12 {
    public static void main(String[] args) {
        solve();
    }
    
    
    public static void solve(){
        Scanner scanner = new Scanner(System.in);
        int c;
        boolean ok = true;
        while(ok){
            System.out.println("---------------------------------");
            System.out.println("1. Tinh tong va hieu hai ma tran");
            System.out.println("2. Tinh tich hai ma tran");
            System.out.println("3. Tim chuyen vi cua mot ma tran");
            System.out.println("4. Ket thec chuong trinh");
            System.out.println("----------------------------------");
            System.out.print("lua chon: ");
            c = scanner.nextInt();
            System.out.println();
            switch(c){
                case 1:{
                    System.out.print("nhap kich thuoc ma tran A: ");
                    Matrix a = new Matrix(scanner.nextInt(), scanner.nextInt());
                    System.out.println("\nnhap ma tran A:");
                    a.input();
                    
                    System.out.print("nhap kich thuoc ma tran B: ");
                    Matrix b = new Matrix(scanner.nextInt(), scanner.nextInt());
                    System.out.println("\nnhap ma tran B:");
                    b.input();
                    
                    Matrix x;
                    
                    System.out.println("ket qua tong A + B:");
                    x = a.add(b);
                    x.print();
                    
                    System.out.println("ket qua hieu A - B:");
                    x = a.sub(b);
                    x.print();
                    
                    break;
                }
                case 2:{
                    System.out.print("nhap kich thuoc ma tran A: ");
                    Matrix a = new Matrix(scanner.nextInt(), scanner.nextInt());
                    System.out.println("\nnhap ma tran A:");
                    a.input();
                    
                    System.out.print("nhap kich thuoc ma tran B: ");
                    Matrix b = new Matrix(scanner.nextInt(), scanner.nextInt());
                    System.out.println("\nnhap ma tran B:");
                    b.input();
                    
                    Matrix x;
                    
                    System.out.println("ket qua tich A * B:");
                    x = a.mul(b);
                    x.print();
                    
                    break;
                }
                
                case 3:{
                    System.out.print("nhap kich thuoc ma tran A: ");
                    Matrix a = new Matrix(scanner.nextInt(), scanner.nextInt());
                    System.out.println("\nnhap ma tran A:");
                    a.input();
                    
                    Matrix x;
                    
                    System.out.println("chuyen vi cua A:");
                    x = a.transpose();
                    x.print();
                    
                    break;
                }
                
                case 4:{ 
                    ok = false;
                    break;
                }
            }
        }
    }
}
