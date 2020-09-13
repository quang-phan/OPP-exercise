
package bai21;

import bai18.Mang;
import java.util.Arrays;

public class SortArray extends Mang{
    private int[] a;
    private int n, z = 0;
    private int[] b;

    public SortArray(int x) {
        super(x);
        n = x;
        b = new int[x];
    }

    @Override
    public void randomArray() {
        super.randomArray(); 
        a = receive();
    }
   
    public void sort(){
       Arrays.sort(a);
       b[z] = a[0];
       z++;
       for(int i = 0; i < n; i++){
           if(b[z-1] != a[i]){
               b[z] = a[i];
               z++;
           }
       }
    }

    
    public void show2(){
        for(int i = 0; i < z; i++){
            if((i+1)%21 == 0) System.out.println();
            System.out.print(b[i]+" ");
        }

        System.out.println("");
    }

    @Override
    public void show() {
        super.show(); 
    }
    
    
}
