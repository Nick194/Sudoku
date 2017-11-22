
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * A SudokuInteractive class that allows a user to read in a sudoku from file and play it interactively.
 * @author Nicholas Taylor
 * @version 2016/11/30
 */
public class SudokuInteractive extends Sudoku {
    public String[][] gameArray = new String[9][9];
    
    /**
     * The constructor for SudokuInteractive
     * @param array The sudoku array.
     */
    public SudokuInteractive(int[][] array) {
        super(array);
        
    }
    
    
    /**
     * Main method which gives the play method the file path for the sudoku to be read in.
     * @param args
     */
    public static void main(String[] args) {
        
        play("./src/Sudoku.txt");
        
    }
    
    /**
     * A play method which reads a sudoku in from file and allows a user to enter input in the console.
     * @param file The sudoku file to be read in.
     * @return a A sudoku object.
     * @throws IllegalArgumentException  If  sudoku file is unreachable.
     * @throws IOException If user input is incorrect.
     */
    public static void play(String file) {
        String[][] gameBoard = {{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"},
            {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9"},
            {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"},
            {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9"},
            {"e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9"},
            {"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9"},
            {"g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9"},
            {"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9"},
            {"i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9"}};
        try {
            SudokuInteractive game = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
            int[][] readArray = game.getArray();
            String[] input;
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    if(readArray[i][j] != 0){
                        game.gameArray[i][j] = "*" + Integer.toString(readArray[i][j]) + "*";
                    } else {
                        game.gameArray[i][j] = " 0 ";
                    }
                }
            }
            System.out.println(game.toString());
            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                input = br.readLine().split(":");
                
                if(input.length == 2){
                    
                    for (int i = 0; i < 9; i++){
                        for (int j = 0; j < 9; j++){
                            //                            System.out.println(gameBoard[i][j]);
                            //                            System.out.println(gameArray[i][j]);
                            if(game.gameArray[i][j] == " 0 " && gameBoard[i][j].equals(input[0])){
                                game.gameArray[i][j] = " " + input[1] +" ";
                            }
                        }
                    }
                } else if (input[0].equals("exit")){
                    System.exit(0);
                }
                
                System.out.println(game.toString());
                
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    /**
     * toString method that overrides the toString from the Sudoku class and prints it in the correct format..
     */
    @Override
    public String toString() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        String topNumbers =   "      1   2   3    4   5   6    7   8   9";
        String topAndBottom = "   ++===+===+===++===+===+===++===+===+===++";
        String middle = "   ++---+---+---++---+---+---++---+---+---++";
        String result = "";
        
        for (int i = 0; i < 9; i++) {
            if(i == 0){
                result += "\n" + topNumbers + "\n" + topAndBottom + "\n";
                result += letters[i];
            } else if (i % 3 == 0){
                result += "\n" + topAndBottom + "\n";
                result += letters[i];
            } else {
                result += "\n" + middle + "\n";
                result += letters[i];
            }
            for (int j = 0; j < 9; j++) {
                if(!gameArray[i][j].equals(" 0 ")){
                    if(j == 0){
                        result += "  ||" + gameArray[i][j] + "|";
                        
                    } else if(j % 3 == 0){
                        result += "|" + gameArray[i][j] + "|";
                        
                    } else if(j == 8){
                        result += "" + gameArray[i][j] + "||";
                        
                    } else {
                        result += "" + gameArray[i][j] + "|";
                    }
                } else {
                    if(j == 0){
                        result += "  ||" + "   " + "|";
                        
                    } else if(j % 3 == 0){
                        result += "|" + "   " + "|";
                        
                    } else if(j == 8){
                        result += "" + "   " + "||";
                        
                    } else {
                        result += "" + "   " + "|";
                    }
                }
            }
        }
        result += "\n" + topAndBottom + "\n";
        
        return result;
    }
    
}
