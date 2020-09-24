/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai20;

import java.util.Arrays;
import java.util.Scanner;

public class Bai20 {
    public static void main(String[] args) {
        int t, n;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t > 0){
            t--;
            n = scanner.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                a[i] *= a[i];
            }
            if(pytago(a)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public  static  boolean pytago(long[] a){
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(kiem(a, a[i]+a[j])) return true;
            }
        }
        return false;
    }
    public static boolean kiem(long[] a, long x){
       int n = a.length;
       int i = Arrays.binarySearch(a, x);
       if(i >= 0) return true;
       else return false;       
    }
}
