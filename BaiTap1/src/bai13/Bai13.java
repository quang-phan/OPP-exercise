package bai13;

import java.util.Scanner;

public class Bai13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double c = input.nextDouble();
        double kq = sum(c);
        System.out.println("ket qua: "+4*kq);
    }
    public static double sum(double c){
        double i = 0;
        double kq = 0;
        while(true){
            if((1/(2*i+1)) <= c) break;
//            System.out.println(Math.pow(-1, i)*(1/(2*i+1)));
            kq += Math.pow(-1, i)*(1/(2*i+1));
            i++;
        }
//        System.out.println(kq);
        return kq;
    }
}
