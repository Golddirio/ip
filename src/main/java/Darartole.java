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
        ArrayList<Task> info = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            Scanner scanInput = new Scanner(input);
            String firstWord = scanInput.next();
            System.out.println("_____________________________");
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again!");
                break;
            } 
            if (input.equalsIgnoreCase("list")) {
                for (int i = 1; i <= info.size(); i++) {
                    Task curr = info.get(i-1);
                    System.out.println(i + ". " + curr.toString());
                }

            } else if (scanInput.hasNextInt()) {
                int taskNo = scanInput.nextInt();
                
                if (firstWord.equalsIgnoreCase("mark")) {
                    Task target = info.get(taskNo - 1);
                    target.markTask();
                    System.out.println("Good job. You have just finished one task.");
                    System.out.println("[" + target.getStatusIcon() + "] " + target.getDescription());
                
                } else if (firstWord.equalsIgnoreCase("unmark")) {
                    Task target = info.get(taskNo - 1);
                    target.unmarkTask();
                    System.out.println("I have helped you unmark the task.");
                    System.out.println("[" + target.getStatusIcon() + "] " + target.getDescription());

                }
            
            } else if (firstWord.equalsIgnoreCase("todo")) {
                Todo todo = new Todo(input);
                info.add(todo);
                System.out.println("Add one todo");
                System.out.println(todo.toString());
            } else if (firstWord.equalsIgnoreCase("deadline")) {
                String[] parts = input.split("/by");
                String taskDescription = parts[0].trim(); 
                String deadline = parts[1].trim(); 
                Deadline ddl = new Deadline(taskDescription, deadline);
                info.add(ddl);
                System.out.println(ddl.toString());
            } else if (firstWord.equalsIgnoreCase("event")) {
                String[] partsFrom = input.split("/from");
                String[] partsTo = partsFrom[1].split("/to");
                String taskDescription = partsFrom[0].trim(); // Task description before "/from"
                String fromTime = partsTo[0].trim(); // Time after "/from"
                String toTime = partsTo[1].trim();
                Event event = new Event(taskDescription, fromTime, toTime);
                info.add(event);
                System.out.println(event.toString());
            }
            
        }

    }
}
