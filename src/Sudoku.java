
/**
 * A Sudoku class that prints out a 2d array of integers in the correct format and also checks if the sudoku has any empty spaces.
 * @author Nicholas Taylor
 * @version 2016/11/30
 */
public class Sudoku {
	public int[][] array;

	/**
	 * The constructor for Sudoku
	 * @param array The sudoku array.
	 */
	public Sudoku(int[][] array) {
		this.array = array;
	}
	/**
	 * The getter for array.
	 * @return The array.
	 */
	public int[][] getArray() {
		return array;
	}
	/**
	 * The is filled method which checks if the sudoku array has any zeros in it. If it does it returns false.
	 * @param array The sudoku array
	 * @return sudokuFilled The boolean which tells if the sudoku is filled or not.
	 */
	public static boolean isFilled(int[][] array) {
		boolean sudokuFilled = true;
		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {
				if (array[i][j] == 0) {
					sudokuFilled = false;
					
				} 

			}
		}
		if (sudokuFilled == false) {
		System.out.println("The sudoku is not filled in!");
		} else {
			System.out.println("The sudoku is complete!");
		}
		return sudokuFilled;

	}
	
	/**
	 * toString method for Sudoku.
	 * @param all The String that is iteratively added to to produce the sudoku in the correct format.
	 * Here a nested for loop iterates over array, and adds those numbers that are not equal to zero to the string all, and those that are are represented by a blank space.
	 */
	public String toString() {
		String all ="";
		all="\n" + "++===+===+===++===+===+===++===+===+===++" + "\n";
		for (int i = 0; i < 9; i++) {
			all= all+"|";
			for (int j = 0; j < 9; j++) {
				if (array[i][j] != 0 && j != 2 && j != 5) {
					all = all + "| " + array[i][j] + " ";
				} else if (array[i][j] == 0) {
					all = all + "| " + "  ";
				} 
				if (j == 2 && array[i][j] != 0 || j == 5 && array[i][j] != 0) {
					all = all + "| " + array[i][j] + " |";
				} 
				if (j == 2 && array[i][j] == 0 || j == 5 && array[i][j] == 0) {
					all = all + "|";
				}

			}
			if (i == 0 || i == 1 || i == 3 || i == 4 || i == 6 || i == 7) {
				all = all + "||" + "\n" + "++---+---+---++---+---+---++---+---+---++" + "\n";
			} else if (i == 2 || i == 5 || i == 8) {
				all = all + "||" + "\n" + "++===+===+===++===+===+===++===+===+===++" + "\n";
			}
		}
		return all;
	}

	/**
	 * Main method for class Sudoku.
	 * @param args
	 * Here a 2d array is declared called array, it has the same numbers as the example in exercise 1. This array is then 
	 */
	public static void main(String[] args) {
		int array [][] =  {{1, 2, 3, 4, 5, 6, 7, 8, 9},
				{4, 5, 6, 7, 8, 9, 1, 2, 3},
				{7, 8, 9, 1, 2, 3, 4, 5, 6},
				{2, 3, 4, 5, 6, 7, 8, 9, 1},
				{5, 6, 7, 8, 9, 1, 2, 3, 4},
				{8, 9, 1, 2, 3, 4, 5, 6, 7},
				{3, 4, 5, 6, 7, 8, 9, 1, 2},
				{6, 7, 8, 9, 1, 2, 3, 4, 5},
				{9, 1, 2, 3, 4, 5, 6, 7, 8}}; 
		Sudoku test2 = new Sudoku(array);
		System.out.println(test2.toString());
		System.out.print(Sudoku.isFilled(array));
		//Sudoku.isFilled(array);

	}
}
