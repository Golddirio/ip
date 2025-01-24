import java.util.Scanner;
import java.util.ArrayList;

public class Darartole {
    public static void main(String[] args) {
        String logo = " ____                     _        _      \n"
                + "|  _ \\  __ _ _ __ __ _ _ __| |_ ___ | | ___ \n"
                + "| | | |/ _` | '__/ _` | '__| __/ _ \\| |/ _ \\\n"
                + "| |_| | (_| | | | (_| | |  | || (_) | |  __/\n"
                + "|____/ \\__,_|_|  \\__,_|_|   \\__\\___/|_|\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I'm Darartole. What can I do for you?");
        ArrayList<String> info = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            System.out.println("_____________________________");
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again!");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                for (int i = 1; i <= info.size(); i++) {
                    System.out.println(i + ". " + info.get(i - 1));
                }

            } else {
                info.add(input);
                System.out.println("added: " + input);
            }
            
        }

    }
}
