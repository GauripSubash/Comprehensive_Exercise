import java.util.*;



public class Game {
	
	private Player playerOne;
	private Player playerTwo;
	private int playerTurn;
	private int column; 
    private boolean playing;
	private boolean playAgain;
	
	public Game(Player playerOne, Player playerTwo) {
		
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		playerTurn = 0;
        playing = true;
		playAgain = true;
		
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
	
	public void playingToggle() {
		playing = !playing;
	}
	
	public void playAgainToggle() {
		playAgain = !playAgain;
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
        
        System.out.println("\nWelcome to Connect Four!");
        System.out.print("Enter Player 1 Name: ");
        String playerOneName = scnr.next();
        System.out.print("Enter Player 2 Name: ");
        String playerTwoName = scnr.next();
        
        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);
        
        Game ConnectFour = new Game(playerOne, playerTwo);
        
        System.out.print("Enter the size of the board: ");
        int rows = 0 ;
		while (scnr.hasNext()) {
			if (scnr.hasNextInt()) {
				rows = scnr.nextInt();
				if (rows < 4) {
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
        
		while (ConnectFour.playAgain) {
			
			Random rand = new Random();
			ConnectFour.playerTurn = rand.nextInt(2);
			
			char playerOneChar = ' ';
			char playerTwoChar = ' ';
			
			if (ConnectFour.playerTurn == 0) {
				System.out.println(playerOneName + " goes first. They will be 'x'. The other player will be 'o'.");
				playerOneChar = 'x';
				playerTwoChar = 'o';
			} else if (ConnectFour.playerTurn == 1) {
				System.out.println(playerTwoName + " goes first. They will be 'x'. The other player will be 'o'.");
				playerTwoChar = 'x';
				playerOneChar = 'o';
			}
			
			gameBoard.resetBoard();
			gameBoard.printBoard();
			
			boolean turnValid;
			int playerChoice = 0;
			while (ConnectFour.playing) {
				
				if (ConnectFour.playerTurn % 2 == 0) {
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
					
					while(!turnValid){
						potentialTurn = gameBoard.potentialElement(playerChoice-1, playerOneChar);
						if (potentialTurn != -1){               
							gameBoard.addElement(playerChoice-1, playerOneChar);                    
							gameBoard.printBoard();
							ConnectFour.incrementTurn();
							turnValid = true;
						} else {
							//System.out.println("Column is full!");
							
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
						ConnectFour.playingToggle();
					} else if(gameBoard.checkVerticalWin(playerOneChar)) {
						System.out.println(playerOneName + " wins");
						ConnectFour.playingToggle();
					} else if(gameBoard.checkDiagonalRightWin(playerOneChar)) {
						System.out.println(playerOneName + " wins");
						ConnectFour.playingToggle();
					} else if(gameBoard.checkDiagonalLeftWin(playerOneChar)) {
						System.out.println(playerOneName + " wins");
						ConnectFour.playingToggle();
					}
				}
				
				else if (ConnectFour.playerTurn % 2 == 1) {
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
					
					while(!turnValid){
						potentialTurn = gameBoard.potentialElement(playerChoice-1, playerTwoChar);
						if (potentialTurn != -1){               
							gameBoard.addElement(playerChoice-1, playerTwoChar);                    
							gameBoard.printBoard();
							ConnectFour.incrementTurn();
							turnValid = true;
						} else {
							//System.out.println("Column is full!");
							
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
						ConnectFour.playingToggle();
					} else if(gameBoard.checkVerticalWin(playerTwoChar)) {
						System.out.println(playerTwoName + " wins");
						ConnectFour.playingToggle();
					} else if(gameBoard.checkDiagonalRightWin(playerTwoChar)) {
						System.out.println(playerTwoName + " wins");
						ConnectFour.playingToggle();
					} else if(gameBoard.checkDiagonalLeftWin(playerTwoChar)) {
						System.out.println(playerTwoName + " wins");
						ConnectFour.playingToggle();
					}
				}
			}
			
			System.out.println("\n\n");
			System.out.println("Thanks for playing Connect4!");
			System.out.print("Play again? (y,n): ");
			String input = scnr.next();
			if(input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
				System.out.println("Starting over...\n");
				ConnectFour.playingToggle();
			} else {
				ConnectFour.playAgainToggle();
			}
		}
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