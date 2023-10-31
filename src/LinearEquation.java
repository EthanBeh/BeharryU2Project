public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int rise;
    private int run;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        rise = y1 - y2;
        run = x1 - x2;
    }

    public int getX1() {
        return x1;
    }

    public boolean exception() {
        return run == 0;
    }

    public double slope() {
        if (exception()) {
            return 0.0;
        }
        return roundedToHundredth((double) rise / run);
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
        String m;
        if (slope() == 1) {
            m = "";
        } else if (slope() == -1) {
            m = "-";
        } else if (slope() % 1 == 0) {
            m = Integer.toString((int) slope());
        } else if (run < 0) { //works if both rise & run r neg or only run is neg :thumbsup:
            m = -1 * rise + "/" + -1 * run;
        } else {
            m = rise + "/" + run;
        }
        if (yIntercept() == 0) {
            return ("y = " + m + "x");
        } else if (yIntercept() < 1) {
            return ("y = " + m + "x - " + Math.abs(yIntercept()));
        } else {
            return "y = " + m + "x + " + yIntercept();
        }
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
        if (intX == x && intY == y) { //getting rid of unnecessary doubles
            return "(" + intX + ", " + intY + ")";
        } else if (intX == x) {
            return "(" + intX + ", " + y + ")";
        } else if (intY == y) {
            return "(" + x + ", " + intY + ")";
        }
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo() {
        String str = "";
        str += "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        str += "The equation of the line between these points is: " + equation() + "\n";
        if (!exception()) {
            str += "The slope of this line is: " + slope() + "\n";
        } else {
            str += "This line does not have a slope\n";
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