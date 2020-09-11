
package bai19;

import java.util.Random;
import java.util.Scanner;

public class Bai19 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(1000)+1;
        System.out.println("do dai mang duoc tao: "+n);
        NumberArray numberArray = new NumberArray(n);
        numberArray.randomArray();
        numberArray.show();
    }
}
