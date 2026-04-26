public class UC1_DisplayBoard {

    static char[][] board = new char[3][3];

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

    public static void main(String[] args) {
        initBoard();
        displayBoard();
    }
}