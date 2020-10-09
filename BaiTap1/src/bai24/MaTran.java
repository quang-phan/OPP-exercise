
package bai24;


public class MaTran {
    private int[][] a, b;
    private int m, n, sum = 0;

    public MaTran() {
    }
    public MaTran(int[][] a){
        this.a = a;
        m = a.length;
        n = a[0].length;
        b = new int[n][m];
        solve();
    }
    
    public MaTran(int m, int n){
        this.m = m;
        this.n = n;
        a = new int[m][n];
//        sum = m*n;
        topRight(0, m-1, 0, n-1);
    }

    public void setA(int[][] a) {
        this.a = a;
        m = a.length;
        n = a[0].length;
        b = new int[n][m];
        solve();
    }
    
    private void solve(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                b[j][i] = a[i][j];
            }
        }
    }
     public void chuyenVi(){
         for(int i = 0; i < n; i++){
             for(int j = 0; j < m; j++){
                 System.out.print(b[i][j]+" ");
             }
             System.out.println("");
         }
     }
    
    public int[][] muliply(int[][] c){
        int t = c.length, k = c[0].length;
        int[][] z = new int[m][k];
        if(t != n){
            System.err.println("hai ma tran khong the nhan");
            return z;
        }
        else{
            int sum;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < k; j++){
                    sum = 0;
                    for(int r = 0; r < n; r++) sum += a[i][r]*c[r][j];
                    z[i][j] = sum;
                }
            }
            return z;
        }
    }
    
    public void show(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.printf("%4d ", a[i][j]);
            }
            System.out.println("");
        }
    }
    
    private void topRight(int i1, int i2, int j1, int j2){
        if((i2 - i1) < 0 && (j2-j1) < 0) return;
        for(int j = j1; j <= j2; j++){
            a[i1][j] = ++sum;
        }
        for(int i = i1+1; i <= i2; i++){
            a[i][j2] = ++sum;
        }
        bottomLeft(i2, i1+1, j2-1, j1);
    }
    
    private void bottomLeft(int i1, int i2, int j1, int j2){
        if((i1-i2) < 0 && (j1-j2) < 0) return;
        for(int j = j1; j >= j2; j--){
            a[i1][j] = ++sum;
        }
        for(int i = i1-1; i >= i2; i--){
            a[i][j2] = ++sum;
        }
        topRight(i2, i1-1, j2+1, j1);
    }
}
