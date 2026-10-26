import java.util.ArrayList;

public class TicTacToe {
    public final char[][] board = new char[3][3];
    public final ArrayList<String> moves = new ArrayList<>();

    public TicTacToe() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------");
            }
        }
    }

    public void recordSampleMoves() {
        moves.add("X at row 0, col 0");
        moves.add("O at row 1, col 1");
        moves.add("X at row 2, col 2");

        for (String move : moves) {
            System.out.println(move);
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.printBoard();
        game.recordSampleMoves();
    }
}
