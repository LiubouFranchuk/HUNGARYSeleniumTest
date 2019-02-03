import java.util.Scanner;

public class Calculator {

    int currentValue = 0;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();

    }

    public void start(){
        String userResponse;

        do {
            showMenu();
            userResponse = readFromConsole();

            if (userResponse.equals("+")){
                currentValue = add(readNumberFromConsole());

            } else if (userResponse.equals("-")){
                currentValue = subtract(readNumberFromConsole());

            } else if (userResponse.equals("*")){
                currentValue = multiply(readNumberFromConsole());

            } else if (userResponse.equals("/")){
                currentValue = divide(readNumberFromConsole());

            }

        } while (!userResponse.equals("Q"));

    }

    public void showMenu(){
        System.out.println("What would you like to do? Enter: ");
        System.out.println("+ to add");
        System.out.println("- to subtruct");
        System.out.println("* to multiply");
        System.out.println("/ to divide");
        System.out.println("Q to quit");
        System.out.println("Your current value = " + currentValue);
    }

    public String readFromConsole(){
        Scanner keyboard = new Scanner(System.in);
        return keyboard.next();

    }

    public int readNumberFromConsole(){
        System.out.println("Enter a number: ");
        return Integer.parseInt(readFromConsole());

    }

    public int add(int operand){
        return currentValue + operand;
    }

    public int subtract(int operand){
        return currentValue - operand;
    }

    public int multiply(int operand){
        return currentValue * operand;
    }

    public int divide(int operand){
        return currentValue / operand;
    }





}
