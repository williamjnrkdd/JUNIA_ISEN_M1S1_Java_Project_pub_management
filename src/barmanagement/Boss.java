package barmanagement;

/**
 *This class represents the boss the bar.
 * @author Will
 */
public class Boss extends Client {
    
    Boss(String firstName, String nickName, String meaningfulCry, Drink favouriteDrink, Drink backupDrink){
        super(firstName, nickName, meaningfulCry, favouriteDrink, backupDrink);
    
    }
    
    /**
     * This is the reaction of the boss when a client offers a round of drinks. 
     */
    public void reactiontoRoundOfDrinks(){
        this.speak("All is well, business is picking up.");
    }
    
    /**
     * This allows the boss to take cash from the Bartender when the cash in the register is too much.
     * @param amount 
     */
    @Override
    public void receiveMoney(int amount){
        this.wallet += amount; 
        System.out.println("*Boss receives liquidity from Bartender");
    }
    
    /**
     * Allows the boss to offer a drink to a person.
     * @param human
     * @param drink 
     */
    @Override
    public void offerDrink(Human human, Drink drink) {
        System.out.println(human.firstName+", would you like some "+ drink.name + " ?");
        if(human.receiveDrinkOffer(drink)){
             this.popularityRating++;
        }       
    }
    
    /**
     * This method allows the boss to give commands.
     * @param client 
     */
    public void command(Client client){
        this.speak("Do not serve " + client.firstName + " !");
    }
    
    /**
     * This allows the boss to exclude a client temporarily.
     * @param client 
     */
    public void exclude(Client client){
        this.speak("Please escort "+ client.firstName + " out!");
    }
}
