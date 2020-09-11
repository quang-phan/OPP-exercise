
package bai18;

import java.util.Random;

public class Mang {
    private int[] a = new int[1001];
    private int n;
    private Random random = new Random();
    public Mang(int x){
        n = x;
    }
    public void randomArray(){
        int x;
        for(int i = 0; i < n; i++){
            x = random.nextInt(900) + 100;
            a[i] = x;
        }
    }
    public void show(){
        for(int i = 0; i < n; i++){
            if((i+1)%21 == 0) System.out.println();
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public boolean symmetry(){
        int l = 0, r = n-1;
        while(l < r){
            if(a[l] != a[r]) return false;
            l++; r--;
        }
        return true;
    }
    protected int[] receive(){
        return a;
    }
    protected void init(int i, int x){
        a[i] = x;
    }
}
