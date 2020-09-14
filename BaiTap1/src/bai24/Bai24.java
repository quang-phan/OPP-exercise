
package bai24;

import java.util.Scanner;

public class Bai24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("kich thuoc ma tran mxn: ");
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] a = new int[m][n];
        System.out.println("\nnhap ma tran:");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) a[i][j] = scanner.nextInt();
        }
        MaTran maTran = new MaTran(a);
        System.out.println("ma tran chuyen vi:");
        maTran.chuyenVi();
    }
}
