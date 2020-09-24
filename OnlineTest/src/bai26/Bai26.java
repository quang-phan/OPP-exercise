/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai26;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Bai26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t; 
        String s;
        s = scanner.nextLine();
        t = Integer.parseInt(s);
        while(t > 0){
            t--;
            s = scanner.nextLine();
            chuanHoa(s);
        }
    }
    
    public static void chuanHoa(String s){
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder builder;
        String x, kq = "";
        while(st.hasMoreTokens()){
            x = st.nextToken().toLowerCase();            
            builder = new StringBuilder(x);
            x = x.toUpperCase();
            builder.setCharAt(0, x.charAt(0));
            kq += builder.toString()+" ";
        }
        String[] a = kq.split(" ");
        int n = a.length;
        for(int i = 1; i < n-1; i++) System.out.print(a[i]+" ");
        System.out.print(a[n-1]+", ");
        System.out.print(" "+a[0].toUpperCase()+"\n");
       
    }
}
