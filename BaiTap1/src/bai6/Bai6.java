package bai6;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;
        a = input.nextInt();
        b = input.nextInt();
        int x = ucln(a, b);
        System.out.println("ucln: "+x);
        System.out.println("bcnn: "+(a*b)/x);
    }
    
   public static int ucln(int x, int y){
       int temp;
       while(y > 0){
           temp = x%y;
           x = y;
           y = temp;
       }
       return x;
   }
   public static long ucln(long x, long y){
       long temp;
       while(y>0){
           temp = x%y;
           x = y;
           y = temp;
       }
       return x;
   }
}


