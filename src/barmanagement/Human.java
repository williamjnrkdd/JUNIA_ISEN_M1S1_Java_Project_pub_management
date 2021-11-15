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
abstract public class Human {
    public final String firstName;
    public String nickName;
    public int wallet = 0;
    protected int popularityRating = 0;
    public String meaningfulCry;  

    public Human(String firstName, String nickName, String meaningfulCry) {
        this.firstName = firstName;
        this.nickName = nickName;
        this. meaningfulCry = meaningfulCry;
    }

    public void speak(String message) {
        System.out.println(this.firstName + ": " + message);
    }
    
    public void drink(Drink drink) {
        this.speak("*Takes a sip of " + drink.name +"*");        
    }
    
    public void order(Drink drink){
        this.speak("I will take a "+ drink.name);
//        this.pay(drink.sellingPrice, this);
        
    }
     
     public void pay(int amount, Human receiver) throws Exception {
            if(this.wallet >= amount){
                this.wallet -= amount;
                receiver.receiveMoney(amount);
            }
            else{
                throw new NotEnoughBalanceException();
            }
    }
    
    abstract public void receiveMoney(int amount);
    
     
    public void offerDrink(Human human, Drink drink) {
        try{
            if(this.wallet >= drink.sellingPrice){
                System.out.println(human.firstName+", would you like some "+ drink.name + " ?");
                if(human.receiveDrinkOffer(drink)){
//                    this.pay(drink.sellingPrice, );
                     popularityRating++;
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
    
    public boolean receiveDrinkOffer(Drink drink){
        this.speak("Yes please, thank you!");
        return true;
    }
     
    public void present() {
        String introduction = "Hey people, I am " + this.firstName + ". Mostly known as " + this.nickName + "!";
        if(this.popularityRating == 0){
            introduction +=" This is my first time here.";
        }
        this.speak(introduction);
        popularityRating++;
        
    }
    
    public int getWallet() {
        return wallet;
    }
    
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    
    
    public int getPopularityRating(){
        return popularityRating;
    }
    
    public void setPopularityRating(int popularityRating) {
        this.popularityRating = popularityRating;
    }
     
    public String getMeaningfulCry() {
        return meaningfulCry;
    }
    
    public void setMeaningfulCry(String meaningfulCry) {
        this.meaningfulCry = meaningfulCry;
    }   
     
}