import java.util.Scanner;

public class Player {
    private String name;
    private String value;

    private static Scanner scanner = new Scanner(System.in);

    public Player() {

    }

    public void setName() {
        this.setName(readInput());
        System.out.println("Hello, " + this.getName());

    }

    public void setValue(int choose) {

        if (choose == 1) {
            this.setValue(" X ");
        } else if (choose == 2) {
            this.setValue(" O ");
        }
    }

    public static String readInput() {


        return scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}