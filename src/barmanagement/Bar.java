package barmanagement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author William Kofi Danso DARKWA
 */
public class Bar {
    public static String name;
    public static Bartender bartender;
//    public static Fund fund;
    public static Boss boss;
    public static int tableNumber = -1;
    public static ArrayList<Server> servers = new ArrayList<Server>();
    public static ArrayList<Table> tables = new ArrayList<Table>();

    /**
     * Constructor for starting a bar.  
     */
    Bar(){
        Bar.tables.add(new Table());
        Scanner input = new Scanner(System.in);
        String bossName;
        System.out.println("-------------------------Welcome to the Pub Management Game !-------------------------");
        bar:while(true){
            new BarStocks();
            Bar.servers.add(new Server("Jean", "J", "Coming!"));
            Bar.servers.add(new Server("Marie", "M", "Coming!"));
            System.out.println("Enter 'yes' for default and 'no' to create your own bar: ");
            barInput: switch(input.nextLine()){
                case "no":
                    System.out.println("Enter the details of the Boss of the bar: ");
                    System.out.println("Name: ");
                    bossName = input.nextLine();
                    this.name = "Chez " + bossName;
                    System.out.println("Nickname: ");
                    String bossNickName = input.nextLine();
                    System.out.println("Meaningful Cry: ");
                    String bossMeaningfulCry  = input.nextLine();
                    System.out.println("Favourite Drink: ");
                    BarStocks.print();
                    Drink bossFavouriteDrink  = BarStocks.drinks[input.nextInt()-1];
                    System.out.println("Backup Drink: ");
                    BarStocks.print();
                    Drink bossBackupDrink  = BarStocks.drinks[input.nextInt()-1];
                    this.boss = new Boss(bossName, bossNickName, bossMeaningfulCry, bossFavouriteDrink, bossBackupDrink);
            //        this.fund = new Fund();
                    input.nextLine();
                    System.out.println("Enter the details of the Bartender of the bar: ");
                    System.out.println("First Name: ");
                    String bartenderFirstName = input.nextLine();
                    System.out.println("Nick Name: ");
                    String bartenderNickName = input.nextLine();
                    System.out.println("Meaningful Cry: ");
                    String bartenderMeaningfulCry  = input.nextLine();
                    Bar.bartender = new Bartender(bartenderFirstName, bartenderNickName, bartenderMeaningfulCry);
                    break bar;

                case "yes":
                    bossName = "Manon";
                    this.name = "Chez " + bossName;
                    this.boss = new Boss(bossName, "M", "Yasss", BarStocks.drinks[0], BarStocks.drinks[1]);
                    Bar.bartender = new Bartender("Jean", "J", "Ahuh!");
                    break bar;

                default:
                   System.out.println("Please enter 'yes' or 'no'."); 
                   break barInput;
            }
        }
    }
    
    /**
     * Methods allows to add a client to the bar.
     * @param client 
     */
    public static void addClient(Client client){
        if(Bar.tableNumber == -1 || Bar.tables.get(Bar.tableNumber).i == 4){
            Bar.tables.add(new Table());
            Bar.tableNumber++;
        }
        Bar.tables.get(Bar.tableNumber).add(client);
    }
    
    /**
     * Method returns a server from the available servers.
     * @return 
     */
    public static Server getServer() {
        Random random = new Random();
        return Bar.servers.get(random.nextInt(Bar.servers.size() - 0) + 0);
    }
}
