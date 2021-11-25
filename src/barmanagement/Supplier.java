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
public class Supplier extends Human {

    public Supplier(String firstName, String nickName,String meaningfulCry) {
        super(firstName, nickName, meaningfulCry);
    }
    
    /**
     * Method allows supplier receive an order from the bartender.
     */
    public void receiveOrder() {

    }
    
    /**
     * Method allows supplier to deliver the content of an order.
     */
    public void deliverOrder(){

    }

    /**
     * Method allows supplier to receive money from bartender for an order.
     */
    public void receivePay() {

    }

    @Override
    public void receiveMoney(int amount) {
        System.out.println("*"+ this.firstName + " receives " + amount+ " *");
        this.wallet += amount;    
    }
}
