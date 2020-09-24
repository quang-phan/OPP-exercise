/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai19;

import java.util.Arrays;
import java.util.Scanner;

public class Bai19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n, k, x, d;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            d = 0;
            n = scanner.nextInt();
            k = scanner.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = scanner.nextInt();            
            Arrays.sort(a);
            for(int i = 0; i < n-1; i++){
                x = k-a[i];
                if(x <= a[n-1]){
                    int j = Arrays.binarySearch(a, i+1, n, x);
                    if(j >= 0){
                        int r;
                        for(r = j-1; r > i; r--){                           
                            if(a[r] != x) break;
                             d++;
                        }
                        for(r = j+1; r < n; r++){
                            if(a[r] != x) break;
                            d++;
                        }
                    }
                }
            }
            System.out.println(d);
        }
    }
}
