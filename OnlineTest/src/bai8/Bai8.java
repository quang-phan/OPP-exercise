/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai8;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), dao, d = 0, min, z;
        int[] a = new  int[n];
        for(int i = 0; i < n; i++) a[i] = scanner.nextInt();
        for(int i = 0; i < n-1; i++){
            min = a[i];
            z = i;
            for(int j = i+1; j < n; j++){
                if(min > a[j]){
                    min = a[j];
                    z = j;
                }
            }
            d++;
            dao = a[i]; a[i] = a[z]; a[z] = dao;
            System.out.print("Buoc "+d+": ");
            for(int j = 0; j < n; j++) System.out.print(a[j]+" ");
            System.out.println();
            
        }
    }
}
