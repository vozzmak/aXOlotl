import java.util.Scanner;

public class Player {
    public String name;
    public String value;

    public Player() {

    }

    public void setName() {
        this.name = readInput();
        System.out.println("Hello, " + this.name);

    }

    public void setValue(int choose) {
//        int choose = readInputInt();
        if (choose == 1) {
            this.value = " X ";
        } else if (choose == 2) {
            this.value = " O ";
        }
    }

    public static String readInput() {
        String n = "";

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            n = scanner.nextLine();
        }

        //scanner.close();
        return n;
    }
}
