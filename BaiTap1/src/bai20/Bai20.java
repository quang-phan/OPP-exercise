
package bai20;

import java.awt.BorderLayout;
import java.util.Random;
import java.util.Scanner;


public class Bai20 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner =  new Scanner(System.in);
        int n = random.nextInt(500)+1;
        System.out.println("do dai mang duoc tao: "+n);
        NearestPrime np = new NearestPrime(n);
        np.randomArray();
        System.out.println("mang nhan duoc");
        np.show();
        System.out.print("nhap so x: ");
        int x = scanner.nextInt();
        int a = np.nearestPrime(x);
        if(a != -1) System.out.println("so nguyen to gan voi x nhat: "+a);
        else System.out.println("khong co so nguyen to gan voi " + x + 
                " trong mang");
    }
}
