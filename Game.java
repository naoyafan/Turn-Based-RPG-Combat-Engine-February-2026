
import java.util.Scanner;
/**
 * Write a description of class Game here.
 * Births the scanner and starts the rounds
 * @author (Sterling D. Fields)
 * @version (3/18/2026)
 */
public class Game {
    private Scanner scan;
    /**
     * Constructor for the game from nothing
     */
    public Game() {
        scan = new Scanner(System.in);
    }
    
    /**
     * Constructor starts game wit the scanner
     * @param s is the Scanner
     */
    public Game(Scanner s) {
        scan = s;
    }
    
    /**
     * @return the games scanner
     */
    public Scanner getScan() {
        return scan;
    }
    
    /**
     * Makes the new round
     */
    public void play() {
        Round round = new Round(scan);
        round.play();
    }
}
