/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai9;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), d = -1, max;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
        for(int i = 0; i < n; i++){
            d++;
            int j = 0;
            while(j < i){                
                if(a[j] > a[i]) break;
                j++;
            }
            if(j < i){
                max = a[i];
                for(int z = i; z > j; z--){
                    a[z] = a[z-1];
                }
                a[j] = max;
            }
            System.out.print("Buoc "+d+": ");
            for(int z = 0; z <= i; z++) System.out.print(a[z]+" ");
            System.out.println();
        }
    }
}
