import java.util.*;



public class Game {
	
	private Player playerOne;
	private Player playerTwo;
	private int playerTurn;
	private int column; 
	
	public Game(Player playerOne, Player playerTwo) {
		
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		playerTurn = 0;
		
	}
	
	public Player getPlayerOne() {
		return playerOne;
	}
	
	public Player getPlayerTwo() {
		return playerTwo;
	}
	
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	public int getColumn() {
		return column; 
	}
	
	public void usePlayerInput(int columnInput) {
		this.column = columnInput;
	}
	
	public void incrementTurn() {
		playerTurn++;
	}
	
	public void playerOneWin() {
		playerOne.addWin();
		System.out.println("Congratulations " + playerOne.getName() 
		+ " for winning the game!");
		System.out.print("Want to play again? (y/n): ");
	}
	
	public void playerTwoWin() {
		playerTwo.addWin();
		System.out.println("Congratulations " + playerTwo.getName() 
		+ " for winning the game!");
		System.out.print("Want to play again? (y/n): ");
	}

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Welcome to Connect Four!");
        System.out.print("Enter Player 1 Name: ");
        String playerOneName = scnr.next();
        System.out.print("Enter Player 2 Name: ");
        String playerTwoName = scnr.next();
        
        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);
        
        System.out.println("Enter the size of the board: ");
        int rows = scnr.nextInt();
        
        Board gameBoard = new Board(rows, rows);
        
        gameBoard.printBoard();
    }
	
}

	// 3|x|_|_|_|_|_|_|_|
	// 2|o|o|_|_|_|_|_|_|
	// 1|x|_|o|_|_|_|_|_|
	// 0|o|_|_|o|_|_|_|_|

// for(int i = ROWS; i >= 7; i++) {
	// if(!(Game_Board[i][playersChoice] == 'x' || 'o')){
		// Game_Board[i][playersChoice] = playerChar;
		// break;
	// }
	
// }




// int columnInput = scnr.nextInt();
	
	// while(scnr.hasNext()){
		// if(scnr.hasNextInt()){
			//getColumn = scnr.nextInt();
		// } else {
			// scnr.next();
			// System.out.println("Please input a column number 1-8.");
		// }
	// }
	
	
	// for(int i = 0; i < ROWS; i++) {
		// for(int j = 0; j < COLUMNS; j++) {
			// System.out.print("|" + GAME_BOARD[i][j]);
			
		// }
		// System.out.println("|");
	// }
	
	// for(int i = 0; i < MORE_ROWS; i++) {
		// for(int j = 0; j < MORE_COLUMNS; j++) {
			// System.out.print("|" + GAME_BOARD[i][j]);
			
		// }
		// System.out.println("|");
	// }
	
	
	
	// if(playerTurn == 0){
		// getRightDiagonal(playerOneElement);
	// }else{
		// getRightDiagonal(playerOneElement);
	// }