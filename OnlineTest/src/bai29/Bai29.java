/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai29;

import java.math.BigInteger;
import java.util.Scanner;

public class Bai29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n, x;
       
        BigInteger a, b;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            a = scanner.nextBigInteger();
            b = scanner.nextBigInteger();
            System.out.println(a.add(b));
        }
    }
}
