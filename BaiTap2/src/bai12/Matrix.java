
package bai12;

import java.util.Scanner;

public class Matrix {
    private float[][] a;
    
    public Matrix(){
        a = new float[3][3];
    }
    
    public Matrix(int rows, int cols){
        a = new float[rows][cols];
    }
    
    public Matrix add(Matrix m){
        if(m.a.length == a.length && m.a[0].length == a[0].length){
            int x = a.length, y = a[0].length;
            Matrix c = new Matrix(x, y);
            
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    c.a[i][j] = a[i][j] + m.a[i][j];
                }
            }
            return c;
        }
        else throw new ArithmeticException("ma tran khong hop le");
    }
    
    public Matrix sub(Matrix m){
        if(m.a.length == a.length && m.a[0].length == a[0].length){
            int x = a.length, y = a[0].length;
            Matrix c = new Matrix(x, y);
            
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    c.a[i][j] = a[i][j] - m.a[i][j];
                }
            }
            return c;
        }
        else throw new ArithmeticException("ma tran khong hop le");
    }
    
    public Matrix neg(){
        int x = a.length, y = a[0].length;
        Matrix c = new Matrix(x, y);
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                c.a[i][j] = -1*a[i][j];
            }
        }
        
        return c;
    }
    
    public Matrix transpose(){
        int x = a.length, y = a[0].length;
        
        Matrix c = new Matrix(y, x);
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                c.a[j][i] = a[i][j];
            }
        }
        
        return c;
    }
    
    public Matrix mul(Matrix m){
        int x1 = a.length, y1 = a[0].length;
        int x2 = m.a.length, y2 = m.a[0].length;
        
        if(y1 == x2){
            Matrix c = new Matrix(x1, y2);
            float sum = 0;
            
            for(int i = 0; i < x1; i++){
                for(int j = 0; j < y2; j++){
                    sum = 0;
                    for(int r = 0; r < y1; r++) sum += a[i][r]*m.a[r][j];
                    c.a[i][j] = sum;
                }
            }
            
            return c;
        }
        else throw new ArithmeticException("ma tran nhap vao khong hop le");
    }
    
    public void print(){
        int x = a.length, y = a[0].length;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public void input(){
        Scanner scanner = new Scanner(System.in);
        int x = a.length, y = a[0].length;
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++) a[i][j] = scanner.nextFloat();
        }        
    }
}
