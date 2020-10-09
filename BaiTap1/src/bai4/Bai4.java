
package bai4;


import java.util.Scanner;


public class Bai4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), sum = 0;
        if(n%2 != 0){
            for(int i = 1; i <= n; i += 2) sum += i;
        }
        else{
            for(int i = 2; i <= n; i += 2) sum += i;
        }
        System.out.println(sum);
        
    }
}
