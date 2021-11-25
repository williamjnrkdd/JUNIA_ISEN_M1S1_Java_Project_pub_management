package belote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Player {
    static Scanner input = new Scanner(System.in);
    static String userInput;
    protected String name;
    protected int position;
    protected String leadCard;
    protected static String leadCardColor;
    protected static String leadCardFigure;
    protected static String card2;
    protected static String card3;
    protected static String card4;
    protected static int cardPoint1;
    protected static int cardPoint2;
    protected static int cardPoint3;
    protected static int cardPoint4;
    protected static Color color;
    protected static Figure figure;
    protected static boolean found = false;

    protected static int team1Points;
    protected static int team2Points;
    protected static int team1TotalPoints;
    protected static int team2TotalPoints;


    protected static int temp;
    protected static int responses;
    protected static int random;
    protected static int check;


    protected List<Card> cards = new ArrayList<>();
    protected static ArrayList<String> turnCards = new ArrayList<>();
    protected static ArrayList<Integer> turnPoints = new ArrayList<>();


    public Player(String name, Integer position) {
        this.name = name;
        this.position = position;
    }
    public Player() {
        this("", 0);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Card> getCards() {
        return cards;
    }

    public  int getTeam1TotalPoints(){
        return team1TotalPoints;
    }
    public int getTeam2TotalPoints(){
        return team2TotalPoints;
    }
    public boolean firstRound(int indexPlayer, Card displayCard) {
        int response = 1;
        int points = 0;

        switch (indexPlayer) {
            case 0:
                while (true) {
                    System.out.println("Do you Accept or pass the trump Card??? ");
                    System.out.println("Enter yes or no or 10 to exit");

                    userInput = input.next();
                    if (userInput.equals("5")) {
                        System.out.println("Are you sure you want to leave? Type 'yes' or 'no'.....");
                        System.out.print("---> ");
                        if (input.next().equals("yes")) {
                            break;
                        } else {
                            continue;
                        }
                    }

                    switch (userInput) {
                        case "yes":
                            this.responses = 0;
                            return false;

                        case "no":
                            this.responses = 1;
                            return false;
                    }

                }
                response = responses;
                break;
            default:
                for (int i = 0; i < 5; i++) {
                    String trump = displayCard.getColor().getName();
                    if (trump == cards.get(i).getColor().getName()) {
                        points += cards.get(i).getFigure().getPointTrump();
                    } else {
                        points += cards.get(i).getFigure().getPoint();
                    }
                }
                if (points > 400) {
                    response = 0;
                }
                break;
        }

        if (response == 0) {
            return true;
        }

        return false;
    }

    public Color secondRound(int indexPlayer, Card displayCard) {
        int response = 4;
        Color[] trumps = {new Color("HEART"), new Color("DIAMOND"), new Color("SPADE"), new Color("CLUBS"), new Color("2")};

        switch (indexPlayer) {
            case 0:
                response = 1;
                break;
            default:
                for (int c = 0; c < 4; c++) {

                }
                break;
        }

        return trumps[response];
    }

    public void displayCards() {
        int i = 1;
        for (Card c : getCards()) {
            System.out.println("card " + i++ + " " + c.getCard());
        }
    }

    public void cardsSelection() {
        int i = 1;
        for (Card c : getCards()) {
            System.out.println(i++ + ". " + c.getCard());
        }
    }

    public void selected(int i, Game game) {
        System.out.println(40 + ". " + cards.get(i).getCard());
        this.leadCardColor = cards.get(i).getColor().getName();
        leadCardFigure = cards.get(i).getFigure().getName();
        leadCard = cards.get(i).getCard();
        if (leadCardColor == game.getTrumpColorDisplay()) {
            cardPoint1 = cards.get(i).getFigure().getPointTrump();
        } else {
            cardPoint1 = cards.get(i).getFigure().getPoint();
        }
        this.color = cards.get(i).getColor();
        this.figure = cards.get(i).getFigure();
        System.out.println("LeadCard Suit:" + ". " + leadCardColor);
        System.out.println("LeadCard :" + ". " + leadCard);
        System.out.println("Trump Suit:" + ". " + game.getTrumpColorDisplay());
        turnCards.add(leadCard);
        turnPoints.add(cardPoint1);
        getCards().remove(cards.get(i));

        for (Card c : getCards()) {
            System.out.println(i++ + ". " + c.getCard());
        }
    }


    public void strategy(Game game) {
        temp = 0;
        random = 11;
        found = false;
        this.check = 0;
        for (Card c : getCards()) {

            if (c.getCard().contains(leadCardColor) && leadCardColor != game.getTrumpColorDisplay()) {
                if (c.getFigurePoints() > temp) {
                    this.temp = c.getFigurePoints();
                    cardPoint2 = c.getFigurePoints();
                    this.card2 = c.getCard();

                }
                this.found = true;
            }
            if (c.getCard().contains(leadCardColor) && leadCardColor == game.getTrumpColorDisplay() && found == false) {
                if (c.getFigurePoints() > temp) {
                    this.temp = c.getFigureTrumpPoints();
                    cardPoint2 = c.getFigureTrumpPoints();
                    this.card2 = c.getCard();
                }
                this.found = true;
            }
            if (!c.getCard().contains(leadCardColor) && found == false) {

                if (c.getFigurePoints() < random) {
                    this.random = c.getFigurePoints();
                    cardPoint2 = c.getFigurePoints();
                    this.card2 = c.getCard();
                }
            }

        }
        getCards().remove(cards.get(0));
        turnCards.add(card2);
        turnPoints.add(cardPoint2);
        System.out.println("Customer" + ": " + card2);
    }

    public void checkRoundPoints(int turns) {
        System.out.println("  Round Cards  ");

        for (String c : turnCards) {
            System.out.println(c);
        }
        System.out.println("  Round Points  ");
        for (int i = 0; i < turnPoints.size(); i++) {
            System.out.println(turnPoints.get(i));
        }
        team1Points = turnPoints.get(0) + turnPoints.get(2);
        team2Points = turnPoints.get(1) + turnPoints.get(3);
        turnPoints.removeAll(turnPoints);
        if (team1Points > team2Points) {
            this.team2Points = 0;
        } else {
            this.team1Points = 0;
        }
        System.out.println("Team 1 points: " + team1Points);
        System.out.println("Team 2 points: " + team2Points);
        team1TotalPoints += team1Points;
        team2TotalPoints += team2Points;
        System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
        System.out.println("Team 1 total points: " + team1TotalPoints);
        System.out.println("Team 2 total points: " + team2TotalPoints);
        System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
        if (turns == 0) {
            System.out.println("final Scores ");
            if (team1TotalPoints > team2TotalPoints) {
                System.out.println("Team 1 won by : " + team1TotalPoints);
            } else {
                System.out.println("Team 2 won by : " + team2TotalPoints);
            }
        }

    }

}

