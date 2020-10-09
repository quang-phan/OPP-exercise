
package bai19;

import bai18.Mang;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumberArray extends Mang{
    private int[] a;
    private int[] b = new int[900];
    private int n;
    public NumberArray(int x) {
        super(x);
        n = x;
        a = receive();
    }   

    @Override
    public void show() {
        HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 0, z=0;
        System.out.println("mang nhan duoc:");
        for(int i = 0; i < n; i++) {
            if((i+1)%21 == 0) System.out.println();
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int i = 0; i < 900; i++) b[i] = 0;
        for(int i = 0; i < n; i++){
            b[a[i]-100]++;
        }
        System.out.println("so lan xuat hien cac phan tu trong mang:");
        for(int i = 0; i < 900; i++){
            if(b[i] != 0){
                System.out.println((i+100) + ": " + b[i]);
                map.put(i+100, b[i]);
                if(max < b[i]){
                    max = b[i];
                }
            }
        }
        Set<Map.Entry<Integer, Integer>> setMap = map.entrySet();
        for(Map.Entry<Integer, Integer> i : setMap){
            if(i.getValue() == max){
                System.out.println("phan tu " + i.getKey() +" xuat hien nhieu"
                        + " nhat: "+i.getValue()+" lan");
            }
        }        
    }
    
}
