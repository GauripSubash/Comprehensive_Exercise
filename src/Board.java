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
		for(int i = rows-1; i >= 0; i--) {
			if((GAME_BOARD[i][playersChoice] != 'x') && (GAME_BOARD[i][playersChoice] != 'o')){
				GAME_BOARD[i][playersChoice] = playerChar;
				break;
			}
		}
	}    
    
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
    
    public boolean checkHorizontalWin(int row, char playerChar) {
		for (int i = 0; i < columns-3; i++) {
			if((GAME_BOARD[row][i] == playerChar) && (GAME_BOARD[row][i+1] == playerChar) && (GAME_BOARD[row][i+2] == playerChar) && (GAME_BOARD[row][i+3] == playerChar)) {
				return true;
			}
		}
        
        return false;
    }
	
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