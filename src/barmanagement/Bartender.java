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
public class Bartender extends Human {
    
    Bartender(String firstName, String nickName, String meaningfulCry){
        super(firstName, nickName, meaningfulCry);
    }
    
    @Override
    public boolean receiveDrinkOffer(Drink drink){
        if(drink.alcoholState){
         this.speak("I am sorry. I cannot accept alcoholic drinks.");
         return false;
        }
        else{
            this.speak("Yes please, thank you!");
            return true;
        }
    }
    
    @Override
    public void drink(Drink drink) {
        System.out.println("*"+this.firstName+" is getting a " + drink.name + "*");
        this.speak("*Takes a sip of " + drink.name +"*");
    }
    
    @Override
    public void offerDrink(Human human, Drink drink) {
        try{
            if(this.wallet >= drink.sellingPrice && human.getPopularityRating() >  10){
                System.out.println(human.firstName + ", would you like some "+ drink.name + " ?");
                if(human.receiveDrinkOffer(drink)){
//                    this.pay(drink.sellingPrice, Bar.);
                }
            }
            else{
                throw new NotEnoughBalanceException();
            }
        }
        catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void receiveMoney(int amount){
        System.out.println("*BarTender receives " + amount + " *");
        Bar.fund.setAmount(amount);
    }
    
    public void reactiontoRoundOfDrinks(){
        this.speak("General round!");
    }
    
    public void returnLiquidity(){
        Bar.boss.receiveMoney(Bar.fund.amount);
        Bar.fund.amount = 0;
    }
}