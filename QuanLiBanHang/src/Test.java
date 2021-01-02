
import java.io.File;
import model.KhachHang;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Test {
    public static void main(String[] args) {
        try{
            File file = new File("HOADON.TXT");
            file.createNewFile();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
