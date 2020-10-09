
package bai17;

import java.util.Scanner;

public class Bai17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap chieu cao ban muon:");
        int n = input.nextInt();
        ToHop toHop = new ToHop(n);
        toHop.show();
    }
}
