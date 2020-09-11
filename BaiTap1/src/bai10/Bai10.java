
package bai10;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
        NguyenTo nguyenTo = new NguyenTo();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), d = 0;
        int z = Integer.MAX_VALUE;
        System.out.println("cac so nguyen to la: ");
        System.out.println("2");
        d++;
        for(int i  = 3; i < z; i+= 2){
            if(nguyenTo.isprime(i)){
                System.out.println(i);
                d++;
            }
            if(d == n) break;
        }
    }
}
