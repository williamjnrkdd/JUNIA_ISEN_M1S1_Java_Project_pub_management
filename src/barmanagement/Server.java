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

    public Server(String firstName, String nickName, int wallet, String meaningfulCry) {
        super(firstName, nickName, wallet, meaningfulCry);
    }
  
    
    public void accessBarStock(){
        
    }
    
    @Override
    public void receiveMoney(int amount){
        System.out.println("*Server receives " + amount + " *");
        this.pay(bar)
    }
}
