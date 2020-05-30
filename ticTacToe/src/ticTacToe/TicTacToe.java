package ticTacToe;

import java.util.Scanner;

public class TicTacToe {

/**
 * @author Vinith Yedidi
 * Program to play Tic Tac Toe using the console and numbers as inputs for
 * the individual slots.
 * Version 1.0
 */

/**
 * x and o are set as final static variables so that they can be freely used in the rest of the program.
 */
    public final static char x = 'X';
	public final static char o = 'O';
	public char[][] board;
	

	// empty constructor
	public TicTacToe() {
	}
	
	/**
	 * @param board, a 2D char array that will constitute the Tic Tac Toe board.
	 */
	
	public TicTacToe(char[][] board) {
		this.board = new char[3][3];
	}
	
	/*
	 * Positions:
	 * 
	 * 1  2  3
	 * 4  5  6
	 * 7  8  9
	 * 
	 */
	
	/**
	 * Method to make a move onto the board.
	 * @param matrix
	 * @param scanned
	 * @param letter
	 */
	
	public static void move(TicTacToe matrix, int scanned, char letter) {
		
		if (letter == x) {
			
			enterX(matrix, scanned);
			
		} else if (letter == o) {
			
			enterO(matrix, scanned);
			
		}
		
	}
	
	/**
	 * Method to see if the move can execute, or if the element in the board is filled. Uses previousArgumentDetector().
	 * @param matrix, the board.
	 * @param position, the inputted position on the board.
	 * @return returnValue, the boolean on if the move can execute.
	 */
	public static boolean seeIfMoveCanExecute(TicTacToe matrix, int position) {
		
		boolean returnValue = true;
		
		if (previousArgumentDetector(matrix, position))  {
			returnValue = false;
		}
		if (position < 1 || position > 9) {
			returnValue = false;
		}
		
		return returnValue;
		
	}	

	/**
	 * Method to see if there is a previous argument in the position on the board.
	 * @param matrix, the board.
	 * @param position, the inputted position on the board.
	 * @return returnValue, the boolean on if the move can execute.
	 */
	private static boolean previousArgumentDetector(TicTacToe matrix, int position) {
		
		boolean returnValue = false;
		
		switch (position) {
		
		case(1):
			if ((matrix.board[0][0] == x) || (matrix.board[0][0] == o)) {
				returnValue = true;
			}
			break;
		case(2):
			if ((matrix.board[0][1] == x) || (matrix.board[0][1] == o)) {
				returnValue = true;
			}
			break;
		case(3):
			if ((matrix.board[0][2] == x) || (matrix.board[0][2] == o)) {
				returnValue = true;
			}
			break;
		case(4):
			if ((matrix.board[1][0] == x) || (matrix.board[1][0] == o)) {
				returnValue = true;
			}
			break;
		case(5):
			if ((matrix.board[1][1] == x) || (matrix.board[1][1] == o)) {
				returnValue = true;
			}
			break;
		case(6):
			if ((matrix.board[1][2] == x) || (matrix.board[1][2] == o)) {
				returnValue = true;
			}
			break;
		case(7):
			if ((matrix.board[2][0] == x) || (matrix.board[2][0] == o)) {
				returnValue = true;
			}
			break;
		case(8):
			if ((matrix.board[2][1] == x) || (matrix.board[2][1] == o)) {
				returnValue = true;
			}
			break;
		case(9):
			if ((matrix.board[2][2] == x) || (matrix.board[2][2] == o)) {
				returnValue = true;
			}
			break;
		}
		
		return returnValue;
	}			
	
	/**
	 * Method to make an move for the X player.
	 * @param matrix, the board.
	 * @param position, the inputted position on the board.
	 */
	
	private static void enterX(TicTacToe matrix, int position) {
		
		switch (position) {
		
		case(1):
			matrix.board[0][0] = x;
			break;
		case(2):
			matrix.board[0][1] = x;
			break;
		case(3):
			matrix.board[0][2] = x;
			break;
		case(4):
			matrix.board[1][0] = x;
			break;
		case(5):
			matrix.board[1][1] = x;
			break;
		case(6):
			matrix.board[1][2] = x;
			break;
		case(7):
			matrix.board[2][0] = x;
			break;
		case(8):
			matrix.board[2][1] = x;
			break;
		case(9):
			matrix.board[2][2] = x;
			break;
		}
	}
		
	/**
	 * Method to make an move for the O player.
	 * @param matrix, the board.
	 * @param position, the inputted position on the board.
	 */
	
	private static void enterO(TicTacToe matrix, int position) {
		
		switch (position) {
		
		case(1):
			matrix.board[0][0] = o;
			break;
		case(2):
			matrix.board[0][1] = o;
			break;
		case(3):
			matrix.board[0][2] = o;
			break;
		case(4):
			matrix.board[1][0] = o;
			break;
		case(5):
			matrix.board[1][1] = o;
			break;
		case(6):
			matrix.board[1][2] = o;
			break;
		case(7):
			matrix.board[2][0] = o;
			break;
		case(8):
			matrix.board[2][1] = o;
			break;
		case(9):
			matrix.board[2][2] = o;
			break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param matrix, the TicTacToe object with the 2D array inside of it.
	 * @return a String with either a victory message or just the updated board
	 * 
	 * Method to make a determine if a victory was achieved. It does this by taking values from checkRowsForWin(), checkColsForWin(),
	 * and checkDiagonalsForWin(). If any of those private methods return true for X or O, it will trigger the victory message for 
	 * that player. Otherwise, it simply returns the updated board which will then be printed in the console.
	 */
	
	public static String winDetector(TicTacToe matrix) {
		 if ((checkRowsForWin(matrix) == x) || (checkColsForWin(matrix) == x) || (checkDiagonalsForWin(matrix) == x)) {
			 return matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      X has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*";
			 
		 } else if ((checkRowsForWin(matrix) == o) || (checkColsForWin(matrix) == o) || (checkDiagonalsForWin(matrix) == o)) {
			 return matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      O has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*" ;
		 } else {
			 return matrix.toString();
		 }
	}
	
	private static char checkRowsForWin(TicTacToe matrix) {
		char returnValue = ' ';
		 
			for (int row = 0; row < 3; row ++) {
				if ((matrix.board[row][0] == x) && (matrix.board[row][1] == x) && (matrix.board[row][2] == x)) {
					returnValue = x;
				} else if ((matrix.board[row][0] == o) && (matrix.board[row][1] == o) && (matrix.board[row][2] == o)) {
					returnValue = o;
				}
			}
		return returnValue;
	}
	
	private static char checkColsForWin(TicTacToe matrix) {
		char returnValue = ' ';
		 
			for (int col = 0; col < 3; col ++) {
				if ((matrix.board[0][col] == x) && (matrix.board[1][col] == x) && (matrix.board[2][col] == x)) {
					returnValue = x;
				} else if ((matrix.board[0][col] == o) && (matrix.board[1][col] == o) && (matrix.board[2][col] == o)) {
					returnValue = o;
				}
			}
		return returnValue;
	}
	
	private static char checkDiagonalsForWin(TicTacToe matrix) {
		char returnValue = ' ';
		
			if (((matrix.board[0][0] == x) && (matrix.board[1][1] == x) && (matrix.board[2][2] == x)) ||
				 (matrix.board[2][0] == x) && (matrix.board[1][1] == x) && (matrix.board[0][2] == x)) {
				returnValue = x;
			} else if (((matrix.board[0][0] == o) && (matrix.board[1][1] == o) && (matrix.board[2][2] == o)) ||
					    (matrix.board[2][0] == o) && (matrix.board[1][1] == o) && (matrix.board[0][2] == o)) {
					returnValue = o;
			}	
		return returnValue;
	
	}
	
	@Override
	/** 
	 *  @return a String that displays the board.
	 */

	public String toString() {
		
		String returnString = 
			"|  " + this.board[0][0] + "  " + this.board[0][1] + "  " + this.board[0][2] + "  |\n" +
			"\n|  " + this.board[1][0] + "  " + this.board[1][1] + "  " + this.board[1][2] + "  |\n" +
			"\n|  " + this.board[2][0] + "  " + this.board[2][1] + "  " + this.board[2][2] + "  |" ;
		
		return returnString;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Main() method: Initiates a scanner, a 2D char grid, and a TicTacToe object. Then, it starts the game by printing out the board.
	 * Then:
	 * 1. Console displays matrix
	 * 2. User inputs number of slot.
	 * 	  a. if slot is already taken, it will output "Space already taken."
	 *    b. if input is not an int from 1 - 9, it will output "Invalid input."
	 *    c. if slot is not taken, it will add the character into the slot and display the overall, up to date matrix.
	 * 3. The console will check after every input if the game was won. 
	 *    a. If the game is won, the console will output "X/O won the game!" The program will then terminate
	 *    b. If the game is not won, the console will continue accepting inputs.
	 * 4. If the game comes to a draw after 9 plays, the console will display "It's a draw!" and then the program will terminate.
	 * @throws InterruptedException 
	 * 
	 */

	public static void main(String args[])  {
		
		try (Scanner scan = new Scanner(System.in)) {
			int scanned;
			
			char[][] board = new char[3][3];
			
			TicTacToe matrix = new TicTacToe(board);
			
			System.out.println(matrix);
			
			for (int i = 0; i < 4; i ++) {
				for (int loop = 0; loop == 0;) {
					scanned = scan.nextInt();
					if (seeIfMoveCanExecute(matrix, scanned)) {
						move(matrix, scanned, x);
						System.out.println(winDetector(matrix));
						if ((winDetector(matrix).equals(matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      X has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*")) ||
							(winDetector(matrix).equals(matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      O has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*"))){
								System.exit(0);
						}
					} else {
						System.out.println("Invalid input. Please try again.");
					}
					break;
				}
				
					
				for (int loop = 0; loop == 0;) {
					scanned = scan.nextInt();
					if (seeIfMoveCanExecute(matrix, scanned)) {
						move(matrix, scanned, o);
						System.out.println(winDetector(matrix));
						if ((winDetector(matrix).equals(matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      X has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*")) ||
							(winDetector(matrix).equals(matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      O has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*"))){
								System.exit(0);
						}
					} else {
						System.out.println("Invalid input. Please try again.");
					}
					break;
				}
			}
			
			
			for (int loop = 0; loop == 0;) {
				scanned = scan.nextInt();
				if (seeIfMoveCanExecute(matrix, scanned)) {
					move(matrix, scanned, x);
					System.out.println(winDetector(matrix));
					if ((winDetector(matrix).equals(matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      X has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*")) ||
						(winDetector(matrix).equals(matrix.toString() + "\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      O has won!\n*\n*\n*\n*\n*\n*\n*\n*\n*"))){
							System.exit(0);
					}
				} else {
					System.out.println("Invalid input. Please try again.");
				}
				break;
			}
		}
		System.out.println("\n*\n*\n*\n*\n*\n*\n*\n*\n*\n*\n      It's a draw!\n*\n*\n*\n*\n*\n*\n*\n*\n*");
		System.exit(0);
		
	}
}

