package barmanagement;

/**
 *This class represents a server in the bar.
 * @author Mary Denkyiwaa GYAKARI
 */
public class Server extends Human {

    public Server(String firstName, String nickName,String meaningfulCry) {
        super(firstName, nickName, meaningfulCry);
    }
    
    /**
     * This method allows the server to receive money from the client and then gives it to the bartender.
     * @param amount 
     */
    @Override
    public void receiveMoney(int amount){
        System.out.println("*Server receives " + amount + " *");
        this.wallet += amount;
        try{
            this.pay(amount, Bar.bartender);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
