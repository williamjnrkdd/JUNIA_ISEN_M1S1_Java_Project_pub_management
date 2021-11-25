package belote;


public class Figure {
    private String name;
    private int point;
    private int pointTrump;

    Figure(String name, int point, int pointTrump) {
        this.name = name;
        this.point = point;
        this.pointTrump = pointTrump;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPointTrump() {
        return pointTrump;
    }

    public void setPointTrump(int pointTrump) {
        this.pointTrump = pointTrump;
    }
}
