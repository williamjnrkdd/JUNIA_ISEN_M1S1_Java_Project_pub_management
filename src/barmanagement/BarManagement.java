
package barmanagement;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Mary Denkyiwaa GYAKARI
 */
public class BarManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bar bar = new Bar();   
        System.out.println("Welcome to " + Bar.name);
        main : while(true){
            System.out.println("Please select an option:\n1.Create customer\n2.Play\n10.Exit");
            mainInput: switch(input.nextLine()){
                case "1":
                    Bar.addClient(Client.create());
                    break mainInput;
                    
                case "2":
                    role : while(true){
                        System.out.println("Choose from your characters or 0 to go back: ");
                        ArrayList<Client> clients = new ArrayList<Client>();
                        int i = 0;
                        for(Table table : Bar.tables){
                            for(int j = 0; j < table.i; j++){
                                clients.add(table.seats[j]);    
                                System.out.println(i+1+". "+table.seats[j].firstName);
                                i++;
                            }
                        }
//                        input.nextLine();
                        int userIntegerInput = input.nextInt()-1;
                        String userStringInput;
                        if(userIntegerInput >= 0 && userIntegerInput < clients.size() ){
                            Client client = clients.get(userIntegerInput);
                            play: while(true){
                                System.out.println("Please select an option:\n1. Order a drink\n2. Play Belote game\n3. Offer round of drink\n10.Back\n100. Exit");
                                input.nextLine();
                                playInput:switch(input.nextLine()){
                                    case "1":
                                        BarStocks.print();
                                        userIntegerInput = input.nextInt();
                                        client.order(BarStocks.drinks[userIntegerInput-1]);
                                        break playInput;

                                    case "2":
                                        Bar.bartender.startGame();
                                        break playInput;

                                    case "3":
                                        client.offerRoundOfDrinks();
                                        break playInput;
                                      
                                    case "10":
                                        break play;
                                    
                                    case "100":
                                        break main;
                                        
                                    default:
                                        break play;
                                }
                            }
                            break mainInput;
                        }
                        else if(userIntegerInput == -1){
                            break role;
                        }
                        else{
                            continue;
                        }
                    }
                    break mainInput;
                case "10":
                    break main;

            }
        }
    }
    
}
