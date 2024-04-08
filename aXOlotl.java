import java.util.*;

public class aXOlotl {
    public static void main(String[] args) throws NumberFormatException {

        String[][] gameBoard = new String[3][3];
        // Объявление двумерного массива, необходимого для визуализации игрового поля.
        int[] key1to9Array = new int[9];
        // Объявление массива цифр, 9, т.к. ходов и возможных позиций 9, игровые поля расположены как цифры на NumPad.
        int key1to9;
        // Создавался и массив, и отдельная переменная int, т.к. на момент реализации не придумал иного способа,
        // как переписывать значение переменной, каким был полет мысли, так и написал
        int moveCounter = 1;

        prepareGameBoard(gameBoard); // Создается двумерный массив строк, пустые игровые поля обозначаются "[$]".
        showGameBoard(gameBoard); // Игрокам показывается пустое игровое поле.

        // Здесь начинается основной цикл игры, который собирает все механики в единое целое.
        // Цикл прокручивается 9 раз в соответствии с максимальным количеством возможных ходов в игре.

        for (int i = 0; i < key1to9Array.length; i++) {
            key1to9Array[i] = readInput();// Сканер.
            key1to9 = key1to9Array[i];
            // В силу вопросов с перезаписыванием переменной использовал массив, описывал выше.
            // Собственно, ключ, цифра, которую вбиваем.
            checkTheKey(key1to9);
            // Проверка введенной цифры на допустимое значение (от 1 до 9), на данный момент
            // в случае несоответствия отображается сообщение и программа заканчивает свою работу.
            // Будет заменяться на рекурсию.
            capturingThePoint(gameBoard, key1to9, moveCounter);
            /* Здесь положение игровых полей соответсвует расположению
               цифр на телефоне (1, 2, 3 сверху) - будет исправлено в соответствии с NumPad на клавиатуре компьютера).
               Соответствующему игровому полю присвается значение в виде цифры,
               На основании этой цифры и значения счетчика(moveCounter) присвается значение Х(нечетное) или О(четное).
               В будущем механика со счетчиком модернизируется, в частности, необходимо добавить
             */
            showGameBoard(gameBoard); // После каждого хода игровое поле изменяется и демонстрируется игрокам.
            checkTheWinnerX(gameBoard); // Проверка условия победы игрока X, на данный момент - костыль.
            checkTheWinnerO(gameBoard); // Проверка условия победы игрока О, на данный момент - костыль.
            // Проблема с костылями должна будет решиться в будущем с переходом от использования массива строк к массиву
            // объектов специально прописанного класса(ов).
            moveCounter++; // Собственно, счетчик ходов.
            if (moveCounter == 10) { // Срабатывает на последнем, 9 ходу, значени равно 10, т.к. отсчет идет с 1.
                checkTheWinnerForPoints(gameBoard);
                /* Если исход игры  - ничья на 9 ходу, не возможно построить ни одну
                   выигрышную комбинацию, то происходит определение победителя по очкам,
                   то бишь, по количеству занятых клеток. Вероятно, в будущем стоит модернизировать данную механику,
                   т.к. по очкам всегда выигрывает первый походивший игрок.
                */
            }
            }
        /* Перед тем как погрузится в дебри методов, хочу отметить, что не решен вопрос с закрыванием сканера
         не закрывается вообще, но система работает(59-я строка).
         Также, не решена проблема с тем, что одно и то же поле можно переписывать все 9 ходов.
         Будет исправлено с переходом к массиву объектов. Наполнение в виду пояснений игрокам сообщениями
         и прочее оформление само собой разумеется, так же как и плотная работа с рекурсией, в том числе для того,
         чтобы была возможность начинать новую игру без перезапуска приложения.
         Из вольных мыслей - возможно, стоит добавить механику победы на скорость,
         либо усложнить этим базовые условия игры для разнообразия.
        */
    }

    public static int readInput() {
        int n = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            n = Integer.parseInt(scanner.nextLine());
        }

        //scanner.close();
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


        if (key1to9 == 1 && moveCounter % 2 != 0 )  {
            gameBoard[0][0] = " X ";
        } else if (key1to9 == 1 && moveCounter % 2 == 0 ) {
            gameBoard[0][0] = " O ";
        }
        if (key1to9 == 2 && moveCounter % 2 != 0 ) {
            gameBoard[0][1] = " X ";
        } else if (key1to9 == 2 && moveCounter % 2 == 0 ) {
            gameBoard[0][1] = " O ";

        }
        if (key1to9 == 3 && moveCounter % 2 != 0 ) {
            gameBoard[0][2] = " X ";
        } else if (key1to9 == 3 && moveCounter % 2 == 0 ) {
            gameBoard[0][2] = " O ";

        }
        if (key1to9 == 4 && moveCounter % 2 != 0 ) {
            gameBoard[1][0] = " X ";

        } else if (key1to9 == 4 && moveCounter % 2 == 0 ) {
            gameBoard[1][0] = " O ";

        }
        if (key1to9 == 5 && moveCounter % 2 != 0 ) {
            gameBoard[1][1] = " X ";

        } else if (key1to9 == 5 && moveCounter % 2 == 0 ) {
            gameBoard[1][1] = " O ";

        }
        if (key1to9 == 6 && moveCounter % 2 != 0 ) {
            gameBoard[1][2] = " X ";

        } else if (key1to9 == 6 && moveCounter % 2 == 0 ) {
            gameBoard[1][2] = " O ";

        }
        if (key1to9 == 7 && moveCounter % 2 != 0 ) {
            gameBoard[2][0] = " X ";

        } else if (key1to9 == 7 && moveCounter % 2 == 0 ) {
            gameBoard[2][0] = " O ";

        }
        if (key1to9 == 8 && moveCounter % 2 != 0 ) {
            gameBoard[2][1] = " X ";

        } else if (key1to9 == 8 && moveCounter % 2 == 0 ) {
            gameBoard[2][1] = " O ";

        }
        if (key1to9 == 9 && moveCounter % 2 != 0 ) {
            gameBoard[2][2] = " X ";

        } else if (key1to9 == 9 && moveCounter % 2 == 0 ) {
            gameBoard[2][2] = " O ";

        }
    }

    public static void checkTheWinnerX(String[][] gameBoard) {

        String[][] straightLinesWinCombos = new String[3][3];
        for (int i = 0; i < straightLinesWinCombos.length; i++){
            for (int j = 0; j < straightLinesWinCombos[i].length; j++) {
                straightLinesWinCombos[i][j] = " X ";
            }
        }
        if(Arrays.deepEquals(gameBoard[0],straightLinesWinCombos[0])){
            System.out.println("The X Player Won");
            System.exit(0);
        }
        if(Arrays.deepEquals(gameBoard[1],straightLinesWinCombos[1])){
            System.out.println("The X Player Won");
            System.exit(0);
        }
        if(Arrays.deepEquals(gameBoard[2],straightLinesWinCombos[2])){
            System.out.println("The X Player Won");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo1 = new String [3][3];
            verticalLinesWinCombo1[0][0] = " X ";
            verticalLinesWinCombo1[1][0] = " X ";
            verticalLinesWinCombo1[2][0] = " X ";
        String[][] verticalLinesWinCombo1Mirror = new String[3][3];
            verticalLinesWinCombo1Mirror[0][0] = gameBoard[0][0];
            verticalLinesWinCombo1Mirror[1][0] = gameBoard[1][0];
            verticalLinesWinCombo1Mirror[2][0] = gameBoard[2][0];
        if(Arrays.deepEquals(verticalLinesWinCombo1,verticalLinesWinCombo1Mirror)){
            System.out.println("The X Player Won");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo2 = new String [3][3];
             verticalLinesWinCombo1[0][1] = " X ";
             verticalLinesWinCombo1[1][1] = " X ";
             verticalLinesWinCombo1[2][1] = " X ";
        String[][] verticalLinesWinCombo2Mirror = new String[3][3];
             verticalLinesWinCombo2Mirror[0][1] = gameBoard[0][1];
             verticalLinesWinCombo2Mirror[1][1] = gameBoard[1][1];
             verticalLinesWinCombo2Mirror[2][1] = gameBoard[2][1];
        if(Arrays.deepEquals(verticalLinesWinCombo2,verticalLinesWinCombo2Mirror)){
            System.out.println("The X Player Won");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo3 = new String [3][3];
            verticalLinesWinCombo1[0][2] = " X ";
            verticalLinesWinCombo1[1][2] = " X ";
            verticalLinesWinCombo1[2][2] = " X ";
        String[][] verticalLinesWinCombo3Mirror = new String[3][3];
            verticalLinesWinCombo3Mirror[0][2] = gameBoard[0][2];
            verticalLinesWinCombo3Mirror[1][2] = gameBoard[1][2];
            verticalLinesWinCombo3Mirror[2][2] = gameBoard[2][2];
        if(Arrays.deepEquals(verticalLinesWinCombo3,verticalLinesWinCombo3Mirror)){
            System.out.println("The X Player Won");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo1 = new String [3][3];
            diagonalLinesWinCombo1[0][0] = " X ";
            diagonalLinesWinCombo1[1][1] = " X ";
            diagonalLinesWinCombo1[2][2] = " X ";
        String[][] diagonalLinesWinCombo1Mirror = new String[3][3];
            diagonalLinesWinCombo1Mirror[0][0] = gameBoard[0][0];
            diagonalLinesWinCombo1Mirror[1][1] = gameBoard[1][1];
            diagonalLinesWinCombo1Mirror[2][2] = gameBoard[2][2];
        if(Arrays.deepEquals(diagonalLinesWinCombo1,diagonalLinesWinCombo1Mirror)){
            System.out.println("The X Player Won");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo2 = new String [3][3];
            diagonalLinesWinCombo2[0][2] = " X ";
            diagonalLinesWinCombo2[1][1] = " X ";
            diagonalLinesWinCombo2[2][0] = " X ";
        String[][] diagonalLinesWinCombo2Mirror = new String[3][3];
            diagonalLinesWinCombo2Mirror[0][2] = gameBoard[0][2];
            diagonalLinesWinCombo2Mirror[1][1] = gameBoard[1][1];
            diagonalLinesWinCombo2Mirror[2][0] = gameBoard[2][0];
        if(Arrays.deepEquals(diagonalLinesWinCombo2,diagonalLinesWinCombo2Mirror)){
            System.out.println("The X Player Won");
            System.exit(0);
        }
    }
    public static void checkTheWinnerO(String[][] gameBoard) {

        String[][] straightLinesWinCombos = new String[3][3];
        for (int i = 0; i < straightLinesWinCombos.length; i++){
            for (int j = 0; j < straightLinesWinCombos[i].length; j++) {
                straightLinesWinCombos[i][j] = " O ";
            }
        }
        if(Arrays.deepEquals(gameBoard[0],straightLinesWinCombos[0])){
            System.out.println("The O Player Won");
            System.exit(0);
        }
        if(Arrays.deepEquals(gameBoard[1],straightLinesWinCombos[1])){
            System.out.println("The O Player Won");
            System.exit(0);
        }
        if(Arrays.deepEquals(gameBoard[2],straightLinesWinCombos[2])){
            System.out.println("The O Player Won");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo1 = new String [3][3];
            verticalLinesWinCombo1[0][0] = " O ";
            verticalLinesWinCombo1[1][0] = " O ";
            verticalLinesWinCombo1[2][0] = " O ";
        String[][] verticalLinesWinCombo1Mirror = new String[3][3];
            verticalLinesWinCombo1Mirror[0][0] = gameBoard[0][0];
            verticalLinesWinCombo1Mirror[1][0] = gameBoard[1][0];
            verticalLinesWinCombo1Mirror[2][0] = gameBoard[2][0];
        if(Arrays.deepEquals(verticalLinesWinCombo1,verticalLinesWinCombo1Mirror)){
            System.out.println("The O Player Won");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo2 = new String [3][3];
            verticalLinesWinCombo1[0][1] = " O ";
            verticalLinesWinCombo1[1][1] = " O ";
            verticalLinesWinCombo1[2][1] = " O ";
        String[][] verticalLinesWinCombo2Mirror = new String[3][3];
            verticalLinesWinCombo2Mirror[0][1] = gameBoard[0][1];
            verticalLinesWinCombo2Mirror[1][1] = gameBoard[1][1];
            verticalLinesWinCombo2Mirror[2][1] = gameBoard[2][1];
        if(Arrays.deepEquals(verticalLinesWinCombo2,verticalLinesWinCombo2Mirror)){
            System.out.println("The O Player Won");
            System.exit(0);
        }

        String[][] verticalLinesWinCombo3 = new String [3][3];
            verticalLinesWinCombo1[0][2] = " O ";
            verticalLinesWinCombo1[1][2] = " O ";
            verticalLinesWinCombo1[2][2] = " O ";
        String[][] verticalLinesWinCombo3Mirror = new String[3][3];
            verticalLinesWinCombo3Mirror[0][2] = gameBoard[0][2];
            verticalLinesWinCombo3Mirror[1][2] = gameBoard[1][2];
            verticalLinesWinCombo3Mirror[2][2] = gameBoard[2][2];
        if(Arrays.deepEquals(verticalLinesWinCombo3,verticalLinesWinCombo3Mirror)){
            System.out.println("The O Player Won");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo1 = new String [3][3];
            diagonalLinesWinCombo1[0][0] = " O ";
            diagonalLinesWinCombo1[1][1] = " O ";
            diagonalLinesWinCombo1[2][2] = " O ";
        String[][] diagonalLinesWinCombo1Mirror = new String[3][3];
            diagonalLinesWinCombo1Mirror[0][0] = gameBoard[0][0];
            diagonalLinesWinCombo1Mirror[1][1] = gameBoard[1][1];
            diagonalLinesWinCombo1Mirror[2][2] = gameBoard[2][2];
        if(Arrays.deepEquals(diagonalLinesWinCombo1,diagonalLinesWinCombo1Mirror)){
            System.out.println("The O Player Won");
            System.exit(0);
        }

        String[][] diagonalLinesWinCombo2 = new String [3][3];
            diagonalLinesWinCombo2[0][2] = " O ";
            diagonalLinesWinCombo2[1][1] = " O ";
            diagonalLinesWinCombo2[2][0] = " O ";
        String[][] diagonalLinesWinCombo2Mirror = new String[3][3];
            diagonalLinesWinCombo2Mirror[0][2] = gameBoard[0][2];
            diagonalLinesWinCombo2Mirror[1][1] = gameBoard[1][1];
            diagonalLinesWinCombo2Mirror[2][0] = gameBoard[2][0];
        if(Arrays.deepEquals(diagonalLinesWinCombo2,diagonalLinesWinCombo2Mirror)){
            System.out.println("The O Player Won");
            System.exit(0);
        }
    }

    public static void checkTheWinnerForPoints(String[][] gameBoard) {

        int pointsCounterX = 0;
        int pointsCounterO = 0;

        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == " X ") {
                    pointsCounterX++;
                } else if (gameBoard[i][j] == " O ") {
                    pointsCounterO++;
                }
            }
        }

        if (pointsCounterX > pointsCounterO) {
            System.out.println("The X PLayer Won");
        } else {
            System.out.println("The O Player Won");
        }
    }
}


