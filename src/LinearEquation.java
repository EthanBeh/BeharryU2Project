public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int rise;
    private int run;
    private double m;
    private double b;

    public LinearEquation(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void riseRun() {
        rise = y1 - y2;
        run = x1 - x2;
    }

    public void findM() {
        m = Math.round(((double) rise / run) * 100) / 100.0;
    }

    public void findB() {
        b = y1 - m * x1;
    }

    public String equation() {
        return "y = " + rise + "/" + run + "x + " + b;
    }

    public double distance() { //i think this doesn't work properly
        return ((Math.round(Math.sqrt(Math.pow(rise, 2) + Math.pow(run, 2))) / 100.0));
    }
}
