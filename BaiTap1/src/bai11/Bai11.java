
package bai11;

import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("ban can in bao nhieu so fibonaci: ");
        int n = input.nextInt();
        Fibonaci fi = new Fibonaci();
        fi.show(n);
    }
}
