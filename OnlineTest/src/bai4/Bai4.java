/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int t, n,d = 0;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            d++;
            n = scanner.nextInt();
            System.out.print("Test " + d + ": ");
            thuaSo(n);
        }
        int[] a = new int[d];
        
    }
    
    public static void thuaSo(int n){
        int x = 0;
        while(n% 2 == 0){
            n /= 2;
            x++;
        }
        if(x != 0)System.out.printf("%d(%d) ", 2, x);
        for(int i = 3; i < n; i++){
            if(n%i == 0){
                x = 0;
                while(n % i == 0){
                    n /= i;
                    x++;
                }
                System.out.printf("%d(%d) ", i, x);
            }
        }
        if(n > 1) System.out.printf("%d(%d) ", n, 1);
        System.out.println();
    }
}
