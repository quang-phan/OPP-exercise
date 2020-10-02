
package bai1;

// Java code to show IndexOutofBoundException 

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Demo { 
  
    public static void main(String[] args) 
    {
        
        //khởi tạo đối tượng list thông qua lớp ArrayList
        AbstractList<Integer> list = new ArrayList<>();
        
        //thêm phần tử vào list
        list.add(10);
        list.add(20);
        list.add(90);
        list.add(20);
        list.add(50);
        list.add(80);
        
        //tạo list2 lấy phần tử từ vị trí 1 đến 4 của list
        List<Integer> list2 = list.subList(1, 5);
        
       //hien thị màn hình
        System.out.println("list: "+list);
        System.out.println("list2: "+list2);
    } 
}
