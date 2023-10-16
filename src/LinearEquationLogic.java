import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private LinearEquation linearEquation;
    public LinearEquationLogic() {
        linearEquation = null;
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to linear equation calculator!");
        getInfo();
        findOthers();
        printInfo();
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
    }

    private void findOthers() {
        linearEquation.riseRun();
        linearEquation.findM();
        linearEquation.findB();
        linearEquation.distance();
    }

    private void printInfo() {
        System.out.println("Your equation is: " + linearEquation.equation());
        System.out.println(linearEquation.distance());
    }
}
