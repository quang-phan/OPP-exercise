
package bai33;

import java.util.Scanner;

public class Bai33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Rom r = new Rom(s);
        System.out.println(r);
    }
}
