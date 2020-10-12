
package bai10;

public class MyPoint {
    private double x = 0, y = 0;

    public MyPoint() {
    }
    
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public MyPoint(MyPoint p){
        x = p.x;
        y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double distance(MyPoint secondPoint){
        double result = Math.sqrt(Math.pow(x - secondPoint.x, 2)
                +Math.pow(y - secondPoint.y, 2));
        return result;
    }
    
    public static double distance(MyPoint p1, MyPoint p2){
        double result = Math.sqrt(Math.pow(p1.x-p2.x, 2)
                +Math.pow(p1.y-p2.y, 2));
        
        return result;
    }
}
