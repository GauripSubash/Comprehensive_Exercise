import java.util.*;


/**
 * Class for the player
 * @author Gaurinath Subash
 * @author Michael Elliott
 * @author Xander Hong
 * @author Kristian Padgett
 */
public class Player {
    
    /** Name of player */
    private String name;
    
    /** Amount of wins */
    private int wins;
    
    /**
     * Overloaded constructor that sets the player name
     * @param name name of the player
     */
    public Player(String name) {
        this.name = name;
        wins = 0;
    }
    
    /**
     * Overloaded constructor that sets the name and wins
     * @param name name of the player
     * @param wins wins of the player
     */
    public Player(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }
    
    /**
     * Getter method for the name
     * @return player name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter method for the wins
     * @return players wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Method for adding wins to the player
     */
    public void addWin() {
        wins++;
    }
    
    
}