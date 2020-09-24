
package bai28;

import java.math.BigInteger;
import java.util.Random;


public class Bai28 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(980)+21;
        BigInteger a, b;
        RandomBigNumberic rbn = new RandomBigNumberic(n);
        a = rbn.getNumber();
        System.out.print("so a: " + a + "\n");
        
        n = random.nextInt(980)+21;
        b = rbn.getNumber(n);
        System.out.print("so b: " + b + "\n");
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a * b = " + a.multiply(b));
        System.out.println("a / b = " + a.divide(b));
        
    }
}
