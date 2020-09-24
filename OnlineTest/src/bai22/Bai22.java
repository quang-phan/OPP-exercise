
package bai22;

import java.util.Scanner;

public class Bai22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, m, n, d = 0;
        int[][] c;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            d++;
            m = scanner.nextInt();
            n = scanner.nextInt();
            int[][] a = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++) a[i][j] = scanner.nextInt();
            }
            c = nhanCV(a);
            System.out.println("Test "+d+":");
            for (int[] is : c) {
                for (int i : is) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
    }
    public static int[][] nhanCV(int[][] a){
        int m = a.length, n = a[0].length, sum;
        int[][] b = new int[n][m];
        int[][] c = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) b[j][i] = a[i][j];
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                sum = 0;
                for(int r = 0; r < n; r++) sum += (a[i][r]*b[r][j]);
                c[i][j] = sum;
            }            
        }
        return c;
    }
}
