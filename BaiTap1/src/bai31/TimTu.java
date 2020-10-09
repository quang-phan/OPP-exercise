/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai31;

import java.util.StringTokenizer;

public class TimTu {
    private String s = "";
    private int d = 0;

    public TimTu() {
    }
    public TimTu(String s){
        this.s = s;
    }
    
    public void tuDaiNhat(){
        if(s.equals("")){
            System.out.println("chua nhap xau!");
            return;
        }
        StringTokenizer tokenizer = new StringTokenizer(s);
        String x = "", max = "";
        int z = 0;
        while(tokenizer.hasMoreTokens()){
            x = tokenizer.nextToken();
            d++;
            if(x.length() > max.length()){
                max = x;
                z = d;
            }
        }
        System.out.println("Tu dai nhat: \"" + max + "\" tai vi tri "+z);        
    }
    
    public void tuDaiNhat(String r){
        s = r;
        if(s.equals("")){
            System.out.println("chua nhap xau!");
            return;
        }
        StringTokenizer tokenizer = new StringTokenizer(s);
        String x = "", max = "";
        int z = 0;
        while(tokenizer.hasMoreTokens()){
            x = tokenizer.nextToken();
            d++;
            if(x.length() > max.length()){
                max = x;
                z = d;
            }
        }
        System.out.println("Tu dai nhat: \"" + max + "\" tai vi tri "+z); 
    }
}
