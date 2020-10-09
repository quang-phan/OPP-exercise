
package bai4;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] nt = nTo();
        
        int n = scanner.nextInt(), z = nt.length;
       
        StackOfIntergers intergers = new StackOfIntergers(n);
        
        for(int i = 2; i < n; i++){
            if(nt[i]) intergers.push(i);
        }
        while(!intergers.isEmpty()){
            System.out.println(intergers.pop());
        }
    }
    
    public static boolean[] nTo(){
        int n = 10000000;
        boolean[] nt = new boolean[n];
        for(int i = 2; i < n; i++) nt[i] = true;
        
        for(int i = 4; i < n; i += 2) nt[i] = false;
        
        for(int i = 3; i < Math.sqrt(n); i += 2){
            if(nt[i]){
                int j = i*i;
                while(j < n){
                    nt[j] = false;
                    j += i;
                }
            }
        }
        return nt;
    }
}
