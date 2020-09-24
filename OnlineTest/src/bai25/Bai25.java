/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai25;

import java.util.Scanner;

public class Bai25 {
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
        int n = s.length(), x = 0;
        char[] b = s.toCharArray();
        StringBuilder builder = new StringBuilder(s);
        builder.reverse();
        a = builder.toString();
        if(!s.equals(a)) return false;
        
        for(int i = 0; i < n; i++){
            if(!(b[i] == '2' || b[i] == '3' || b[i] == '5' || b[i] == '7'))
                return false;
        }
        if(x%10 != 0) return false;
        return true;
    }
}
