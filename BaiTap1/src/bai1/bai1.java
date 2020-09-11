
package bai1;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        for(int i = 0; i < a; i++){
            if(i == 0 || i == a-1) 
                for(int j = 0; j < b; j++) System.out.print("*");
            else{
                for (int j = 0; j < b; j++) {
                    if(j == 0 || j == b-1) System.out.print("*");
                    else System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
    
}
