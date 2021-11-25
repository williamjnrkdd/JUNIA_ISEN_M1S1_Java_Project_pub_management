package belote;

public class Card {
    private Color color;
    private Figure figure;

    public Card(Color color, Figure figure) {
        this.color = color;
        this.figure = figure;
    }

    public Color getColor() {
        return color;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getFigurePoints() {
        return figure.getPoint();
    }

    public int getFigureTrumpPoints() {
        return figure.getPoint();
    }

    public String getCard() {
        return figure.getName() + " of " + color.getName();
    }

}
