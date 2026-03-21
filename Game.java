
import java.util.Scanner;
/**
 * Write a description of class Game here.
 * Births the scanner and starts the rounds and keeping track of stats
 * @author (Sterling D. Fields)
 * @version (3/18/2026)
 */
public class Game {
    private Scanner scan;
    private int numGuesses; 
    private int numRoundsWon;
    private boolean quitGame;
    /**
     * Constructor for the game from nothing
     */
    public Game() {
        scan = new Scanner(System.in);
        numGuesses = 0; //resets the stats for these
        numRoundsWon = 0;
        quitGame = false;
    }
    
    /**
     * Constructor starts game wit the scanner
     * @param s is the Scanner
     */
    public Game(Scanner s) {
        scan = s;
        numGuesses = 0; //resets the stats as well
        numRoundsWon = 0;
        quitGame = false;
    }
    
    /**
     * @return the games scanner
     */
    public Scanner getScan() {
        return scan;
    }
    
    /**
     * @return the number of guesses after you win a round
     */
    public int getNumGuesses() {
        return numGuesses;
    }
    
    /**
     * @return total number of rounds won
     */
    public int getNumRoundsWon() {
        return numRoundsWon;
    }
    
    /**
     * @return true if the player quits
     */
    public boolean getQuitGame() {
        return quitGame;
    }
    
    /**
     * Will ask the player if the wanna go another round
     */
    private void playAgain() {
        System.out.println("You want to play again? (y/n): ");
        String answer = scan.next(); 
        scan.nextLine(); //will clear the program before another Round loop starts so no error
        
        if (answer.equals("n")) {
            quitGame = true; //if they say no(n) the game is quit
        }
    }
    
    /**
     * calculates avg number of guesses for one won round
     * @return avg guesses as a double
     */
    private double getAverage() {
        double avg = 0.0;
        if (numRoundsWon > 0) {
            avg = (double) numGuesses / numRoundsWon; //using doubles to get an exact avg
        }
        return avg;
    }
    
    /**
     * Makes the main loop and shows the final stats once a player quits
     */
    public void play() {
        while (!quitGame) { //!quitGame turns the boolean to false starting the loop
            Round round = new Round(scan); //will create a new slate for the user everytime they play again
            round.play();//is gonna let the round class run its loop
            
            if (round.getWin()) {
                numGuesses += round.getNumGuesses(); //will add guesses made in current round to ones in previous winning rounds
                numRoundsWon++; //increases the number of rounds they've won after winning
            }
            playAgain();
        }
        System.out.println("Total rounds won: " + numRoundsWon);
        System.out.println("Average number guesses for won rounds: " + getAverage());
    }
}
