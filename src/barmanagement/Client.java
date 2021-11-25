package barmanagement;

/**
 *Class represents a Client in bar.
 * @author William Kofi Danso DARKWA
 */
import java.util.Scanner;

public class Client extends Human {
    public Drink favouriteDrink;
    public Drink backupDrink;
    public int alcoholLevel = 0;
    
    Client(String firstName, String nickName, String meaningfulCry, Drink favouriteDrink, Drink backupDrink){
        super(firstName, nickName, meaningfulCry);
        this.favouriteDrink = favouriteDrink;
        this.backupDrink = backupDrink;
    }
    
    /**
     * Method for a client to take a glass of a drink.
     * @param drink 
     */
    @Override
    public void drink(Drink drink) {
        this.speak("*Takes a sip of " + drink.name +"*"); 
        this.alcoholLevel += drink.alcoholPoints;
    }
    
//    public void receiveDrinkOffer(Drink drink){
//        drink.setOwner(this);
//    }
    
    /**
     * Method for client to present himself/herself
     */
    public void present(){
        System.out.print("I am "+ this.firstName);
    }
    
    /**
     * Method for client to receive money.
     * @param amount 
     */
    @Override
    public void receiveMoney(int amount){
        System.out.println("*"+ this.firstName + " receives " + amount+ " *");
        this.wallet += amount;
    }
    
    /**
     * Method for client to offer round of drinks.
     */
    public void offerRoundOfDrinks() {
        this.speak("The next round is on me!!!");
//        this.pay(drink.sellingPrice * n)
        Bar.bartender.reactiontoRoundOfDrinks();
        Bar.boss.reactiontoRoundOfDrinks();
        for(int i= 0; i < Bar.tables.size() ; i++){
            for(int j= 0; j < Bar.tables.get(i).seats.length ; j++){
                Bar.tables.get(i).seats[j].speak(Bar.tables.get(i).seats[j].meaningfulCry);
            }
        }
    }
    
    /**
     * Method for client to order a drink.
     * @param drink 
     */
    @Override
    public void order(Drink drink){
        this.speak("I will take a "+ drink.name);
        if(this.alcoholLevel > 10){
            Bar.boss.command(this);
        }
        else{
            try{
                this.pay(drink.sellingPrice);
            }
            catch(Exception e){
                System.err.print(e.getMessage());
            }
        }
        
    }
    
    /**
     * Method for client to resist the command of the boss.
     */
    public void resistCommand(){
        this.speak("Give me more!");
        Bar.boss.exclude(this);
    }
    
    /**
     * Method to receive details of client and return an instance of the client created with the details.
     * @return 
     */
    public static Client create(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the details of the Client: ");
        System.out.println("Name: ");
        String name = input.nextLine();
        System.out.println("Nickname: ");
        String nickName = input.nextLine();
        System.out.println("Meaningful Cry: ");
        String meaningfulCry  = input.nextLine();
        System.out.println("Favourite Drink: ");
        BarStocks.print();
        Drink favouriteDrink  = BarStocks.drinks[input.nextInt()-1];
        System.out.println("Backup Drink: ");
        BarStocks.print();
        Drink backupDrink  = BarStocks.drinks[input.nextInt()-1];
        return new Client(name, nickName, meaningfulCry, favouriteDrink, backupDrink);
//        user.options();
    }
    
    
}
