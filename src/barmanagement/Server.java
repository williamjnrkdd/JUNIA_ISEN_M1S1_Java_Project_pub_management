/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmanagement;

/**
 *
 * @author Mary Denkyiwaa
 */
public class Server extends Human {
    Bartender bartender;

    public Server(String firstName, String nickName, int wallet, String meaningfulCry, Bartender bartender) {
        super(firstName, nickName, meaningfulCry);
    }
  
    
    public void accessBarStock(){
        
    }
    
    @Override
    public void receiveMoney(int amount){
        System.out.println("*Server receives " + amount + " *");
        this.wallet += amount;
        try{
            this.pay(amount, bartender);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
