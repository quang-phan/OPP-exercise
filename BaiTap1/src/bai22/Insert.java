
package bai22;

public class Insert {
    private int n;
    private int[] a;

    public Insert() {
    }
    public Insert(int[] a){
        this.a = a;
        n = a.length;
    }
    public void set(int[] a){
        this.a = a;
        n = a.length;
    }
    public int[] insert(int x, int[] b){
        int m = b.length, z = 0;
        int[] c = new int[m+n];
        for(int i = 0; i < x; i++) {
            c[z] = a[i];
            z++;
        }
        for(int i = 0; i < m; i++){
            c[z] = b[i];
            z++;
        }
        for(int i = x; i < n; i++){
            c[z] = a[i];
            z++;
        }
        return c;
    }
    public int[] insert(int[] t, int x, int[] b){
        int m1 = t.length, m2 = b.length, z = 0;
        int[] c = new int[m2+m1];
        for(int i = 0; i < x; i++){
            c[z] = t[i];
            z++;
        }
        for(int i = 0; i < m2; i++){
            c[z] = b[i];
            z++;
        }
        for(int i = x; i < m1; i++){
            c[z] = t[i];
            z++;
        }
        return c;
    }
}
