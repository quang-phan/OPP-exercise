
package bai21;

import java.util.Random;

public class Bai21 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(500)+1;
        System.out.println("do dai mang "+n);
        SortArray array = new SortArray(n);
        array.randomArray();
        System.out.println("mang nhan duoc:");
        array.show();
        array.sort();
        System.out.println("mang nhan duoc sau xu li:");
        array.show2();
    }
}
