/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        float sum = 0;
 
       for(int i = 1; i <= n; i++){
           sum += 1/((float)i);
       }
        System.out.println(sum);
    }
}
