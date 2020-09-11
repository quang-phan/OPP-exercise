
package bai3;

import java.util.Random;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = -1, d = 0;
        while(b != a){
            d++;
            b = 10+random.nextInt(90);
            System.out.println("buoc "+d+": " + b);
        }
    }
}
