import java.util.Arrays;

public class GameSession {
    private static final String[][] gameBoard = new String[3][3];

    public void startFullGameCircle(GameSession gameSession, GameController gameController,
                                    Player player1, Player player2) {

        int i;
        for (i = 0; i < 10; i++) {
            gameController.checkTheKey(gameController);
            gameController.capturingThePoint(gameBoard, gameController.getKey1to9(), player1);
            gameSession.showGameBoard();
            gameSession.checkTheWinner(player1, player2);
            gameSession.checkTheDraw();

            gameController.checkTheKey(gameController);
            gameController.capturingThePoint(gameBoard, gameController.getKey1to9(), player2);
            gameSession.showGameBoard();
            gameSession.checkTheWinner(player1, player2);
            gameSession.checkTheDraw();

        }

        if (true) {
            gameSession.startFullGameCircle(gameSession, gameController, player1, player2);
        }
    }

    public void prepareGameBoard() {
        for (String[] strings : gameBoard) {
            Arrays.fill(strings, "[$]");
        }
    }

    public void checkTheDraw() {
        boolean b = true;
        for (String[] strings : gameBoard) {
            for (String string : strings) {
                if (string.equals("[$]")) {
                    b = false;
                    break;
                }
            }
        }
        if (b) {
            System.out.println("The Draw!");
            System.exit(0);
        }
    }

    public void showGameBoard() {
        for (String[] strings : gameBoard) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public void checkTheWinner(Player player1, Player player2) {

        String[][] straightLinesWinCombos = new String[3][3];
        for (String[] straightLinesWinCombo : straightLinesWinCombos) {
            Arrays.fill(straightLinesWinCombo, " X ");
        }
        if (Arrays.deepEquals(gameBoard[0], straightLinesWinCombos[0])) {
            System.out.println(player1.getName() + " Won!");
            System.exit(0);
        }
        if (Arrays.deepEquals(gameBoard[1], straightLinesWinCombos[1])) {
            System.out.println(player1.getName() + " Won!");
            System.exit(0);
        }
        if (Arrays.deepEquals(gameBoard[2], straightLinesWinCombos[2])) {
            System.out.println(player1.getName() + " Won!");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo1 = new String[3][3];
        verticalLinesWinCombo1[0][0] = " X ";
        verticalLinesWinCombo1[1][0] = " X ";
        verticalLinesWinCombo1[2][0] = " X ";
        String[][] verticalLinesWinCombo1Mirror = new String[3][3];
        verticalLinesWinCombo1Mirror[0][0] = gameBoard[0][0];
        verticalLinesWinCombo1Mirror[1][0] = gameBoard[1][0];
        verticalLinesWinCombo1Mirror[2][0] = gameBoard[2][0];
        if (Arrays.deepEquals(verticalLinesWinCombo1, verticalLinesWinCombo1Mirror)) {
            System.out.println(player1.getName() + " Won!");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo2 = new String[3][3];
        verticalLinesWinCombo1[0][1] = " X ";
        verticalLinesWinCombo1[1][1] = " X ";
        verticalLinesWinCombo1[2][1] = " X ";
        String[][] verticalLinesWinCombo2Mirror = new String[3][3];
        verticalLinesWinCombo2Mirror[0][1] = gameBoard[0][1];
        verticalLinesWinCombo2Mirror[1][1] = gameBoard[1][1];
        verticalLinesWinCombo2Mirror[2][1] = gameBoard[2][1];
        if (Arrays.deepEquals(verticalLinesWinCombo2, verticalLinesWinCombo2Mirror)) {
            System.out.println(player1.getName() + " Won!");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo3 = new String[3][3];
        verticalLinesWinCombo1[0][2] = " X ";
        verticalLinesWinCombo1[1][2] = " X ";
        verticalLinesWinCombo1[2][2] = " X ";
        String[][] verticalLinesWinCombo3Mirror = new String[3][3];
        verticalLinesWinCombo3Mirror[0][2] = gameBoard[0][2];
        verticalLinesWinCombo3Mirror[1][2] = gameBoard[1][2];
        verticalLinesWinCombo3Mirror[2][2] = gameBoard[2][2];
        if (Arrays.deepEquals(verticalLinesWinCombo3, verticalLinesWinCombo3Mirror)) {
            System.out.println(player1.getName() + " Won!");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo1 = new String[3][3];
        diagonalLinesWinCombo1[0][0] = " X ";
        diagonalLinesWinCombo1[1][1] = " X ";
        diagonalLinesWinCombo1[2][2] = " X ";
        String[][] diagonalLinesWinCombo1Mirror = new String[3][3];
        diagonalLinesWinCombo1Mirror[0][0] = gameBoard[0][0];
        diagonalLinesWinCombo1Mirror[1][1] = gameBoard[1][1];
        diagonalLinesWinCombo1Mirror[2][2] = gameBoard[2][2];
        if (Arrays.deepEquals(diagonalLinesWinCombo1, diagonalLinesWinCombo1Mirror)) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo2 = new String[3][3];
        diagonalLinesWinCombo2[0][2] = " X ";
        diagonalLinesWinCombo2[1][1] = " X ";
        diagonalLinesWinCombo2[2][0] = " X ";
        String[][] diagonalLinesWinCombo2Mirror = new String[3][3];
        diagonalLinesWinCombo2Mirror[0][2] = gameBoard[0][2];
        diagonalLinesWinCombo2Mirror[1][1] = gameBoard[1][1];
        diagonalLinesWinCombo2Mirror[2][0] = gameBoard[2][0];
        if (Arrays.deepEquals(diagonalLinesWinCombo2, diagonalLinesWinCombo2Mirror)) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }


        String[][] horizontalLinesWinCombosO = new String[3][3];
        for (String[] strings : horizontalLinesWinCombosO) {
            Arrays.fill(strings, " O ");
        }
        if (Arrays.deepEquals(gameBoard[0], horizontalLinesWinCombosO[0])) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }
        if (Arrays.deepEquals(gameBoard[1], horizontalLinesWinCombosO[1])) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }
        if (Arrays.deepEquals(gameBoard[2], horizontalLinesWinCombosO[2])) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo1_O = new String[3][3];
        verticalLinesWinCombo1_O[0][0] = " O ";
        verticalLinesWinCombo1_O[1][0] = " O ";
        verticalLinesWinCombo1_O[2][0] = " O ";
        String[][] verticalLinesWinCombo1_O_Mirror = new String[3][3];
        verticalLinesWinCombo1_O_Mirror[0][0] = gameBoard[0][0];
        verticalLinesWinCombo1_O_Mirror[1][0] = gameBoard[1][0];
        verticalLinesWinCombo1_O_Mirror[2][0] = gameBoard[2][0];
        if (Arrays.deepEquals(verticalLinesWinCombo1_O, verticalLinesWinCombo1_O_Mirror)) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo2_O = new String[3][3];
        verticalLinesWinCombo2_O[0][1] = " O ";
        verticalLinesWinCombo2_O[1][1] = " O ";
        verticalLinesWinCombo2_O[2][1] = " O ";
        String[][] verticalLinesWinCombo2_O_Mirror = new String[3][3];
        verticalLinesWinCombo2_O_Mirror[0][1] = gameBoard[0][1];
        verticalLinesWinCombo2_O_Mirror[1][1] = gameBoard[1][1];
        verticalLinesWinCombo2_O_Mirror[2][1] = gameBoard[2][1];
        if (Arrays.deepEquals(verticalLinesWinCombo2_O, verticalLinesWinCombo2_O_Mirror)) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo3_O = new String[3][3];
        verticalLinesWinCombo3_O[0][2] = " O ";
        verticalLinesWinCombo3_O[1][2] = " O ";
        verticalLinesWinCombo3_O[2][2] = " O ";
        String[][] verticalLinesWinCombo3_O_Mirror = new String[3][3];
        verticalLinesWinCombo3_O_Mirror[0][2] = gameBoard[0][2];
        verticalLinesWinCombo3_O_Mirror[1][2] = gameBoard[1][2];
        verticalLinesWinCombo3_O_Mirror[2][2] = gameBoard[2][2];
        if (Arrays.deepEquals(verticalLinesWinCombo3_O, verticalLinesWinCombo3_O_Mirror)) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo1_O = new String[3][3];
        diagonalLinesWinCombo1_O[0][0] = " O ";
        diagonalLinesWinCombo1_O[1][1] = " O ";
        diagonalLinesWinCombo1_O[2][2] = " O ";
        String[][] diagonalLinesWinCombo1_O_Mirror = new String[3][3];
        diagonalLinesWinCombo1_O_Mirror[0][0] = gameBoard[0][0];
        diagonalLinesWinCombo1_O_Mirror[1][1] = gameBoard[1][1];
        diagonalLinesWinCombo1_O_Mirror[2][2] = gameBoard[2][2];
        if (Arrays.deepEquals(diagonalLinesWinCombo1_O, diagonalLinesWinCombo1_O_Mirror)) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo2_O = new String[3][3];
        diagonalLinesWinCombo2_O[0][2] = " O ";
        diagonalLinesWinCombo2_O[1][1] = " O ";
        diagonalLinesWinCombo2_O[2][0] = " O ";
        String[][] diagonalLinesWinCombo2_O_Mirror = new String[3][3];
        diagonalLinesWinCombo2_O_Mirror[0][2] = gameBoard[0][2];
        diagonalLinesWinCombo2_O_Mirror[1][1] = gameBoard[1][1];
        diagonalLinesWinCombo2_O_Mirror[2][0] = gameBoard[2][0];
        if (Arrays.deepEquals(diagonalLinesWinCombo2_O, diagonalLinesWinCombo2_O_Mirror)) {
            System.out.println(player2.getName() + " Won!");
            System.exit(0);
        }
    }
}
