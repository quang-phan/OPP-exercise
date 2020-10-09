
package bai22;

import java.util.Scanner;

public class Bai22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap do dai mang a: ");
        int n = scanner.nextInt(), p;
        int[] a = new int[n];
        System.out.println("\nnhap mang a:");
        for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
        System.out.print("nhap do dai mang b: ");
        int m = scanner.nextInt();
        int[] b = new int[m];
        System.out.println("\nnhap do dai mang b:");
        for(int i = 0; i < m; i++) b[i] = scanner.nextInt();
        System.out.print("nhap vi tri can chen: ");
        p = scanner.nextInt();
        System.out.println("");
        Insert insert = new Insert();
        int[] c = insert.insert(a, p, b);
        System.out.println("mang nhan duoc:");
        for(int i = 0; i < c.length; i++){
            if((i+1)%21 == 0) System.out.println("");
            System.out.print(c[i]+" ");
        }
        System.out.println("");
    }
}
