
import java.io.File;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Test {
    public static void main(String[] args) {
        File f = new File("NV.TXT");
        File f1 = new File("PB.TXT");
        try{
        PrintWriter printWriter = new PrintWriter(f);
        PrintWriter printWriter1 = new PrintWriter(f1);
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
}
