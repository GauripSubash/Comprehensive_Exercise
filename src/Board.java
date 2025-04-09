import java.util.*;

public class Board {
    public int[] ROWS = {8, 12};
    public int[] COLUMNS = {8, 12};
    public char[][] GAME_BOARD;
	
	private char playerOneElement = 'x';
    private char playerTwoElement = 'o';
	private char currentElement;
	private int elementCount;
	private int rows;
	private int columns;
	
	Board setBoard(int rows, int columns) {
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
		for(int i = ROWS; i >= 7; i++) {
			if(!(Game_Board[i][playersChoice] == 'x' || 'o')){
				Game_Board[i][playersChoice] = playerChar;
				break;
			}
			
		}
	}
    
    
    
    
}