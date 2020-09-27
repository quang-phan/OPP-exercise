
package bai1;

import java.util.*;
import java.util.LinkedList;

public class Demo {

    public static void main(String[] args) {
        //tạo một đối tượng linkedList
        AbstractCollection<Object> abs = new LinkedList<>();
        //thêm các phần tử
        abs.add("hello");
        abs.add("I'm");
        abs.add("java");
        abs.add("programming");
        abs.add("language");
        
        AbstractCollection<Object> abs2 = new LinkedList<>();
        abs2.add("hello");
        abs2.add("I'm");
        abs2.add("java");
        abs2.add("programming");
        abs2.add("language");
        
        
        System.out.println(abs2.toString());
    }
    
}
