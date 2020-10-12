
package bai7;


public class StackOfChars {
    private char[] ch;
    private int size = -1;

    public StackOfChars() {
        ch = new char[16];
    }
    
    public StackOfChars(int capacity){
        ch = new char[capacity];
    }
    
    public boolean isEmpty(){
        return (size == -1);
    }
    
    public boolean isFull(){
        return (size == ch.length-1);
    }
    
    public char peak() {
        return ch[size];
    }
    
    public void push(char c){
        if(!isFull()){
            size++;
            ch[size] = c;
        }
        else throw new ArithmeticException("stack overflow");
    }
    
    public char pop(){
        if(!isEmpty()){
            char c = ch[size];
            size--;
            return c;
        }
        else throw new ArithmeticException("Stack is empty!");
    }

    public int getSize() {
        return size+1;
    }
    
    
}
