//loi chay qua lau
package bai15;

import bai12.Bai12;
import bai14.Bai14;

public class Bai15 {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        int m =  (int)Math.pow(10, 6), n = (int)Math.pow(10, 10);
        System.out.println("cac so tu 7 den 9 chu"
                + " so thoa man yeu cau bai toan:");
        for(int i = m; i < n; i++){
//            System.out.println(i);
            if(i == Bai12.soDao(i)){
                if(check(i)){
                    if(Bai14.chiahet10(i)) System.out.println(i);
                }
            }
        }
    }
    public  static boolean check(int n){
        int x;
        while(n > 0){
            x = n%10;
            if(!(n == 6 || n == 0 || n == 8)) return false;
            n /= 10;
        }
        return true;
    }
}
