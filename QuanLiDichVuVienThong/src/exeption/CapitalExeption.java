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
public class CapitalExeption extends Exception{
    public CapitalExeption(){
        super();
    }
    
    public CapitalExeption(String message){
        super(message);
    }
}
