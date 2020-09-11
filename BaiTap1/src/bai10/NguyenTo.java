
package bai10;

public class NguyenTo {
    private int n = 10000000;
    private boolean[] nt;
    
    public NguyenTo(){
        this.nt = new boolean[n];
        for(int i = 0; i < n; i++) nt[i] = true;
        nt[0] = nt[1] = false;
        int i = 2*2;
        while(i < n){
            nt[i] = false;
            i += 2;
        }
        for(i = 3; i < Math.sqrt(n); i += 2){
            if(nt[i]){
                int j = i*i;
                while(j < n){
                    nt[j] = false;
                    j += i;
                }
            }
        }
    }
    public boolean isprime(int x){
        return nt[x];
    }
}
