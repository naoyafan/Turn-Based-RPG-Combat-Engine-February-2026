
import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class Round here.
 * The Round class is gonna give you the secret #, guesses that are made, and current games status
 * @author Sterling D. Fields
 * @version 3/18/2026
 */
public class Round
{
    //variables that are what state the round is in
    private int secret;
    private int numGuesses;
    private boolean win;
    private boolean quit;
    private Scanner scan;

    /**
     * Constructor for objects of class Round
     * @param s is Scanner from Game class
     */
    //puts the secret number to 12345 and resets the game stats
    public Round(Scanner s) {
        secret = generateSecret();
        numGuesses = 0;
        win = false;
        quit = false;
        scan = s;
    }
    
    /**
     * Generates a random 5-digit number not starting with 0 and unique numbrs
     * @return random 5-digit snumber for the round
     */
    private int generateSecret() {
        Random rand = new Random();
        int diosSecret = 0;
        boolean defUnique = false;
        
        while (!defUnique) {
            //90000 + 10000 will never result with a zero in the first digit 
            //so it won't start at 0 and adding 10000 will guarantee 5-digits
            diosSecret = rand.nextInt(90000 + 10000);
            
            if (Guess.hasUniqueDigits(diosSecret)) {
                defUnique = true;
            }
        }
        return diosSecret;
    }
    
    /**
     * Accessor methods that allow the other classes to get what is listed without being able to change them
     * @return the # player is trying to guess
     */
    public int getSecret() {
        return secret;
    }
    
    /**
     * @return the # of guesses player makes
     */
    public int getNumGuesses() {
        return numGuesses;
    }
    
    /**
     * @return win if the player guesses right
     */
    public boolean getWin() {
        return win;
    }
    
    /**
     * @return quit if the player enters -1 
     */
    public boolean getQuit() {
        return quit;
    }
    
    /**
     * @return the scanner used 
     */
    public Scanner getScan() {
        return scan;
    }
    
    /**
     * Asks the user to put in a number or quit, and increases guess counter unless player quits
     * @return integer the user puts in
     */
    private int askForGuess() {
        int g = 0;
        boolean validGuess = false;
        
        while (!validGuess) {
            System.out.print("Guess a number or enter -1 to quit: ");
            g = scan.nextInt();
            validGuess = Guess.checkGuess(g);
        }
        
        
        if (g == -1) {
            quit = true; //checks if the player opts out
        } else {
            numGuesses++; //so the guess only counts if they hadn't quit
        }
        return g;
    }
    
    /**
     * Sees if the guess matches the secret #
     * If it doesn't it prints the apples and oranges info
     * @param g is the Players guess
     */
    private void checkWin(int g) {
        if (g == secret) {
            win = true;
        
        //if snumber isn't guessed exactly, it checks for the apples & oranges
        } else if (g != -1) {
            int a = Guess.countApples(g, secret);
            int o = Guess.countOranges(g, secret);
            
            printResults(a, o);
        }
    }
    
    /**
     * Prints results on a line
     * @param apples number of correct # with position
     * @param oranges number of correct # w/o position
     */
    private void printResults(int apples, int oranges) {
        if (apples == 0 && oranges == 0){
            System.out.println("nada");
        } else {
            for (int i = 0; i < apples; i++) {
                System.out.print("apple ");
            }
            for (int i = 0; i < oranges; i++) {
                System.out.print("oranges ");
            }
        }
        System.out.println();
    }
    
    /**
     * Makes the main loop for this game
     * Will continue to ask for a guess until a win or quit
     */
    public void play() {
        //to make the loop continue if player hasn't won or quit
        while (!win && !quit) {
            int guess = askForGuess();
            System.out.println("You guessed: " + guess);
            checkWin(guess);
        }
        //once said loop is over this is what will be shown
        if (win){
            System.out.println("You won the round!");
        } else {
            System.out.println("You quit the round");
        }
        System.out.println("Number of guesses: " + numGuesses);
    }
  }
