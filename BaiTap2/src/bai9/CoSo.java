
package bai9;

import bai7.StackOfChars;

public class CoSo {
    private static String s =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static String chuyenCoSo(int n, int b){
        StackOfChars chars = new StackOfChars(150);
        String kq = "";
        while(n > 0){
            chars.push(s.charAt(n%b));
            n /= b;
        }
        while(!chars.isEmpty()){
            kq += chars.pop();
        }
        return kq;
    }
}
