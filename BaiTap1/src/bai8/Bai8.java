
package bai8;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        System.out.println(tong(a));
    }
    public static long tong (long n){
        long sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
