import java.util.Arrays;
import java.util.Scanner;

public class GameController {

    public int key1to9;
    public boolean[] freeFields;

    public void prepareTheFreeFields() {
        freeFields = new boolean[10];
        Arrays.fill(freeFields, true);
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


        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            key1to9 = Integer.parseInt(scanner.nextLine());
        }

        //scanner.close();
        return key1to9;
    }

    public void capturingThePoint(String[][] gameBoard, int key1to9, Player player) {
        switch (key1to9) {
            case 7 -> {
                gameBoard[0][0] = player.value;
                freeFields[7] = false;
            }
            case 8 -> {
                gameBoard[0][1] = player.value;
                freeFields[8] = false;
            }
            case 9 -> {
                gameBoard[0][2] = player.value;
                freeFields[9] = false;
            }
            case 4 -> {
                gameBoard[1][0] = player.value;
                freeFields[4] = false;
            }
            case 5 -> {
                gameBoard[1][1] = player.value;
                freeFields[5] = false;
            }
            case 6 -> {
                gameBoard[1][2] = player.value;
                freeFields[6] = false;
            }
            case 1 -> {
                gameBoard[2][0] = player.value;
                freeFields[1] = false;
            }
            case 2 -> {
                gameBoard[2][1] = player.value;
                freeFields[2] = false;
            }
            case 3 -> {
                gameBoard[2][2] = player.value;
                freeFields[3] = false;
            }
        }
    }
}
