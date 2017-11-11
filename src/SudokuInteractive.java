import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * A SudokuInteractive class that allows a user to read in a sudoku from file and play it interactively.
 * @author Nicholas Taylor
 * @version 2016/11/30
 */
public class SudokuInteractive extends Sudoku {
	int[][] readInArray;
	String[][] userInput;
	
	/**
	 * The constructor for SudokuInteractive
	 * @param array The sudoku array.
	 */
	public SudokuInteractive(int[][] array) {
		super(array);
		readInArray = array;
		
	}


	/**
	 * Main method which gives the play method the file path for the sudoku to be read in.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			
			play("./src/Sudoku.txt");
			
			
		} 
		catch (IllegalArgumentException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * A play method which reads a sudoku in from file and allows a user to enter input in the console.
	 * @param file The sudoku file to be read in.
	 * @return a A sudoku object.
	 * @throws IllegalArgumentException  If  sudoku file is unreachable. 
	 * @throws IOException If user input is incorrect. 
	 */
	public static SudokuInteractive play(String file) throws IllegalArgumentException, IOException  {
		
		String[][] gameBoard = {{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"},
								{"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9"},
								{"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"},
								{"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9"},
								{"e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9"},
								{"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9"},
								{"g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9"},
								{"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9"},
								{"i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9"}};
		
		String[][] userInput = {{"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
							    {"0", "0", "0", "0", "0", "0", "0", "0", "0"}};
							
		
		/**
		 * Set readInArray equal to the array read in from file.
		 * Create a new SudokuInteractive object and set that to the readInArray.
		 * Print the SudokuInteractive object using the overwritten toString in SudokuInteractive class.
		 */
		int[][] readInArray = SudokuRead.readSudoku(file).getArray();
		SudokuInteractive a = new SudokuInteractive(readInArray);
		System.out.println(a.toString());
		/**
		 * While the method isFilled from class Sudoku applied to the file read in equals false, continue to ask for user input.
		 * Two Strings are asked from the user, the location in alphanumeric form and the number they wish to enter. 
		 */
		while (Sudoku.isFilled(readInArray) == false) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("What position would you like to change?" + "\n");
			String intputString = br.readLine();
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("What number do you want to input?" + "\n");
			String inputString2 = br2.readLine();
			
			for (int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if (gameBoard[i][j].contains(intputString)) {
						readInArray[i][j] = Integer.parseInt(inputString2);
						userInput[i][j] = inputString2;
					}
				}
			}
		
		System.out.println(a.toString());
		
		}
		return a;
	
	}
	/**
	 * toString method that overrides the toString from the Sudoku class and prints it in the correct format..
	 */
	@Override
	public String toString() {
		String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
		String all ="";
		all="      1   2   3    4   5   6    7   8   9" + "\n" + "   ++===+===+===++===+===+===++===+===+===++" + "\n";
		for (int i = 0; i < 9; i++) {
			
				all= all+ letters[i] + "  |";
			
			for (int j = 0; j < 9; j++) {
				if (readInArray[i][j] != 0 && j != 2 && j != 5) {
					all = all + "|*" + readInArray[i][j] + "*";
				} else if (readInArray[i][j] == 0 ) {
					all = all + "| " + "  ";
				} 
				if (j == 2 && readInArray[i][j] != 0 || j == 5 && readInArray[i][j] != 0) {
					all = all + "|*" + readInArray[i][j] + "*|";
				} 
				if (j == 2 && readInArray[i][j] == 0 || j == 5 && readInArray[i][j] == 0) {
					all = all + "|";
				}

			}
			if (i == 0 || i == 1 || i == 3 || i == 4 || i == 6 || i == 7) {
				all = all + "||" + "\n" + "   ++---+---+---++---+---+---++---+---+---++" + "\n";
			} else if (i == 2 || i == 5 || i == 8) {
				all = all + "||" + "\n" + "   ++===+===+===++===+===+===++===+===+===++" + "\n";
			}
		}
		return all;
	}
	
}
