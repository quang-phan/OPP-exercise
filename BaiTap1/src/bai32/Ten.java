/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai32;

import java.util.StringTokenizer;
import java.util.Vector;

public class Ten {
    private String s = "";

    public Ten() {
    }
    
    public Ten(String s){
        this.s = s;
    }
    
    void chuyen(String b){
        s = b;
        String x;
        Vector<String> a = new Vector<>();
        if(s.equals("")){
            System.out.println("ten chua duoc nhap!");
            return;
        }
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            x = st.nextToken();
            a.add(x);
        }
        x = "";
        x += a.get(0)+" "+a.get(1);
        for(int i = 2; i < a.size(); i++){
            x = a.get(i)+" "+x;
        }
        System.out.println(x);
    }
}
