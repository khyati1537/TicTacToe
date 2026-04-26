import java.util.Random;
import java.util.Scanner;

public class UC6_PlaceMark {

    static char[][] board = new char[3][3];
    static int currentPlayer;
    static char[] playerSymbol = new char[2];

    static void initBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    static void displayBoard() {
        System.out.println("  Tic-Tac-Toe Board");
        System.out.println("  +" + "---+".repeat(3));
        for (int i = 0; i < 3; i++) {
            System.out.print("  |");
            for (int j = 0; j < 3; j++)
                System.out.print(" " + board[i][j] + " |");
            System.out.println();
            System.out.println("  +" + "---+".repeat(3));
        }
    }

    static void performToss() {
        Random rand = new Random();
        int toss = rand.nextInt(2);
        if (toss == 0) { currentPlayer = 0; playerSymbol[0] = 'X'; playerSymbol[1] = 'O'; }
        else           { currentPlayer = 1; playerSymbol[0] = 'O'; playerSymbol[1] = 'X'; }
        System.out.println("Toss result: Player " + (currentPlayer + 1) + " goes first!");
        System.out.println("Player 1 = " + playerSymbol[0] + "  |  Computer = " + playerSymbol[1]);
    }

    static int getPlayerInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return sc.nextInt();
    }

    static int[] getRowCol(int slot) {
        return new int[] { (slot - 1) / 3, (slot - 1) % 3 };
    }

    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move: out of bounds.");
            return false;
        }
        if (board[row][col] != '-') {
            System.out.println("Invalid move: cell already taken.");
            return false;
        }
        return true;
    }

    static void placeMark(int row, int col, char symbol) {
        board[row][col] = symbol;
        System.out.println("Placed '" + symbol + "' at [" + row + "][" + col + "]");
    }

    public static void main(String[] args) {
        initBoard();
        displayBoard();
        performToss();
        int slot  = getPlayerInput();
        int[] pos = getRowCol(slot);
        if (isValidMove(pos[0], pos[1])) {
            placeMark(pos[0], pos[1], playerSymbol[currentPlayer]);
            displayBoard();
        }
    }
}
