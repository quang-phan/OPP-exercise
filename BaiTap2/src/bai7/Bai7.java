
package bai7;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("nhap bieu thuc: ");
        String s = scanner.nextLine();
        
        System.out.println(HauTo.tinh(HauTo.trungTo(s)));
        
    }
}
