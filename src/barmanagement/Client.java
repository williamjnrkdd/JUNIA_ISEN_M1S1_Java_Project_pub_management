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
public class Client extends Human {
    public Drink favouriteDrink;
    public Drink backupDrink;
    public int alcoholLevel = 0;
    
    Client(String firstName, String nickName, String meaningfulCry, Drink favouriteDrink, Drink backupDrink){
        super(firstName, nickName, meaningfulCry);
        this.favouriteDrink = favouriteDrink;
        this.backupDrink = backupDrink;
    }
    
    @Override
    public void drink(Drink drink) {
        this.speak("*Takes a sip of " + drink.name +"*"); 
        this.alcoholLevel += drink.alcoholPoints;
    }
    
//    public void receiveDrinkOffer(Drink drink){
//        drink.setOwner(this);
//    }
    
    public void present(){
        System.out.print("I am "+ this.firstName);
    }
    
    @Override
    public void receiveMoney(int amount){
        System.out.println("*"+ this.firstName + " receives " + amount+ " *");
        this.wallet += amount;
    }
    
    public void offerRoundOfDrinks() {
        this.speak("The next round is on me!!!");
//        this.pay(drink.sellingPrice * n)
        Bar.bartender.reactiontoRoundOfDrinks();
        Bar.boss.reactiontoRoundOfDrinks();
        
    }
    
    @Override
    public void order(Drink drink){
        this.speak("I will take a "+ drink.name);
        if(this.alcoholLevel > 10){
            Bar.boss.command(this);
        }
        else{
            //        this.pay(drink.sellingPrice, this);
        }
        
    }
    
    public void resistCommand(){
        this.speak("Give me more!");
        Bar.boss.exclude(this);
    }
    
}
