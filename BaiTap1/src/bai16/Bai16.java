
package bai16;

import bai10.NguyenTo;
import bai12.Bai12;

public class Bai16 {
    static NguyenTo nt = new NguyenTo();
    public static void main(String[] args) {
        int m = (int)Math.pow(10, 6), n = (int)Math.pow(10, 7);
        System.out.println("cac so thoa man yeu cau de bai: ");
        for(int i = m; i < n; i++){
            if(kiemTra(i)) System.out.println(i);
        }
    }
    public static boolean kiemTra(int n){
        int x;
        if(nt.isprime(n)){
            if(nt.isprime(Bai12.soDao(n))){
                while(n > 0){
                    x = n%10;
                    if(!nt.isprime(x)) return false;
                    n /= 10;
                }
                return true;
            }
        }
        return false;
    }
}
