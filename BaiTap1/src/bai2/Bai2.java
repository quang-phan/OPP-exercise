
package bai2;

import java.util.Scanner;

public class Bai2 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int d = 0, n = a+a-1, mid = (n-1)/2;
        int[][] b = new int[a][n];
       
        for (int i = 0; i < a; i++) {
            d++;
            b[i][mid] = d;
            int x = d-1;
            for(int j = mid-1; j >= 0; j--) {
                if(x > 0){
                    b[i][j] = x;
                    b[i][mid+(mid-j)] = x;
                    x--;
                }
                else break;
            }
        }
        
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < n; j++) {
                if(b[i][j] != 0) System.out.print(b[i][j]);
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
