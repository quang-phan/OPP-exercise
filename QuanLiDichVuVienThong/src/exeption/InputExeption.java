/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeption;

/**
 *
 * @author ADMIN
 */
public class InputExeption extends Exception{
    public InputExeption(){
        super();
    }
    
    public InputExeption(String message){
        super(message);
    }
}
