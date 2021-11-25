package barmanagement;
import belote.Game;
import belote.Player;
import belote.Team;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *This class represents the bartender in the bar.
 * @author William Kofi Danso DARKWA
 */
public class Bartender extends Human implements StartGame {
    Scanner input = new Scanner(System.in);
    String userInput;
    int i = 0;
    int j = 1;
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<String> teamPlayer = new ArrayList<>();
    
    Bartender(String firstName, String nickName, String meaningfulCry){
        super(firstName, nickName, meaningfulCry);
    }
    /**
     * Allows the bartender to receive a drink offer.
     * @param drink
     * @return 
     */
    @Override
    public boolean receiveDrinkOffer(Drink drink){
        if(drink.alcoholState){
         this.speak("I am sorry. I cannot accept alcoholic drinks.");
         return false;
        }
        else{
            this.speak("Yes please, thank you!");
            return true;
        }
    }
    
    /**
     * Allows the bartender to take a drink.
     * @param drink 
     */
    @Override
    public void drink(Drink drink) {
        System.out.println("*"+this.firstName+" is getting a " + drink.name + "*");
        this.speak("*Takes a sip of " + drink.name +"*");
    }
    
    /**
     * Allows the bartender to offer a drink.
     * @param human
     * @param drink 
     */
    @Override
    public void offerDrink(Human human, Drink drink) {
        try{
            if(this.wallet >= drink.sellingPrice && human.getPopularityRating() >  10){
                System.out.println(human.firstName + ", would you like some "+ drink.name + " ?");
                if(human.receiveDrinkOffer(drink)){
//                    this.pay(drink.sellingPrice, Bar.);
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
    
    /**
     * Allows the bartender to receive money.
     * @param amount 
     */
    @Override
    public void receiveMoney(int amount){
        System.out.println("*BarTender receives " + amount + " *");
        Fund.setAmount(amount);
    }
    
    /**
     * This is the reaction of the bartender when a client offers a round of drinks.
     */
    public void reactiontoRoundOfDrinks(){
        this.speak("General round!");
    }
    
    /**
     * Allows the bartender give cash to boss when it is too much in the register.
     */
    public void returnLiquidity(){
        Bar.boss.receiveMoney(Fund.amount);
        Fund.amount = 0;
    }
    
    /**
     * Returns the teams for the Belote game.
     * @return 
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }
    
    /**
     * Starts the Belote Game.
     */
    @Override
    public void startGame() {
        while (true) {
            //TOURNAMENT MENU
            System.out.println("-------------------------Welcome to the Tournament !-------------------------");
            System.out.println("Please select an option");
            System.out.println("1. Register a team\n2. View teams\n3. Play game\n0. Exit game");
            System.out.print("---> ");
            userInput = input.next();
            if (userInput.equals("0")) {
                System.out.println("Are you sure you want to game? Type 'yes' or 'no'.");
                System.out.print("---> ");
                if (input.next().equals("yes")) {
                    break;
                } else {
                    continue;
                }
            } else if (!userInput.equals("0") && !userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3")) {
                System.out.println("Press any key to continue");
                System.out.print("---> ");
                userInput = input.next();
                continue;
            }
            switch (userInput) {
                case "1":
                    //REGISTER PLAYERS
                    System.out.println("Enter your name of Team mate 1: ");
                    System.out.print("---> ");

                    teams.add(i, new Team(input.next(), "", 0, false, j));
                    i++;
                    System.out.println("Enter your name of Team mate 2: ");
                    System.out.print("---> ");
                    teams.add(i, new Team(input.next(), "", 0, false, j));
                    i++;
                    System.out.println("You have been Registered" + j);
                    System.out.println("Returning back to menu");
                    j++;
                    break;
                case "2":
                    while (true) {
                        System.out.println("Displaying all teams");
                        int numberOfTeams = teams.size() / 2;
                        for (int j = 1; j < numberOfTeams + 1; j++) {
                            System.out.println("Team " + j);
                            for (Team team : teams) {
                                if (team.teamNumber == j) {
                                    System.out.println("**" + team.getName());
                                }
                            }
                        }
                        System.out.println("Type 'main' to go back to main menu");
                        System.out.print("---> ");
                        userInput = input.next();
                        if (userInput.equals("main")) {
                            break;
                        }
                    }
                    break;
                case "3":
                    //START GAME
                    Game game = new Game();
                    Player player = new Player();
//                    Bar bar = new Bar();
                    while(player.getTeam1TotalPoints() < 1100 || player.getTeam2TotalPoints() < 1100) {
                        game.run();
                        if (player.getTeam1TotalPoints() > player.getTeam2TotalPoints()) {
                            String loser = game.getAllPlayers().get(0).getName();
                            String winner1 = game.getAllPlayers().get(1).getName();
                            String winner2 = game.getAllPlayers().get(3).getName();
//                            bar.tournamentDrink(loser, winner1);
//                            bar.tournamentDrink(loser, winner2);
                        }
                        else{
                            String loser = game.getAllPlayers().get(1).getName();
                            String winner1 = game.getAllPlayers().get(0).getName();
                            String winner2 = game.getAllPlayers().get(2).getName();
//                            bar.tournamentDrink(loser, winner1);
//                            bar.tournamentDrink(loser, winner2);
                        }
                    }
                    break;
            }
        }
    }
}