
/**
 * Write a description of class guess here.
 *
 * @author (Sterling D. Fields)
 * @version (3/27/2026)
 */
public class Guess
{
    /**
     * Makes it so that a guess only counts if it's 5 digits or player quits.
     * @param g guess entered by player
     * @return true if guess meets criteria and false if not
     */
    public static boolean checkGuess(int g) {
        if ((g < 00000 || g > 99999) && g != -1) {
            System.out.println("Error – guess must be 5 digits");
            return false;
        }
        return true;
    }
    
    /**
     * Counts what digits are in secret number and in same position
     * @param guess 5-digit guess.
     * @param secret 5-digit secret number
     * @return number of apples (which are matches in same position)
     */
    public static int countApples(int guess, int secret) {
        int apples = 0;
        String gStr = " " + guess;
        String sStr = " " + secret;
        for(int i =0; i < 5; i++) {
            if (gStr.substring(i, i +1).equals(sStr.substring(i, i + 1))) {
                apples++;
            }
            //substring pulls single digit from guess and snumber to check for matches
            //i + 1 makes it so prrogram only grabs character at position i and not the next
    }
    return apples;
    }
    
    /**
     * Counts digits that are in secret number but not in same position
     * @param guess 5-digit guess
     * @param secret 5-digit secret number
     * @return number of oranges (which are same # not in correct position)
     */
    public static int countOranges(int guess, int secret) {
        int oranges = 0;
        String gStr = " " + guess;
        String sStr = " " + secret;
        
        for (int i = 0; i < 5; i++) {
            String gPosition = gStr.substring(i, i + 1);
            String sPosition = sStr.substring(i, i + 1);
            //if guess digit isn't the secret digit checks to see if it's anywhere else in the snumber
            if (!gPosition.equals(sPosition)) {
                if (sStr.contains(gPosition)) {
                    oranges++;
                }
            }
        }
        return oranges;
    }
        
    


}
