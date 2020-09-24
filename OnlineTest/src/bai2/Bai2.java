/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.BitSet;
import java.util.Scanner;


public class Bai2 {
    public static void main(String[] args) {
        int n = 1000000000;
        int z = (int)Math.sqrt(n), j;
        BitSet a = new BitSet(n);
        a.flip(0, n);
        a.set(0, false);
        a.set(1, false);
        for(int i = 4; i < n; i += 4) a.set(i, false);
        for(int i = 3; i <= z; i += 2){
            j = i*i;
            if(a.get(i)){
                a.set(i, false);
                j += i;
            }
        }
        int t, x;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t > 0){
            t--;
            x = scanner.nextInt();
            if(a.get(x)) System.out.println("YES");
            else System.out.println("NO");
        }
       
    }
}
