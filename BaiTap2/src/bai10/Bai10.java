
package bai10;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double max = -1;
        MyPoint x = null, y = null;
        
        System.out.print("so luong diem: ");
        int n = scanner.nextInt();
        
        MyPoint[] points = new MyPoint[n];
        
        for(int i = 0; i < n; i++){
            System.out.print("\nnhap toa do diem thu "+(i+1)+": ");
            points[i] = 
                    new MyPoint(scanner.nextDouble(), scanner.nextDouble());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                double temp = MyPoint.distance(points[i], points[j]);
                if(temp > max){
                    max = temp;
                    x = points[i];
                    y = points[j];
                }
            }
        }
        
        System.out.println("\nhai diem co khoang cach lon nhat trong toa do:");
        System.out.println("diem 1: x = "+x.getX()+", y = "+x.getY());
        System.out.println("diem 2: x = "+y.getX()+", y = "+y.getY());
        System.out.println("khoang cach: "+max);
    }
}
