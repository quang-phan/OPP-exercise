/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            n = scanner.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
            if(doiXung(a)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean doiXung(int a[]){
        int n = a.length;
        for(int i = 0; i <= n/2; i++){
            if(a[i] != a[n-i-1]) return false;
        }
        return true;
    }
}
