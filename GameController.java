import java.util.Arrays;
import java.util.Scanner;

public class GameController {

    private int key1to9;
    private boolean[] freeFields;

    private final static Scanner scanner = new Scanner(System.in);


    public void prepareTheFreeFields() {
        setFreeFields(new boolean[10]);
        Arrays.fill(getFreeFields(), true);
    }

    public void checkTheKey(GameController gameController) {
        key1to9 = readInput();
        if (key1to9 > 9 || key1to9 <= 0) {
            System.out.println("Press a number from 1 to 9");
            gameController.readInput();
        }
        if (!freeFields[key1to9]) {
            System.out.println("Choose the free point");
            gameController.readInput();
        }
    }

    public int readInput() {
        int key1to9 = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                key1to9 = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Press a number from 1 to 9");
            }
        }

        return key1to9;
    }


    public void capturingThePoint(String[][] gameBoard, int key1to9, Player player) {
        switch (key1to9) {
            case 7 -> {
                gameBoard[0][0] = player.getValue();
                getFreeFields()[7] = false;
            }
            case 8 -> {
                gameBoard[0][1] = player.getValue();
                getFreeFields()[8] = false;
            }
            case 9 -> {
                gameBoard[0][2] = player.getValue();
                getFreeFields()[9] = false;
            }
            case 4 -> {
                gameBoard[1][0] = player.getValue();
                getFreeFields()[4] = false;
            }
            case 5 -> {
                gameBoard[1][1] = player.getValue();
                getFreeFields()[5] = false;
            }
            case 6 -> {
                gameBoard[1][2] = player.getValue();
                getFreeFields()[6] = false;
            }
            case 1 -> {
                gameBoard[2][0] = player.getValue();
                getFreeFields()[1] = false;
            }
            case 2 -> {
                gameBoard[2][1] = player.getValue();
                getFreeFields()[2] = false;
            }
            case 3 -> {
                gameBoard[2][2] = player.getValue();
                getFreeFields()[3] = false;
            }
        }
    }

    public int getKey1to9() {
        return key1to9;
    }

    public void setKey1to9(int key1to9) {
        this.key1to9 = key1to9;
    }

    public boolean[] getFreeFields() {
        return freeFields;
    }

    public void setFreeFields(boolean[] freeFields) {
        this.freeFields = freeFields;
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
