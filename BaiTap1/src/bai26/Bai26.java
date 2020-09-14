
package bai26;

import bai24.MaTran;
import java.util.Scanner;

public class Bai26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap kich thuoc ma tran: ");
        int n = scanner.nextInt();
        MaTran maTran = new MaTran(n, n);
        System.out.println("\nma tran nhan duoc:");
        maTran.show();
    }
        
}
