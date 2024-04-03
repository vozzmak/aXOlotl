import java.util.*;

public class aXOlotl {
    public static void main(String[] args) {

        String[][] gameBoard = new String[3][3];
        int moveCounter = 1;

        prepareGameBoard(gameBoard);
        showGameBoard(gameBoard);
        int key1to9 = readInput();
        checkTheKey(key1to9);
        capturingThePoint(gameBoard, key1to9, moveCounter);
        //key1to9 = readInput();
        checkTheKey(key1to9);
        capturingThePoint(gameBoard, key1to9, moveCounter);
        showGameBoard(gameBoard);







    }

    public static int readInput() {
        int n = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();

        return n;
    }

    public static void checkTheKey(int key1to9) {
        if (key1to9 > 9 || key1to9 <= 0) {
            System.out.println("Press a number from 1 to 9");
            System.exit(0);
        }
    }

    public static void prepareGameBoard(String[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = "[$]";
            }
        }
    }

    public static void showGameBoard(String[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void capturingThePoint(String[][] gameBoard, int key1to9, int moveCounter) {
        switch(key1to9) {
            case 1:
                gameBoard[0][0] = String.valueOf(1);
                break;
            case 2:
                gameBoard[0][1] = String.valueOf(2);
                break;
            case 3:
                gameBoard[0][2] = String.valueOf(3);
                break;
            case 4:
                gameBoard[1][0] = String.valueOf(4);
                break;
            case 5:
                gameBoard[1][1] = String.valueOf(5);
                break;
            case 6:
                gameBoard[1][2] = String.valueOf(6);
                break;
            case 7:
                gameBoard[2][0] = String.valueOf(7);
                break;
            case 8:
                gameBoard[2][1] = String.valueOf(8);
                break;
            case 9:
                gameBoard[2][2] = String.valueOf(9);
                break;
        }

        if (key1to9 == 1 && moveCounter % 2 != 0) {
            gameBoard[0][0] = " X ";
            moveCounter++;
        } else if (key1to9 ==1 && moveCounter % 2 ==0) {
            gameBoard[0][0] = " O ";
            moveCounter++;
        }
        if (key1to9 == 2 && moveCounter % 2 != 0) {
            gameBoard[0][1] = " X ";
            moveCounter++;
        } else if (key1to9 == 2 && moveCounter % 2 ==0) {
            gameBoard[0][1] = " O ";
            moveCounter++;
        }
        if (key1to9 == 3 && moveCounter % 2 != 0) {
            gameBoard[0][2] = " X ";
            moveCounter++;
        } else if (key1to9 == 3 && moveCounter % 2 ==0) {
            gameBoard[0][2] = " O ";
            moveCounter++;
        }
        if (key1to9 == 4 && moveCounter % 2 != 0) {
            gameBoard[1][0] = " X ";
            moveCounter++;
        } else if (key1to9 == 4 && moveCounter % 2 ==0) {
            gameBoard[1][0] = " O ";
            moveCounter++;
        }
        if (key1to9 == 5 && moveCounter % 2 != 0) {
            gameBoard[1][1] = " X ";
            moveCounter++;
        } else if (key1to9 == 5 && moveCounter % 2 ==0) {
            gameBoard[1][1] = " O ";
            moveCounter++;
        }
        if (key1to9 == 6 && moveCounter % 2 != 0) {
            gameBoard[1][2] = " X ";
            moveCounter++;
        } else if (key1to9 == 6 && moveCounter % 2 ==0) {
            gameBoard[1][2] = " O ";
            moveCounter++;
        }
        if (key1to9 == 7 && moveCounter % 2 != 0) {
            gameBoard[2][0] = " X ";
            moveCounter++;
        } else if (key1to9 == 7 && moveCounter % 2 ==0) {
            gameBoard[2][0] = " O ";
            moveCounter++;
        }
        if (key1to9 == 8 && moveCounter % 2 != 0) {
            gameBoard[2][1] = " X ";
            moveCounter++;
        } else if (key1to9 == 8 && moveCounter % 2 ==0) {
            gameBoard[2][1] = " O ";
            moveCounter++;
        }
        if (key1to9 == 9 && moveCounter % 2 != 0) {
            gameBoard[2][2] = " X ";
            moveCounter++;
        } else if (key1to9 == 9 && moveCounter % 2 ==0) {
            gameBoard[2][2] = " O ";
            moveCounter++;
        }
    }

}


