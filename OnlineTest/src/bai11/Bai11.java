/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai11;

import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, a, b, c;
        t = scanner.nextInt();
        while(t > 0){
            t--;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = ucln(a, b);
            System.out.println((((long)a*b)/c)+" "+c);
        }
    }
    
    public static int ucln(int a, int b){
        int temp;
        while(b > 0){
            temp = a % b;
            a = b;
            b = temp; 
        }
        return a;
    }
}
