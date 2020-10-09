
package bai23;

public class LongestWay {
    private int n, max = -1, u;
    private int[] b;

    public LongestWay() {
    }
    
    public LongestWay(int[] x) {
        n = x.length;
        b = x;
        slove();
    }

    public void set(int[] b) {
        this.b = b;
        slove();
    }
    
    private void slove(){
        int t = 0, e = 0;
        for(int i = 1; i < n; i++){
            if(b[i] < b[i-1]){
                if((i-e) > max) {
                    max = i-e;
                    t = e;
                }
                e = i;
            }
        }
        u = t;
    }
    public void result(){
        System.out.println(u + " " + max);
    }
}
