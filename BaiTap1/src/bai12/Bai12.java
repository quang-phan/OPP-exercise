
package bai12;

public class Bai12 {
    public static void main(String[] args) {
        System.out.println("so thuan nghich co sau chu so:");
        for(int i = (int)Math.pow(10, 5); i < (int)Math.pow(10,6); i++){
            if(i == soDao(i)) System.out.println(i);
        }
    }
    
    public static int soDao(int n){
        int result = 0;
        while(n > 0){
            result = result*10 + n%10;
            n /= 10;
        }
        return result;
    }
}
