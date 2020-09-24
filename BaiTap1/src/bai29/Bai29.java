
package bai29;

import bai28.RandomBigNumberic;
import java.math.BigInteger;
import java.util.Random;

public class Bai29 {
    public static void main(String[] args) {
        int n;
        Random random = new Random();
        RandomBigNumberic rbn = new RandomBigNumberic();
        BigInteger a, b;
        
        n = random.nextInt(280)+21;
        a = rbn.getNumber(n);
        System.out.println("a = " + a);
        
        n = random.nextInt(280)+21;
        b = rbn.getNumber(n);
        System.out.println("b = " + b);
        
        System.out.println("a * b = " + a.multiply(b));
    }
}
