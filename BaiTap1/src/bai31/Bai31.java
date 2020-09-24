/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai31;

import java.util.Scanner;

public class Bai31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TimTu tu = new TimTu(s);
        tu.tuDaiNhat();
    }
}
