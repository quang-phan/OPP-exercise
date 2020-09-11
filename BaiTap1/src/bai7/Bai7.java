/*
* cặp số nguyên tố cùng nhau là cặp số có ước
* chung lớn nhất là 1
 */
package bai7;

import bai6.Bai6;
import static bai6.Bai6.ucln;
import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a  = input.nextInt();
        int b = input.nextInt(), d = 0;
        System.out.println("cac cap nguyen to cung nhau la:");
        for(int i = a; i <= b; i++){
            for(int j = i+1; j <= b; j++){
                if(ucln(i, j) ==  1){ 
                    d++;
                    System.out.println(d + ": " + i + " - " + j);
                }
            }
        }
    }
}
