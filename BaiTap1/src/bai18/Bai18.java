
package bai18;

import java.util.Scanner;

public class Bai18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("chieu dai cua mang: ");        
        int n = scanner.nextInt();
        System.out.println();
        Mang mang = new Mang(n);
        System.out.print("so luong mang can tao: ");
//        int a = scanner.nextInt();
        System.out.print("\n-----------------\n");
        while(true){
//            a--;
            mang.randomArray();
            mang.show();
            if(mang.symmetry()) {
                System.out.println("mang doi xung");
                break;
            }
            else System.out.println("mang khong doi xung");
        }
    }
}
