
package bai14;

import bai12.Bai12;
import javax.swing.text.StyledEditorKit;

public class Bai14 {
    public static void main(String[] args) {
        System.out.println("so thuan nghich 6 chu so tong chia het cho 10");
        for(int i = (int)Math.pow(10, 5); i < (int)Math.pow(10, 6); i++){
            if(i == Bai12.soDao(i)){
                if(chiahet10(i)) System.out.println(i);
            }
        }
    }
    public static boolean chiahet10(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n /= 10;
        }
        if(sum%10 == 0) return true;
        else return false;
    }
}
