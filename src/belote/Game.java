package belote;

import barmanagement.Bar;
import barmanagement.Bartender;
import barmanagement.Server;
import java.util.ArrayList;
import java.util.*;


public class Game {
    private List<Team> allPlayers;
    private final Integer distributor = 0;
    protected String trumpDisplay;
    protected static String trumpColorDisplay;
    static Scanner input = new Scanner(System.in);
    static int userInput;
    static int turns;


    public Card cardPlaying = null;
    private Card displayCard = null;
    public Integer numberCardPlayer = 0;
    Bartender bartender = Bar.bartender;
    Player player = new Player();
    public Game() {

    }

    public void addPlayers(List<Team> allPlayers) {
        this.allPlayers = allPlayers;
        numberCardPlayer = allPlayers.get(0).getCards().size();
        System.out.println("numCardPlayer " + numberCardPlayer);
    }

    public void displayCard(Card card) {
        displayCard = card;
        System.out.println("Potential Trump Card " + card.getCard());

    }

    public String getTrumpColorDisplay() {
        return trumpColorDisplay;
    }
    public List<Team> getAllPlayers(){
        return allPlayers;
    }

    public void run() {
        // Prepare lists
        allPlayers = new ArrayList<>();
        List<Team> randomPlayers = new ArrayList<>();




        // ORGANISE PLAYERS
        allPlayers.addAll(bartender.getTeams());

        if (allPlayers.size() < 4 && allPlayers.size() > 1) {
            // Register 2 waiters
            int j = 2;
            Server waiter = new Server("Jean", "", "");
            randomPlayers.add(new Team("Kevin", "", 0, false, j));
            randomPlayers.add(new Team("Lucie", "", 0, false, j));
            // Add players
            allPlayers.addAll(randomPlayers);
        }

        if (allPlayers.size() < 2) {
            int j = 1;
            randomPlayers.add(new Team("Kevei", "", 0, false, j));
            randomPlayers.add(new Team("Lucie", "", 0, false, j));
            j++;
            randomPlayers.add(new Team("Max", "", 0, false, j));
            randomPlayers.add(new Team("Julliette", "", 0, false, j));
            // Add players
            allPlayers.addAll(randomPlayers);
        }


        // CALL MIXING AND CUTTING
        CardPackage cards = new CardPackage();
        cards.mixing();
        cards.cut();

        int take = -1;
        while (take < 0) {
            // Give 3 cards next distributor
            int n = distributor;
            for (int i = 0; i < 4; i++) {
                n++;
                if (n > 3) n = 0;
                cards.distribute(allPlayers.get(n), 3);

            }

            // Give 2 cards next distributor
            n = distributor;
            for (int i = 0; i < 4; i++) {
                n++;
                if (n > 3) n = 0;
                cards.distribute(allPlayers.get(n), 2);
                ;
            }

            // Print players and cards
            addPlayers(allPlayers);
            for (Player play : allPlayers) {
                System.out.println("PLAYER " + play.getName());
                play.displayCards();
            }
            // Display Potential Trump Card
            Card displayCard = cards.display();
            displayCard(displayCard);


            // Ask for trump first round
            boolean taker = false;
            n = distributor;
            int nPlayer = 0;
            Color trump;
            while (!taker && nPlayer < 4) {
                n++;
                if (n > 3) n = 0;
                taker = allPlayers.get(n).firstRound(n, displayCard);
                if (taker) {
                    take = n;
                    trump = displayCard.getColor();
                    trumpDisplay = displayCard.getCard();
                    trumpColorDisplay = displayCard.getColor().getName();
                    System.out.println(("Your trump card is " + trumpDisplay));
                }
                nPlayer++;
            }

            if (!taker) {
                // Ask for trump second round
                n = distributor;
                nPlayer = 0;
                while (!taker && nPlayer < 4) {
                    n++;
                    if (n > 3) n = 0;
                    Color color = allPlayers.get(n).secondRound(n, displayCard);
                    if (color.getName() != "2") {
                        taker = true;
                        take = n;
                        trump = color;
                        trumpDisplay = displayCard.getCard();
                        this.trumpColorDisplay = displayCard.getColor().getName();
                        System.out.println(("Your trump card is" + trumpDisplay));
                    }
                    nPlayer++;
                }
            }

            if (!taker) {
                // Put all cards in package
                for (int i = 0; i < 4; i++) {
                    cards.getCards().addAll(allPlayers.get(i).getCards());
                    allPlayers.get(i).getCards().clear();
                }
                cards.getCards().add(displayCard);
            } else {
                // Oh ! We can play
                System.out.println(allPlayers.get(take).getName() + " takes the Trump card:  " + trumpDisplay + " Game On!!!");
                allPlayers.get(take).getCards().add(displayCard);

                // Give 2 cards next distributor
                n = distributor;
                for (int i = 0; i < 4; i++) {
                    n++;
                    if (n > 3) n = 0;
                    if (allPlayers.get(take) == allPlayers.get(n)) {
                        cards.distribute(allPlayers.get(n), 2);
                    } else {
                        cards.distribute(allPlayers.get(n), 3);
                    }
                }
                for (Player play : allPlayers) {
                    System.out.println("PLAYER " + play.getName());
                    System.out.println("Final Cards");
                    play.displayCards();
                }
            }
            displayCard = null;

            this.turns = 8;
            while (turns > 0) {
                if (turns == 8) {
                    System.out.println("Please choose the card you want to start with ");
                } else if (turns < 8 && turns != 0) {
                    System.out.println("Please choose a card  ");
                } else {
                    System.out.println("View your score or exit  ");
                }
                for (Player play : allPlayers) {
                    if (play.getName().contains(allPlayers.get(0).getName())) {
                        System.out.println("PLAYER " + play.getName());
                        System.out.println("Cards");
                        play.cardsSelection();
                        System.out.println("0. Exit Game");
                        System.out.print("---> ");
                        userInput = input.nextInt();
                    }
                }
                if (userInput == 0) {
                    System.out.println("Are you sure you want to leave? Type 'yes' or 'no'.");
                    System.out.print("---> ");
                    if (input.next().equals("yes")) {
                        break;
                    } else {
                        continue;
                    }
                }

                for (Player play : allPlayers) {
                    if (play.getName().contains(allPlayers.get(0).getName())) {
                        System.out.println(userInput);
                        play.selected(userInput - 1, this);
                    }
                    if (play.getName().contains(allPlayers.get(1).getName())) {
                        System.out.println("PLAYER " + play.getName());
                        play.strategy(this);
                    }
                    if (play.getName().contains(allPlayers.get(2).getName())) {
                        System.out.println("PLAYER " + play.getName());
                        play.strategy(this);
                    }
                    if (play.getName().contains(allPlayers.get(3).getName())) {
                        System.out.println("PLAYER " + play.getName());
                        play.strategy(this);
                    }
                }
                player.checkRoundPoints(turns);
                this.turns--;
            }
        }
    }
}
