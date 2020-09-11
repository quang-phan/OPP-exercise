
package bai20;

import bai10.NguyenTo;
import bai18.Mang;
import java.util.Random;

public class NearestPrime extends Mang{
    private int n;
    private int[] a;
    private NguyenTo nguyenTo = new NguyenTo();
    private Random random = new Random();
    
    public NearestPrime(int x){
        super(x);
        n = x;
        a = receive();
    }
    
    @Override
    public void randomArray() {
        int x;
        for(int i = 0; i < n; i++){
            x = random.nextInt(9000) + 1000;
            init(i, x);
        }
    }
    public int nearestPrime(int x){
        int z = -1, nearest = 10000;
        for(int i = 0; i < n; i++){
            if(nguyenTo.isprime(a[i])){
                if(Math.abs(x-a[i]) < nearest){
                    nearest = Math.abs(x-a[i]);
                    z = i;
                }
            }
        }
        return z  == -1 ? -1 : a[z];
    }
}
