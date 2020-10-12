
package bai7;

import bai4.StackOfIntergers;

public class HauTo {
    private static int uuTien(char c){
        if(c == '*' || c == '/') return 100;
        if(c == '-' || c == '+') return 50;
        return -1;
    }
    
    public static String trungTo(String s){
        StackOfChars stack = new StackOfChars(100);
        String kq = "";
        int n = s.length();
        char c;
        for(int i = 0; i < n; i++){
            c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                kq += c;
            }
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                if(!stack.isEmpty()){
                   while(!stack.isEmpty() && uuTien(c) <= uuTien(stack.peak())){
                        kq += stack.pop();
                    } 
                }
                
                stack.push(c);
            }
            if(c == '('){
                stack.push(c);
            }
            if(c == ')'){
                while(stack.peak() != '('){
                    kq += stack.pop();
                }
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            kq += stack.pop();
        }
        return kq;
    }
    
    public static int tinh(String s){
        StackOfIntergers intergers = new StackOfIntergers(50);
        int n = s.length(), x, y;
        char c;
        
        for(int i = 0; i < n; i++){
            c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                intergers.push(c - '0');
            }
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                x = intergers.pop();
                y = intergers.pop();
                intergers.push(operator(y, x, c));
            }
        }
        return intergers.pop();
    }
    
    public static int operator(int x, int y, char c){
        switch(c){
            case '+':{
                return x+y;
                
            }
            case '-':{
                return x-y;
                
            }
            case '*':{
                return x*y;
                
            }
            case '/':{
                return x/y;
                
            }
        }
        return 0;
    }
}
