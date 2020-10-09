
package bai5;

import bai4.StackOfIntergers;
import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap n: ");
        int n = scanner.nextInt();
        System.out.println("");
        
        StackOfIntergers intergers = new StackOfIntergers(100);
        
        while(n % 2 == 0){
            intergers.push(2);
            n /= 2;
        }
        
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            if(n%i == 0){
                intergers.push(i);
                n /= i;
            }   
        }
        
        if(n > 1) intergers.push(n);
        System.out.print("Ket qua: ");
        while(intergers.getSize() != 1){
            System.out.print(intergers.pop()+", ");
        }
        System.out.println(intergers.pop());
    }
}
