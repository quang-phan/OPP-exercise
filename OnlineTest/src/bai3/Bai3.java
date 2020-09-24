/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.util.Scanner;


public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] a = fibonacci();
        int t, n;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            n = scanner.nextInt();
            System.out.println(a[n-1]);
        }
    }
    public static long[] fibonacci(){
        long[] f = new long[92];
        f[0] = 1; f[1] = 1;
        for(int i = 2; i < 92; i++) f[i] = f[i-1]+f[i-2];
        return f;
    } 
}
