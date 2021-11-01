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
    private double alcoholLevel;
    
    Client(String firstName, String nickName, int wallet, int popularityRating, String meaningfulCry, Drink favouriteDrink, Drink backupDrink, double alcoholLevel){
        super(firstName, nickName, wallet, popularityRating, meaningfulCry);
        this.favouriteDrink = favouriteDrink;
        this.backupDrink = backupDrink;
        this.setAlcoholLevel(alcoholLevel);
    }

    public final void setAlcoholLevel(double alcoholLevel) {
        try{
            if(alcoholLevel < 0){
                this.alcoholLevel = alcoholLevel;
            }
            else{
                throw new LessThanZeroException("Alcohol level");
            }
        }
        catch(LessThanZeroException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void receiveDrinkOffer(Drink drink){
        drink.setOwner(this);
    }
    
    
}
