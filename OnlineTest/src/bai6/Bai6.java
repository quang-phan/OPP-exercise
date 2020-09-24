/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n, d = 0;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            d++;
            n = scanner.nextInt();
            Map<Integer, Integer> map = new LinkedHashMap<>();
            int[] a = new int[n];
            for(int i = 0;  i < n; i++) a[i] = scanner.nextInt();
            for(int i = 0; i < n; i++) add(map, a[i]);
            System.out.println("Test "+d+":");
            for(Integer k : map.keySet()){
                System.out.println(k+" xuat hien "+map.get(k)+" lan");
            }
        }
    }

    public static void add(Map<Integer, Integer> map, int k){
        if(map.containsKey(k)){
            int count = map.get(k) + 1;
            map.put(k, count);
        }
        else{
            map.put(k, 1);
        }
    }
}
