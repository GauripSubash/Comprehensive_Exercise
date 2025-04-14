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
	}
	
	void resetBoard() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				GAME_BOARD[i][j] = '_';
			}
		}
	}
	
	void printBoard() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print("|" + GAME_BOARD[i][j]);
				
			}
			System.out.println("|");
		}
		
	}
    
    void addElement(int playersChoice, char playerChar) {
		for(int i = rows; i >= 1; i--) {
			if((GAME_BOARD[i][playersChoice] != 'x') || (GAME_BOARD[i][playersChoice] != 'o')){
				GAME_BOARD[i][playersChoice] = playerChar;
				break;
			}
			
		}
	}
    
    
    
    
}