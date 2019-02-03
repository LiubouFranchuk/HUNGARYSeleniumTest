public class GuessNumber {

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();
        game.start();
    }

    private void start() {
        int createdRandomNumber;
        int guessedAlready;

        do { //this is a round of a game
            createdRandomNumber = Helper.createRandomNumber(1, 50);
            System.out.println("Guess my number..");

            do {//main loop
                guessedAlready = Helper.readNumberFromConsole();

                if (createdRandomNumber > guessedAlready) {
                    System.out.println("My number is bigger");
                } else if (createdRandomNumber < guessedAlready){
                    System.out.println("My number is smaller");
                } else {
                    System.out.println("You have guessed!");
                }
            } while (createdRandomNumber != guessedAlready); //main loop
            // OR !variable1 == variable2

        } while (playAgain());


    }

    private boolean playAgain() {
        System.out.println("Play again? Y/N");
        return Helper.readFromConsole().equals("Y");
    }


}
