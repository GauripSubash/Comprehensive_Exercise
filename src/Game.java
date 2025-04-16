import java.util.*;


/**
 * Class for the Connect 4 game
 * @author Gaurinath Subash
 * @author Michael Elliott
 * @author Xander Hong
 * @author Kristian Padgett
 */
public class Game {
    
    /** The minimum rows */
    private static final int ROW_MIN = 4;
    
    /** First player */
    private Player playerOne;

    /** Second player */
    private Player playerTwo;

    /** variable for the player's turns */
    private int playerTurn;

    /** variable for the column */
    private int column;

    /** determine if they are playing */ 
    private boolean playing;

    /** determines if they are playing again*/
    private boolean playAgain;

    /**
     * Overloaded Contructor that sets the two players and variables
     * @param playerOne first player object
     * @param playerTwo second player object
     */
    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        playerTurn = 0;
        playing = true;
        playAgain = true;
    }

    /**
     * Getter method for player one
     * @return player one object
     */
    public Player getPlayerOne() {
        return playerOne;
    }

    /**
     * Getter method for player two
     * @return player two object
     */
    public Player getPlayerTwo() {
        return playerTwo;
    }

    /**
     * Getter method for the player turn
     * @return int player turn
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Getter method for the column
     * @return int column
     */
    public int getColumn() {
        return column; 
    }

    /**
     * Method for changing if they should be playing
     */
    public void playingToggle() {
        playing = !playing;
    }

    /**
     * Method for playing again toggle
     */
    public void playAgainToggle() {
        playAgain = !playAgain;
    }

    /**
     * Setter method for amount of columns
     * @param columnInput user input column
     */
    public void usePlayerInput(int columnInput) {
        this.column = columnInput;
    }

    /**
     * Method for incrementing the turn
     */
    public void incrementTurn() {
        playerTurn++;
    }

    /**
     * Method for if player one wins
     */
    public void playerOneWin() {
        playerOne.addWin();
        System.out.println("Congratulations " + playerOne.getName() 
                + " for winning the game!");
        System.out.print("Want to play again? (y/n): ");
    }
    
    /**
     * Method for if player two wins
     */
    public void playerTwoWin() {
        playerTwo.addWin();
        System.out.println("Congratulations " + playerTwo.getName() 
                + " for winning the game!");
        System.out.print("Want to play again? (y/n): ");
    }
    
    /**
     * Main method for the Connect 4 game
     * @param args command-line parameters (not used)
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nWelcome to Connect Four!");
        System.out.print("Enter Player 1 Name: ");
        String playerOneName = scnr.next();
        System.out.print("Enter Player 2 Name: ");
        String playerTwoName = scnr.next();
        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);
        Game connectFour = new Game(playerOne, playerTwo);
        System.out.print("Enter the size of the board: ");
        int rows = 0 ;
        while (scnr.hasNext()) {
            if (scnr.hasNextInt()) {
                rows = scnr.nextInt();
                if (rows < ROW_MIN) {
                    System.out.println("Invalid board size (must be greater than 3)");
                    System.out.print("Enter the size of the board: ");
                } else {
                    break;
                }
            } else {
                System.out.print("Enter the size of the board (integer): ");
                scnr.next();
            }
        }
        System.out.println();
        Board gameBoard = new Board(rows, rows);
        while (connectFour.playAgain) {
            Random rand = new Random();
            connectFour.playerTurn = rand.nextInt(2);
            char playerOneChar = ' ';
            char playerTwoChar = ' ';
            if (connectFour.playerTurn == 0) {
                System.out.println(playerOneName + 
                        " goes first. They will be 'x'. " +
                                playerTwoName + " will be 'o'.");
                playerOneChar = 'x';
                playerTwoChar = 'o';
            } else if (connectFour.playerTurn == 1) {
                System.out.println(playerTwoName + 
                            " goes first. They will be 'x'. " +
                                 "The other player will be 'o'.");
                playerTwoChar = 'x';
                playerOneChar = 'o';
            }
            gameBoard.resetBoard();
            gameBoard.printBoard();
            boolean turnValid;
            int playerChoice = 0;
            while (connectFour.playing) {
                if (connectFour.playerTurn % 2 == 0) {
                    System.out.print(playerOneName + ", select a column: ");
                    while (scnr.hasNext()) {
                        if (scnr.hasNextInt()) {
                            playerChoice = scnr.nextInt();
                            break;
                        } else {
                            System.out.print(playerOneName + ", select a column: ");
                            scnr.next();
                        }
                    }
                    turnValid = false;
                    int potentialTurn = 0;
                    while (!turnValid) {
                        potentialTurn = gameBoard.potentialElement(playerChoice - 1, playerOneChar);
                        if (potentialTurn != -1) {               
                            gameBoard.addElement(playerChoice - 1, 
                                playerOneChar);                    
                            gameBoard.printBoard();
                            connectFour.incrementTurn();
                            turnValid = true;
                        } else {
                            System.out.print(playerOneName + ", select a column: ");
                            while (scnr.hasNext()) {
                                if (scnr.hasNextInt()) {
                                    playerChoice = scnr.nextInt();
                                    break;
                                } else {
                                    System.out.print(playerOneName + ", select a column: ");
                                    scnr.next();
                                }
                            }
                        }
                    }
                    if (gameBoard.checkHorizontalWin(potentialTurn, playerOneChar)) {
                        System.out.println(playerOneName + " wins");
                        connectFour.playingToggle();
                    } else if (gameBoard.checkVerticalWin(playerOneChar)) {
                        System.out.println(playerOneName + " wins");
                        connectFour.playingToggle();
                    } else if (gameBoard.checkDiagonalRightWin(playerOneChar)) {
                        System.out.println(playerOneName + " wins");
                        connectFour.playingToggle();
                    } else if (gameBoard.checkDiagonalLeftWin(playerOneChar)) {
                        System.out.println(playerOneName + " wins");
                        connectFour.playingToggle();
                    }
                }
                else if (connectFour.playerTurn % 2 == 1) {
                    System.out.print(playerTwoName + ", select a column: ");
                    while (scnr.hasNext()) {
                        if (scnr.hasNextInt()) {
                            playerChoice = scnr.nextInt();
                            break;
                        } else {
                            System.out.print(playerTwoName + ", select a column: ");
                            scnr.next();
                        }
                    }
                    turnValid = false;
                    int potentialTurn = 0;
                    while (!turnValid) {
                        potentialTurn = gameBoard.potentialElement(playerChoice - 1, playerTwoChar);
                        if (potentialTurn != -1) {               
                            gameBoard.addElement(playerChoice - 1, 
                                playerTwoChar);                    
                            gameBoard.printBoard();
                            connectFour.incrementTurn();
                            turnValid = true;
                        } else {
                            System.out.print(playerTwoName + ", select a column: ");
                            while (scnr.hasNext()) {
                                if (scnr.hasNextInt()) {
                                    playerChoice = scnr.nextInt();
                                    break;
                                } else {
                                    System.out.print(playerTwoName + ", select a column: ");
                                    scnr.next();
                                }
                            }
                        }
                    }
                    if (gameBoard.checkHorizontalWin(potentialTurn, playerTwoChar)) {
                        System.out.println(playerTwoName + " wins");
                        connectFour.playingToggle();
                    } else if (gameBoard.checkVerticalWin(playerTwoChar)) {
                        System.out.println(playerTwoName + " wins");
                        connectFour.playingToggle();
                    } else if (gameBoard.checkDiagonalRightWin(playerTwoChar)) {
                        System.out.println(playerTwoName + " wins");
                        connectFour.playingToggle();
                    } else if (gameBoard.checkDiagonalLeftWin(playerTwoChar)) {
                        System.out.println(playerTwoName + " wins");
                        connectFour.playingToggle();
                    }
                }
            }
            System.out.println("\n\n");
            System.out.println("Thanks for playing Connect4!");
            System.out.print("Play again? (y,n): ");
            String input = scnr.next();
            if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                System.out.println("Starting over...\n");
                connectFour.playingToggle();
            } else {
                connectFour.playAgainToggle();
            }
        }
    }
}