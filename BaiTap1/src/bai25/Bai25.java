
package bai25;

import bai24.MaTran;
import java.util.Scanner;

public class Bai25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("kich thuoc ma tran a mxn: ");
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] a = new int[m][n];
        System.out.println("\nnhap ma tran:");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) a[i][j] = scanner.nextInt();
        }
        System.out.println("kich thuoc ma tran b mxn: ");
        int t = scanner.nextInt(), k = scanner.nextInt();
        int[][] b = new int[t][k];
        System.out.println("\nnhap ma tran:");
        for(int i = 0; i < t; i++){
            for(int j = 0; j < k; j++) b[i][j] = scanner.nextInt();
        }
        
        MaTran maTran = new MaTran(a);
        maTran.setA(maTran.muliply(b));
        System.out.println("ket qua nhan hai ma tran:");
        maTran.show();
    }
}
