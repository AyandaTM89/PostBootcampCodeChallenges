// main class
public class Sudoku {
	// variables for gris size 
	public static int GridBox_SIZE = 3;
	public static int GRID_SIZE = 9;
	// main method
	public static void main(String[] args) {
		// 2d given int array grid/ board
		int[][] NumberGrid = { 
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 }
				};
		System.out.println("\nThis is the Input of the grid \n");
		printNumberGrid(NumberGrid);
		// display solution  
		if (solveBoard(NumberGrid)) {
			System.out.println("\nThis is the output of the grid  \n");
			printNumberGrid(NumberGrid);
		} else {
			System.out.println("\nNot solvable !!");
		}
	}
	// method used for printing the numbers in the number in the grid
	private static void printNumberGrid(int[][] board) {
		for (int row = 0; row < GRID_SIZE; row++) {
			if (row % 3 == 0 && row != 0) {
				System.out.println("------------");
			}
			for (int column = 0; column < GRID_SIZE; column++) {
				if (column % 3 == 0 && column != 0) {
					System.out.print("|");
				}
				System.out.print(board[row][column]);
			}
			System.out.println();
		}
	}
	// method to check if the number is in the grid board row
	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}
	// method to check if the number is in the grid board column
	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		return false;
	}
	// method to check if the number is in the small 3 by 3 boxes
	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int initialBoxRow = row - row %  GridBox_SIZE;
		int initialBoxColumn = column - column %  GridBox_SIZE;

		for (int i = initialBoxRow; i < initialBoxRow +  GridBox_SIZE; i++) {
			for (int j = initialBoxColumn; j < initialBoxColumn +  GridBox_SIZE; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}
	// checking if the number is not repeating its self in small boxes 
	private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, column)
				&& !isNumberInBox(board, number, row, column);
	}
	// nested loop to loop thru the grid box 
	private static boolean solveBoard(int[][] board) {
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int column = 0; column < GRID_SIZE; column++) {
				if (board[row][column] == 0) {
					for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
						if (isValidPlacement(board, numberToTry, row, column)) {
							board[row][column] = numberToTry;
							if (solveBoard(board)) {
								return true;
							} else {
								board[row][column] = 0;
							}
						}
					}
					return false;
				} 
			}
		}
		return true;
	}
}
/*
Refference : https://youtu.be/tvP_FZ-D9Ng
https://www.javatpoint.com/sudoku-in-java#:~:text=If%20the%20HashMap%20shows%20the,the%20grid%20as%20the%20input.&text=If%20the%20grid%20is%20safe,cases%20from%201%20to%209.
https://www.geeksforgeeks.org/sudoku-backtracking-7/
YouTube: Coding with John
*/