
package bai30;


import java.util.Scanner;

public class Bai30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChuanHoa ch = new ChuanHoa();
        String s;
        System.out.print("nhap xau: ");
        s = scanner.nextLine();
        System.out.println("\nchuoi sau xu li: " + ch.chuan(s));
    }
}
