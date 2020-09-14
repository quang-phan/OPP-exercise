
package bai27;


public class Reversible {
    private String re = "";

    public Reversible() {
        
    }
    
    public boolean reversible(int a){
        Integer b = a;        
        re = b.toString();
        StringBuffer buffer = new StringBuffer(re);
        String s = buffer.reverse().toString();
        return (s.equals(re));
    }
}
