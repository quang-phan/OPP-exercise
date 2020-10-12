
package bai6;

import bai4.StackOfIntergers;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        show(coSo(n));
    }
    
    public static StackOfIntergers coSo(int n){
        StackOfIntergers intergers = new StackOfIntergers(100);
        while(n > 0){
            intergers.push(n%2);
            n /= 2;
        }
        return intergers;
    }
    
    public static void show(StackOfIntergers intergers){
        while(!intergers.isEmpty()){
            System.out.print(intergers.pop());
        }
        System.out.println();
    }
}
