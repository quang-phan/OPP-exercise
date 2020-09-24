/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai23;

import java.util.Scanner;

public class Bai23 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int t;
         String s;
         s = scanner.nextLine();
         t  = Integer.parseInt(s);
         while(t > 0){
             t--;
             s = scanner.nextLine();
             if(soDep(s)) System.out.println("YES");
             else System.out.println("NO");
         }
    }
    public static boolean soDep(String s){
        String a;
        int n = s.length(), x;
        char[] b = s.toCharArray();
        StringBuilder builder = new StringBuilder(s);
        builder.reverse();
        a = builder.toString();
        if(!s.equals(a)) return false;
        b[0] = s.charAt(0);
        for(int i = 0; i < n; i++){
            x = b[i]-'0';
            if((x&1) != 0) return false;
        }
        return true;
    }
}
