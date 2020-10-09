
package bai11;

public class Fibonaci {
    private long[] f = new long[91];
    public Fibonaci(){
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i < 91; i++) f[i] = f[i-1]+f[i-2];
    }
    public void show(int n){
        System.out.println(n + " so fibolaci dau tien la:");
        for(int i = 0; i < n; i++) System.out.println(f[i]);
    }
}
