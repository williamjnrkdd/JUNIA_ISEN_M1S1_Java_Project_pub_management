/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmanagement;

/**
 *This class represents an exception for a value being less than zero.
 * @author William Kofi Danso DARKWA
 */
public class LessThanZeroException extends Exception{
    LessThanZeroException(String name){
        super(name);
    }
    
    @Override
    public String getMessage(){
        return super.getMessage() + " cannot be less than zero";
    }
   
}
