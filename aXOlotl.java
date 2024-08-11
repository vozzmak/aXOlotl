
public class aXOlotl {
    public static void main(String[] args) throws NumberFormatException {

        Player player1 = new Player();
        Player player2 = new Player();


        System.out.println("Hello, Players! Enter Your Names! " +
                "Remember, The First One To Enter The First One To Make A Move!");
        player1.setName();
        player1.setValue(1);
        System.out.println("OK, And Your Name, Mr. Counter-Strike?=}");
        player2.setName();
        player2.setValue(2);

        GameSession gameSession = new GameSession();
        gameSession.prepareGameBoard();

        GameController gameController = new GameController();
        gameController.prepareTheFreeFields();

        gameSession.showGameBoard();

        gameSession.startFullGameCircle(gameSession, gameController, player1, player2);

    }
}


