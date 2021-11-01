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
    
    Client(String firstName, String nickName, int wallet, int popularityRating, String meaningfulCry, Drink favouriteDrink, Drink backupDrink){
        super(firstName, nickName, wallet, meaningfulCry);
        this.favouriteDrink = favouriteDrink;
        this.backupDrink = backupDrink;
    }

//    public final void setAlcoholLevel(int alcoholLevel) {
//        try{
//            if(alcoholLevel >= 0){
//                this.alcoholLevel = alcoholLevel;
//            }
//            else{
//                throw new LessThanZeroException("Alcohol level");
//            }
//        }
//        catch(LessThanZeroException e){
//            System.out.println(e.getMessage());
//        }
//    }
    
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
    
}
