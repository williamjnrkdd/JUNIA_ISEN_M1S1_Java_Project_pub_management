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
    public int wallet;
    private int popularityRating = 0;
    private String meaningfulCry;  

    public Human(String firstName, String nickName, int wallet, String meaningfulCry) {
        this.firstName = firstName;
        this.nickName = nickName;
        this.wallet = wallet;
        this. meaningfulCry = meaningfulCry;
    }

    public void speak(String message) {
        System.out.println(this.firstName + ": " + message);
    }
    
    public void drink(Drink drink) {
        System.out.println("*"+this.firstName+" is getting a " + drink.name + "*");
        try{
            this.pay(drink);
            this.speak("*Takes a sip of " + drink.name +"*");
        }
        catch(Exception e){
         System.out.println(e.getMessage());
        }
    }
     
     public void pay(Drink drink, Human receiver) throws Exception {
            if(this.wallet >= drink.sellingPrice){
                this.wallet -= drink.sellingPrice;
                receiver.receiveMoney(drink.sellingPrice);
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
                    this.pay(drink);
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