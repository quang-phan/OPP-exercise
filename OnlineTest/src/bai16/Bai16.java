/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai16;


import java.util.Scanner;


public class Bai16 {
    static boolean[] a;
    static long sum = 0;
    public static void main(String[] args) {
        a = nguyenTo();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), x;
        for(int i = 0; i < n; i++) {
            x = scanner.nextInt();
            thuaSo(x);
        }
        System.out.println(sum);
    }
    public static void thuaSo(int n){  
        if(a[n]) sum += n;
        else{
            while(n % 2 == 0){
                n /= 2;
                sum += 2;
            }
            for(int i = 3; i <= Math.sqrt(n); i++){
                while(n % i == 0){
                    n /= i;
                    sum += i;
                   
                }
            }
            if(n > 1){
                
                sum += n;
            }
        }
        
    }
    public static boolean[] nguyenTo(){        
        int z = 2 * (int)1e6+1, j;
        int r = (int)Math.sqrt(z);
        boolean[] b = new boolean[z];
        b[2] = true;
        for(int i = 3; i < z; i += 2) b[i] = true;
        for(int i = 3; i <= r; i += 2){
            if(b[i]){
                j = i*i;
                while(j < z){
                    b[j] = false;
                    j += i;
                }
            }
        }
        return b;
    }
}
