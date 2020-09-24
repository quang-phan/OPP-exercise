/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai13;

import java.math.BigInteger;
import java.util.Scanner;

public class bai13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t;
        BigInteger a, b, c;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            a = scanner.nextBigInteger();
            b = scanner.nextBigInteger();
            System.out.println(a.gcd(b));
        }
    }
    
}

