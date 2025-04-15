import java.util.*;

public class Board {
	
    public char[][] GAME_BOARD;
	
	private char playerOneElement = 'x';
    private char playerTwoElement = 'o';
	private char currentElement;
	private int elementCount;
	private int rows;
	private int columns;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
        GAME_BOARD = new char[rows][columns];
	}
	
	public void resetBoard() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				GAME_BOARD[i][j] = '_';
			}
		}
	}
	
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
    
    public void addElement(int playersChoice, char playerChar) {
		for(int i = rows - 1; i >= 0; i--) {
			if((GAME_BOARD[i][playersChoice] != 'x') && (GAME_BOARD[i][playersChoice] != 'o')){
				GAME_BOARD[i][playersChoice] = playerChar;
                break;
			}
		}
	}    
    
    public int potentialElement(int playersChoice, char playerChar) {
        for(int i = rows - 1; i >= 0; i--) {
			if((GAME_BOARD[i][playersChoice] != 'x') && (GAME_BOARD[i][playersChoice] != 'o')){
				return i;
			}
		}
        return -1;
    }
    
    public boolean checkHorizontalWin(int row, char playerChar) {
        for (int i = 0; i < columns-3; i++) {
            for (int j = 0; j < columns; j++) {
                if((GAME_BOARD[row-1][j] == playerChar) && (GAME_BOARD[row-1][j+1] == playerChar) && (GAME_BOARD[row-1][j+2] == playerChar) && (GAME_BOARD[row-1][j+3] == playerChar)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}