
package bai23;

import java.util.Scanner;

public class Bai23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("do dai dai day: ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        System.out.println("\nnhap day so:");
        for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
        LongestWay lw = new LongestWay(a);
        lw.result();
    }
}
