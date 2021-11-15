/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barmanagement;
import java.util.Scanner;
/**
 *
 * @author Will
 */
public class Bar {
    public String name;
    public static Bartender bartender;
//    public static Fund fund;
    public static Boss boss;
    public static Table[] tables = new Table[10] ;
    
    Bar(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Pub Management");
        System.out.println("Enter the details of the Boss of the bar: ");
        System.out.println("Name: ");
        String bossName = input.nextLine();
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
        System.out.println("Enter the details of the Bartender of the bar: ");
        System.out.println("First Name: ");
        String bartenderFirstName = input.nextLine();
        System.out.println("Nick Name: ");
        String bartenderNickName = input.nextLine();
        System.out.println("Meaningful Cry: ");
        String bartenderMeaningfulCry  = input.nextLine();
        Bar.bartender = new Bartender(bartenderFirstName, bartenderNickName, bartenderMeaningfulCry);        
        
    }
}
