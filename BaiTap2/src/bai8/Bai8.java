
package bai8;

import bai7.HauTo;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("nhap bieu thuc: ");
        String s = scanner.nextLine();
        System.out.println();
        
        System.out.println("bieu thuc dang hau to: "+HauTo.trungTo(s));
    }
}
