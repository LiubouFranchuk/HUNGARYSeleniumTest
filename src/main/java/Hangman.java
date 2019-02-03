public class Hangman {

    private int numberOfLives = 6;
    private String[] arrayOfPossibleWords = {"cat", "communication", "java"};
    private String selectedWord = "";
    private String maskedWord = "";
    private String typedLetter = "";

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        hangman.start();
    }

    //add exceptions for not implemented methods which are placeholders at that point
    //throw new NotImplementedexception();

    private void start() {
        System.out.println("HANGMAN GAME");

        selectedWord = getRandomWord();
        initializeMaskedWord();

        do {
            System.out.println(maskedWord);
            System.out.println("Your current lives = " + numberOfLives);

            typedLetter = Helper.readFromConsole();

            if (isValidLetter()) {
                updateMaskedWord();
            } else {
                numberOfLives = numberOfLives - 1;
                //or numberOfLives--;
            }

        } while (numberOfLives > 0 && !selectedWord.equals(maskedWord));

        if (numberOfLives == 0) {
            System.out.println("The game is over");
        } else {
            System.out.println("Congratulations!");
        }
    }


    private void initializeMaskedWord() {
        for (int i = 0; i < selectedWord.length(); i++) {
            maskedWord += "_";
        }
    }

    private void updateMaskedWord() {
        char typedCharacter = typedLetter.charAt(0);
        char[] charArray = maskedWord.toCharArray();

        for (int i = 0; i < selectedWord.length(); i++) {

            //'a' this is a char type, "a" this is a String type
            //to compare chars we can use ==, to compare Strings we need to use .equals()

            if (selectedWord.charAt(i) == typedCharacter) {
                charArray[i] = typedCharacter;
            }
        }

        maskedWord = String.valueOf(charArray);

    }


    private boolean isValidLetter() {
        for (int i = 0; i < selectedWord.length(); i++) {
            char charAtGivenPosition = selectedWord.charAt(i);

            if (typedLetter.charAt(0) == charAtGivenPosition) {
                return true;
            }
        }
        
        return false;
    }


    private String getRandomWord() {
        int randomNumber = Helper.generateRandomNumber(arrayOfPossibleWords.length);
        return arrayOfPossibleWords[randomNumber];
    }


}
