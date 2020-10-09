
package bai9;

import java.util.Scanner;


public class Bai9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        System.out.println(thuaSoNT(a));
    }
    public static String thuaSoNT(long n){
        String kq = "";
        while(n%2 == 0) {
            kq += "x"+2;
            n /= 2;
        }
        
        for(long i = 3; i <= Math.sqrt(n); i += 2){
            while(n % i == 0){
                kq += "x" + i;
                n /= i;
            }
        }
        if(n > 1) kq += "x" + n;
        StringBuffer stringBuffer = new StringBuffer(kq);
        if(stringBuffer.charAt(0) == 'x'){
            stringBuffer = stringBuffer.delete(0, 1);
        }
        kq = stringBuffer.toString();
        return kq;
    }
}
