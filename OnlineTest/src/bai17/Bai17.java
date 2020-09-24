/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai17;

import java.util.Scanner;

public class Bai17 {
    public static void main(String[] args) {
        int t, n;
        boolean ok;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t > 0){
            t--;
            n = scanner.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
            for(int i = 0; i < n-1; i++){
                ok = true;
                for(int j = i+1; j < n; j++){
                    if(a[j] >= a[i]){
                        ok = false;
                        break;
                    }
                }
                if(ok) System.out.print(a[i]+" ");
            }
            System.out.println(a[n-1]);
        }
    }
    
}
