import java.io.*;


/**
 * SudokuRead reads in a sudoku and prints it out in the prefered toString method inherited from class Sudoku. 
 * @author Nicholas Taylor
 * @version 2016/11/30
 */
public class SudokuRead extends Sudoku {
	/**
	 * The getter for array.
	 */
	@Override
	public int[][] getArray(){
		return array;
	}
	/**
	 * The constructor for SudokuRead
	 * @param array
	 */
	public SudokuRead(int[][] array){
		super(array);
	}



	/**
	 * The readSudoku method that reads in a sudoku from file in the from of a plain text file. It throws two exceptions which are caught and dealt with appropriately below, 
	 * IOException and IllegalArgumentException.
	 * 
	 * @param file The string for the file name of the sudoku to be read in. 
	 * @return a1 A sudoku object of type sudoku.
	 * @throws IllegalArgumentException Thrown if the sudoku contains an illegal element i.e. not a number from 1 - 9.
	 * @throws IOException Thrown if the file is unreachable or doesn't exist.
	 */
	public static Sudoku readSudoku(String file) {

		int [][] bigArray = new int [9][9];

		/**
		 * Here the file is read in via buffered reader and assigned to a String called reader. reader then has all spaces within replaced with 0s. 
		 * Afterwards a string array called readArray is initialised and reader is split by each character into each element of readArray.
		 * Finally a second for loop iterates through and changes the strings within readArray into ints and add them to a 2d int array called bigArray. 
		 * bigArray is then passed into the toString method and printed in the desired format. 
		 */
		try { 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			for(int i = 0; i < 9; i++){
				String reader = br.readLine();
				reader = reader.replaceAll(" ", "0");
				String [] readArray;
				readArray = reader.split("");
				for (int j = 0; j < 9; j++) {
					bigArray[i][j] = Integer.parseInt(readArray[j]);
				}


			}
			br.close();
		}

		catch (IOException e) {
			System.out.println("File not found");
		}
		catch (IllegalArgumentException e) {
			System.out.println("The Sudoku contains a value that is not of 1-9!");
		}


		Sudoku a1 = new Sudoku (bigArray);



		return a1;
	}
	/**
	 * main method which passes the string "./src/Sudoku.txt" to the readSudoku method. This string is the file path for finding the sudoku file to be read.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(readSudoku("./src/Sudoku.txt"));
		} 
		catch (IllegalArgumentException e) {

			e.printStackTrace();
		}

	}


}