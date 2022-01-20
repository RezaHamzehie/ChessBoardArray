package hamza;

import acm.program.ConsoleProgram;

/**
 * File: ChessBoardArray.java
 * ----------------------------
 * draws a board of chess on the screen
 */
public class ChessBoardArray extends ConsoleProgram {

    //all needed fields
    private int[][] chessBoard;

    /**
     * main entry method in the program
     *
     * @param args the passed String argument
     */
    public static void main(String[] args) {
        //initialization of the method
        new ChessBoardArray().start(args);
    }

    /**
     * the main entry method into the acm package
     */
    public void run() {
        initializeChessBoard();
        displayBoard(chessBoard);
    }

    /**
     * initializes the chess board and fills out it's values
     */
    private void initializeChessBoard() {
        //all needed locals
        char[] mainRow = new char[]{'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};
        chessBoard = new int[8][8];

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (i == 0) {
                    chessBoard[i][j] = mainRow[j];
                } else if (i == 1) {
                    chessBoard[i][j] = 'P';
                } else if (i == 6) {
                    chessBoard[i][j] = 'p';
                } else if (i == 7) {
                    chessBoard[i][j] = Character.toLowerCase(mainRow[j]);
                } else {
                    chessBoard[i][j] = '-';
                }
            }
        }
    }
    
    /**
     * displays a passed board (a matrix) twoDimensional array
     * @param board the passed board
     */
    private void displayBoard(int[][] board) {

        for (int row = 0; row < board.length; row++) {

            dashedLineDrawer(board.length);
            println();

            for (int col = 0; col < board[0].length; col++) {
                if (col == 0) {
                    print("|  ");
                }
                print( (char) board[row][col]);
                print("  |  ");
            }
            println();
        }
        dashedLineDrawer(board.length);
    }

    /**
     * draws a dashed line on the screen
     * @param length the length of the board
     */
    private void dashedLineDrawer(int length) {

        //counting dashes
        int dashCounter=0;
        for (int i = 0; i <length * 6 ; i++) {

            //putting the first plus
            if (i == 0) {
                print("+");
            }

            //putting dash or second plus
            if (dashCounter == 5) {
                print("+");
                dashCounter=0;
            } else {
                print("-");
                dashCounter++;
            }
        }
    }

}
