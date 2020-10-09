
package Bai3;

public class Rectange {
    private double width = 1;
    private double height = 1;
    private String color = "";

    public Rectange() {
    }
    
    public Rectange(double width, double height, String color){
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public double findArea(){
        return width*height;
    }
    
    public double findPerimeter(){
        return 2*(width+height);
    }
}
