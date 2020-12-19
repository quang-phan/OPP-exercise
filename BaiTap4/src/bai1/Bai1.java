/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author User
 */
public class Bai1 {
    public static void main(String[] args) {
        try{
            new MatHang().nhap("ƯUÈHƯ", "FJHƯEÌUQƯ", 100);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
