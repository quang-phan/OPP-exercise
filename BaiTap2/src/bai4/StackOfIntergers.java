
package bai4;

public class StackOfIntergers {
    private int[] elements;
    private int size = -1;

    public StackOfIntergers() {
        elements = new int[16];
    }
    
    public StackOfIntergers(int capacity){
        elements = new int[capacity];
    }
    
    public boolean isEmpty(){
        return (size+1 == 0);
    }
    
    public boolean isFull(){
        return (size+1 == elements.length);
    }
    
    public int peak(){
        if(size != -1){
            return elements[size];
        }
        else throw new ArithmeticException("stack rỗng");
    }
    
    public void push(int value){
        if(!isFull()){
            size++;
            elements[size] = value;            
        }
    }
    
    public int pop(){
        if(!isEmpty()){
            int x = elements[size];
            size--;
            return x;
        }
        else throw new ArithmeticException("stack rỗng");
    }

    public int getSize() {
        return size+1;
    }
}
