
package bai27;


public class Bai27 {
    public static void main(String[] args) {
        Reversible r = new Reversible();
        System.out.println("so thuan nghich co sau chu so");
        for(int i = (int)Math.pow(10, 5); i < Math.pow(10, 6); i++){
            if(r.reversible(i)) System.out.println(i);
        }
    }
}
