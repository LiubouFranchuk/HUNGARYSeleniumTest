import java.util.Random;
import java.util.Scanner;

public class Helper {

    public static String readFromConsole() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.next();
    }


    public static int readNumberFromConsole() {
        return Integer.parseInt(readFromConsole());
    }


    public static int generateRandomNumber(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }
    //from 0 to max


    public static int createRandomNumber (int low, int high){
        Random r = new Random();
        int result = r.nextInt(high - low) + low;
        return result;
    }


    public static int readValidNumber(String message){
        boolean validNumber = true;
        int number = 0;

        do {
            try {
                number = Integer.parseInt(readFromConsole());
            } catch (NumberFormatException ex) {
                validNumber = false;
                System.out.println("This is not a valid Number. Please, try again.");
            }
        } while (!validNumber);

        return number;
    }


}

/*
if readFromConsole method is static in Helper package,
	we can use Helper.readFromConsole in another package;

if readFromConsole method is NON-static in Helper package,
	we need to create a new instance (H.rFC keyboard = new H.rFC) Helper.readFromConsole in another package;
 */
