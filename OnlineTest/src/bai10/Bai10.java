/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai10;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), dao, max, z, d = 0;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
        for(int i = n-1; i > 0; i--){
            max = a[i]; z = i;
            for(int j = i-1; j >= 0; j--){
                if(a[j] > max){
                    max = a[j];
                    z = j;
                }
            } 
            if(z != i){
                d++;
                for(int r = z; r < i; r++) a[r] = a[r+1];
                a[i] = max;
                System.out.print("Buoc "+d+": ");
                for(int r = 0; r < n; r++) System.out.print(a[r]+" ");
                System.out.println();
            }
        }
    }
}
