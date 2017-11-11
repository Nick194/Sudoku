import java.util.*;
/**
 * A SudokuCheck class which for a given sudoku checks whether the columns rows and smaller squares all follow the rules.
 * @author Nicholas Taylor
 * @version 2016/11/30
 */
public class SudokuCheck extends Sudoku {
/**
 * The constructor for SudokuCheck
 * @param array The sudoku array.
 */
	public SudokuCheck(int[][] array) {
		super(array);
		// TODO Auto-generated constructor stub
	}


	/**
	 * The main method for SudokuCheck.
	 * @param args
	 */
	public static void main(String[] args) {
		int sudoku [][] =  {{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{4, 5, 6, 7, 8, 9, 1, 2, 3},
							{7, 8, 9, 1, 2, 3, 4, 5, 6},
							{2, 3, 4, 5, 6, 7, 8, 9, 1},
							{5, 6, 7, 8, 9, 1, 2, 3, 4},
							{8, 9, 1, 2, 3, 4, 5, 6, 7},
							{3, 4, 5, 6, 7, 8, 9, 1, 2},
							{6, 7, 8, 9, 1, 2, 3, 4, 5},
							{9, 1, 2, 3, 4, 5, 6, 7, 8}};


		Sudoku test2 = new Sudoku(sudoku);
		System.out.println(check(test2));
	
	}

	/**
	 * Method for checking the rows, columns and smaller 3x3 squares.
	 * @param sudoku The sudoku of type Sudoku that the method checks.
	 * @return result The 3x9 array of boolean values.
	 */
	public static boolean[][] check(Sudoku sudoku) {
		/**
		 * New 3x9 boolean array which is all filled with true.
		 */
		boolean[][] result = new boolean[3][9];
		java.util.Arrays.fill(result[0], true);
		java.util.Arrays.fill(result[1], true);
		java.util.Arrays.fill(result[2], true);
		int[][] newArray = sudoku.getArray();


		/**
		 * This creates a new tree set which will sort any values entered in ascending order for the rows.
		 */
		TreeSet<Integer> tsRow = new TreeSet<Integer>();

		/**
		 * This creates a new tree set which will sort any values entered in ascending order for the columns.
		 */
		TreeSet<Integer> tsColumn = new TreeSet<Integer>();

		/**
		 * This makes a temporary board for storing values from the smallers 3x3 squares and also creates an ideal list of the numbers 1 - 9 to compare the temp board to. 
		 */
		int[] tempBoard = new int[9]; 
		int[] correctList = {1,2,3,4,5,6,7,8,9};
		

		/**
		 * Two for loops which iterate through the rows adding each row to the tree set. It then checks whether the size of that tree set is less than 9,
		 * and the last value in the set is equal to 9. If the size is less than 9 (i.e. contains a value that isnt between 1 and 9) or the last value of the list is not equal to 9.
		 * The 3x9 result array will have the corresponding coordinate of the row changed to false.
		 */
		for (int i = 0; i < 9; i++) {
			tsRow.clear();
			for (int j = 0; j < 9; j++) {
				tsRow.add(newArray[i][j]);

			}
			if (tsRow.size() < 9 || tsRow.last() != 9) {
				
				result[0][i] = false;
			} 
			
			
		}
		/**
		 * Two for loops which iterate through the rows adding each column to the tree set. It then checks whether the size of that tree set is less than 9,
		 * and the last value in the set is equal to 9. If the size is less than 9 (i.e. contains a value that isnt between 1 and 9) or the last value of the list is not equal to 9.
		 * The 3x9 result array will have the corresponding coordinate of the column changed to false.
		 */
		for (int j = 0; j < 9; j++) {
			tsColumn.clear();
			for(int i = 0; i < 9; i++) {
				tsColumn.add(newArray[i][j]);
			}
			if (tsColumn.size() < 9 || tsColumn.last() != 9) {
				
				result[1][j] = false;
			} 
			
			
		}
		/**
		 * Three for loops that iterate through the sudoku array checking the 3x3 squares for incorrect values. 
		 * This also prints out result and returns result.
		 */
		int count = 0;
		
		for(int k = 0; k < 9; k++) {
		    for(int i = 0; i < 3; i++) {
		        for(int j = 0; j < 3; j++) {
		            tempBoard[count++] = newArray[i + (3 * (k / 3))][j + ((k % 3) * 3)];
		        }    
		    }
		    Arrays.sort(tempBoard);
		    for(int j = 0; j < 9; j++) {
		        if(tempBoard[j] != correctList[j]) {
		            result[2][k] = false;
		        }    
		    }
		    tempBoard = new int[9];
		    count = 0;
		}
	
		
		System.out.println(Arrays.toString(result[0]));
		System.out.println(Arrays.toString(result[1]));
		System.out.println(Arrays.toString(result[2]));
		return result;
		
	}	
		
	

}
