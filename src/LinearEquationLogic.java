import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private LinearEquation linearEquation;
    public LinearEquationLogic() {
        linearEquation = null;
        scan = new Scanner(System.in);
    }

    public void start() {
        greet();
        getInfo();
        info();
        question();
        loop();
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }

    private void greet() {
        System.out.println("Welcome to linear equation calculator!");
    }
    private void getInfo() {
        System.out.print("Enter coordinate 1: ");
        String input = scan.nextLine();
        int x1 = Integer.parseInt(input.substring(1, input.indexOf(",")));
        int y1 = Integer.parseInt(input.substring(input.indexOf(" ") + 1, input.indexOf(")")));
        System.out.print("Enter coordinate 2: ");
        input = scan.nextLine();
        int x2 = Integer.parseInt(input.substring(1, input.indexOf(",")));
        int y2 = Integer.parseInt(input.substring(input.indexOf(" ") + 1, input.indexOf(")")));
        linearEquation = new LinearEquation(x1, x2, y1, y2);
        System.out.println();
    }

    private void info() {
        linearEquation.riseRun();
        System.out.println(linearEquation.lineInfo());
        System.out.println();
    }

    private void question() {
        System.out.print("Enter any x value: ");
        double x = scan.nextDouble();
        scan.nextLine();
        if (linearEquation.exception()) {
            if (x != (double) linearEquation.getX1()) {
                System.out.println("There is no y value for that x point on this line");
            } else {
                System.out.println("There are infinitely many points for that x value on this line");
            }
        } else {
            System.out.println("The coordinate pair for that x value is: " + linearEquation.coordinateForX(x));
        }
        System.out.println();
    }

    private void loop() {
        System.out.print("Would you like to try again for a new pair of points? (y/n) ");
        String yesOrNo = scan.nextLine();
        System.out.println();
        while (yesOrNo.equals("y")) {
            getInfo();
            info();
            question();
            System.out.print("Would you like to try again for a new pair of points? (y/n) ");
            yesOrNo = scan.nextLine();
        }
        System.out.println("Thank you!");
    }
}
