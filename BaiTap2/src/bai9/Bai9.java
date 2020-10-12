
package bai9;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("nhap so n: ");
        int n = scanner.nextInt();
        System.out.println();
        
        System.out.print("chuyen sang co so: ");
        int b = scanner.nextInt();
        System.out.println();
        
        System.out.println("Ket qua: "+CoSo.chuyenCoSo(n, b));
    }
}
