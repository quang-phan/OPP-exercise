/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai18;

import java.util.Scanner;

public class Bai18 {
    public static void main(String[] args) {
        int t, n;
        boolean ok;
        long sum, sum2;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t > 0){
            t--;
            ok = true;
            sum = 0;
            sum2 = 0;
            n = scanner.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                sum += a[i];
            }
            sum -= a[0];
            for(int i = 1; i < n; i++){
                sum2 += a[i-1];
                sum -= a[i];
                if(sum == sum2){
                    System.out.println(i+1);
                    ok = false;
                    break;
                }
            }
            if(ok) System.out.println("-1");
        }
    }
}
