
package bai17;

public class ToHop {
    private int n;
    private long[][] c = new long[21][];
    public ToHop(int x){
        this.n = x;
        for(int i = 0; i <= n; i++) c[i] = new long[i+1];
        for(int i = 0; i <= n; i++){
            c[i][0] = c[i][i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++) c[i][j] = c[i-1][j] + c[i-1][j-1];
        }
    }
    public void show(){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < i+1; j++) System.out.print(c[i][j]+ " ");
            System.out.println("");
        }
    }
}
