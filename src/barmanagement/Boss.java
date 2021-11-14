/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmanagement;

/**
 *
 * @author Will
 */
public class Boss extends Client {
    
    Boss(String firstName, String nickName, String meaningfulCry, Drink favouriteDrink, Drink backupDrink){
        super(firstName, nickName, meaningfulCry, favouriteDrink, backupDrink);
    
    }
    
    public void reactiontoRoundOfDrinks(){
        this.speak("All is well, business is picking up.");
    }
    
    @Override
    public void receiveMoney(int amount){
        this.wallet += amount; 
        System.out.println("*Boss receives liquidity from Bartender");
    }
    
    @Override
    public void offerDrink(Human human, Drink drink) {
        System.out.println(human.firstName+", would you like some "+ drink.name + " ?");
        if(human.receiveDrinkOffer(drink)){
             this.popularityRating++;
        }       
    }
    
    public void command(Client client){
        this.speak("Do not serve " + client.firstName + " !");
    }
    
    public void exclude(Client client){
        this.speak("Please escort "+ client.firstName + " out!");
        //exclusion
    }
}
