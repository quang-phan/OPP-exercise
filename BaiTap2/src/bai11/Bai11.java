
package bai11;

import bai10.MyPoint;
import java.util.Scanner;

public class Bai11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //hien thi ket qua sau khi nhap toa do cac diem
        System.out.println(tamGiac(canh(nhapToaDo(scanner))));
    }
    //nhap toa do ba diem
    public static MyPoint[] nhapToaDo(Scanner scanner){
        MyPoint[] points = new MyPoint[3];
        
        for(int i = 0; i < 3; i++){
           
            System.out.print("nhap toa do diem thu "+(i+1)+": ");
            points[i] = new MyPoint(scanner.nextDouble(),
                     scanner.nextDouble());
        }
        return points;
    }
    //tinh khoang cach giua ba diem
    public static double[] canh(MyPoint[] point){
        double[] a = new double[3];
        int z = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = i+1; j < 3; j++){
                a[z] = MyPoint.distance(point[i], point[j]);
                z++;
            }
        }
        
        return a;
    }
    //kiem tra khoang cach ba diem co la tam giac
    public static String tamGiac(double[] canh){
        if(canh[0] + canh[1] > canh[2] && canh[0]+canh[2] > canh[1]
                && canh[1]+canh[2] > canh[0]){
            if(canh[0] == canh[1] && canh[0] == canh[2]) return "tam giac deu";
            if(canh[0] == canh[1]){
                if(Math.pow(canh[0], 2)+Math.pow(canh[1], 2) == 
                        Math.pow(canh[2], 2)){
                    return "tam giac vuong can";
                }
                return "tam giac can";
            }
            if(canh[0] == canh[2]){
                if(Math.pow(canh[0], 2)+Math.pow(canh[2], 2) == 
                        Math.pow(canh[1], 2)){
                    return "tam giac vuong can";
                }
                return "tam giac can";
            }
            if(canh[1] == canh[2]){
                if(Math.pow(canh[1], 2)+Math.pow(canh[2], 2) == 
                        Math.pow(canh[0], 2)){
                    return "tam giac vuong can";
                }
                return "tam giac can";
            }
            if(Math.pow(canh[0], 2)+Math.pow(canh[1], 2) == 
                    Math.pow(canh[2], 2)
                || Math.pow(canh[0], 2)+Math.pow(canh[2], 2) ==
                    Math.pow(canh[1], 2)
               || Math.pow(canh[1], 2)+Math.pow(canh[2], 2) == 
                    Math.pow(canh[0], 2)){
                return "tam giac vuong";
            }
            return "ba diem tao thanh tam giac";
        }
        return "ba diem khong tao thanh tam giac";
    }
}
