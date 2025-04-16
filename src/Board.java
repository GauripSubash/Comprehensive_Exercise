import java.util.*;

/**
 * Class for setting up the board
 * @author Gaurinath Subash
 * @author Michael Elliott
 * @author Xander Hong
 * @author Kristian Padgett
 */
public class Board {

	/** double char array for the board */
    public char[][] GAME_BOARD;
	
	/** Character for x */
	private char playerOneElement = 'x';

	/** Character for o */
    private char playerTwoElement = 'o';

	/** Character for the current element */
	private char currentElement;

	/** Integer for the element count */
	private int elementCount;

	/** Integer representing the rows */
	private int rows;

	/** Integer representing the columns */
	private int columns;
	
	/**
	 * Overloaded constructor that sets up the game board
	 * @param rows rows for the connect 4
	 * @param columns columns for the connect 4
	 */
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
        GAME_BOARD = new char[rows][columns];
	}

	/**
	 * Method for resetting the connect 4 board
	 */
	public void resetBoard() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				GAME_BOARD[i][j] = '_';
			}
		}
	}
	
	/**
	 * Method for printing the board
	 */
	public void printBoard() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print("|" + GAME_BOARD[i][j]);
				
			}
			System.out.println("|");
		}
        
        for (int i = 1; i < columns + 1; i++) {
            System.out.print(" " + i);
        }
		System.out.println();
	}
    
	/**
	 * Method for adding element to board
	 * @param playersChoice the players choice
	 * @param playerChar character for player
	 */
    public void addElement(int playersChoice, char playerChar) {
		for(int i = rows-1; i >= 0; i--) {
			if((GAME_BOARD[i][playersChoice] != 'x') && (GAME_BOARD[i][playersChoice] != 'o')){
				GAME_BOARD[i][playersChoice] = playerChar;
				break;
			}
		}
	}    

	/**
	 * Method for adding a potential element to board
	 * @param playersChoice the players choice 
	 * @param playerChar chracter for player
	 * @return if the column is valid, 
	 * the row where there isn't a character
	 */
    public int potentialElement(int playersChoice, char playerChar) {
        if(playersChoice < 0 || playersChoice+1 > columns) {
			System.out.println("Invalid Column!");
			return -1;
		}
		for(int i = rows-1; i >= 0; i--) {
			if((GAME_BOARD[i][playersChoice] != 'x') && (GAME_BOARD[i][playersChoice] != 'o')){
				System.out.println("row = " + i);
				return i;
			}
		}
		System.out.println("Column is full!");
        return -1;
    }

    /**
	 * Checks if there is a horizontal win
	 * @param row the row of connect 4
	 * @param playerChar the character of the player
	 * @return if there is a win
	 */
    public boolean checkHorizontalWin(int row, char playerChar) {
		for (int i = 0; i < columns-3; i++) {
			if((GAME_BOARD[row][i] == playerChar) && (GAME_BOARD[row][i+1] == playerChar) && (GAME_BOARD[row][i+2] == playerChar) && (GAME_BOARD[row][i+3] == playerChar)) {
				return true;
			}
		}
        
        return false;
    }
	
	/**
	 * Checks if there is a vertical win
	 * @param playerChar the character of the player
	 * @return if there is a win
	 */
	public boolean checkVerticalWin(char playerChar) {
		for (int i = 0; i < columns; i++) {
			for (int j = columns-1; j >= columns-5; j--) {
				if((GAME_BOARD[j][i] == playerChar) && (GAME_BOARD[j-1][i] == playerChar) && (GAME_BOARD[j-2][i] == playerChar) && (GAME_BOARD[j-3][i] == playerChar)) {
					return true;
				}
			}
		}
        
        return false;
    }
	
	/**
	 * Checks if there is a right diagonal win
	 * @param playerChar the character of the player
	 * @return if there is a win
	 */
	public boolean checkDiagonalRightWin(char playerChar) {
        for(int i = columns-1; i >= columns-5; i--) {  
			for (int j = 0; j < columns-3; j++) {
				/* System.out.println("i = " + i);
				System.out.println("j = " + j); */
                if((GAME_BOARD[i][j] == playerChar) && (GAME_BOARD[i-1][j+1] == playerChar) && (GAME_BOARD[i-2][j+2] == playerChar) && (GAME_BOARD[i-3][j+3] == playerChar)) {
                    return true;
                }
            }
		}
        return false;
    }
	
	/**
	 * Checks if there is a left diagonal win
	 * @param playerChar the character of the player
	 * @return if there is a win
	 */
	public boolean checkDiagonalLeftWin(char playerChar) {
        for(int i = columns-1; i >= columns-5; i--) {  
			for (int j = columns-1; j >= columns-5; j--) {
				/* System.out.println("i = " + i);
				System.out.println("j = " + j); */
                if((GAME_BOARD[i][j] == playerChar) && (GAME_BOARD[i-1][j-1] == playerChar) && (GAME_BOARD[i-2][j-2] == playerChar) && (GAME_BOARD[i-3][j-3] == playerChar)) {
                    return true;
                }
            }
		}
        return false;
    }
}