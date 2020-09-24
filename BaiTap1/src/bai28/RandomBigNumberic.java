
package bai28;

import java.math.BigInteger;
import java.util.Random;

public class RandomBigNumberic {
    private int n;
    private Random random = new Random();
    private String s = "";

    public RandomBigNumberic() {
    }

    public RandomBigNumberic(int n) {
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public BigInteger getNumber(){
        int x;
        s = "";
        BigInteger t;
        for(int i = 0; i < n; i++){
            x = random.nextInt(10);
            s += x;
        }
        t = new BigInteger(s);
        return t;
    }
    
    public BigInteger getNumber(int z){
        n = z;
        int x;
        s = "";
        BigInteger t;
        for(int i = 0; i < n; i++){
            x = random.nextInt(10);
            s += x;
        }
        t = new BigInteger(s);
        return t;
    }
}
