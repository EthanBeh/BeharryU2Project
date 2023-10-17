public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int rise;
    private int run;

    public LinearEquation(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean exception() {
        return run == 0;
    }

    public void riseRun() {
        rise = y1 - y2;
        run = x1 - x2;
    }

    public double slope() {
        if (exception()) {
            return 0.0;
        }
        return roundedToHundredth( (double) rise / run);
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }

    public String equation() {
        if (exception()) {
            return "x = " + x1;
        }
        if (slope() == 0.0) {
            return "y = " + yIntercept();
        }
        return "y = " + rise + "/" + run + "x + " + yIntercept();
    }

    public double distance() {
        double c = Math.pow(rise, 2) + Math.pow(run, 2);
        c = Math.sqrt(c);
        return roundedToHundredth(c);
    }

    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
        int intX = (int) x;
        int intY = (int) y;
        if (intX == x && intY == y) {
            return "(" + intX + ", " + intY + ")";
        } else if (intX == x) {
            return "(" + intX + ", " + y + ")";
        } else if (intY == y) {
            return "(" + x + ", " + intY + ")";
        }
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo() {
        String str =  "The two points are: " + coordinateForX(x1) + " and " + coordinateForX(x2) + "\n";
        str += "The equation of the line between these points is: " + equation() + "\n";
        if (!exception()) {
            str += "The slope of this line is: " + slope() + "\n";
        } else {
            str += "This line does not have a slope";
        }
        if (!exception()) {
            str += "The y-intercept of this line is: " + yIntercept() + "\n";
        }
        str += "The distance between these points is " + distance();
        return str;
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
