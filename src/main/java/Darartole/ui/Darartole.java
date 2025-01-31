package Darartole.ui;

import java.util.Scanner;
import main.java.Deadline;
import main.java.Event;
import main.java.Storage;
import java.util.ArrayList;
import main.java.Todo;
import main.java.Tasklist;
import main.java.Ui;
import Darartole.exception.*;

public class Darartole {
    /* The Tasklist object that manages all the tasks */
    private Tasklist tasks;
    /* The information of the user */
    private Ui ui;
    /* The txt file stored containing the tasklist */
    private Storage fileStored;

    public Darartole(String filePath) {
        ui = new Ui();
        tasks = new Tasklist(new ArrayList<>());
        fileStored = new Storage();
    }
    /**
     * Turn on the chatbot to read in whatever the user type on the screen
     */

    public void run() {
        String logo = " ____                     _        _\n"
        + "|  _ \\  __ _ _ __ __ _ _ __| |_ ___ | | ___\n"
        + "| | | |/ _` | '__/ _` | '__| __/ _ \\| |/ _ \\\n"
        + "| |_| | (_| | | | (_| | |  | || (_) | |  __/\n"
        + "|____/ \\__,_|_|  \\__,_|_|   \\__\\___/|_|\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("I'm Darartole. What can I do for you?");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            Scanner scanInput = new Scanner(input);
            String firstWord = scanInput.next();
            System.out.println("_____________________________");
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again!");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                this.tasks.list();
            } else if (scanInput.hasNextInt()) {
                int taskNo = scanInput.nextInt();
                if (firstWord.equalsIgnoreCase("mark")) {
                    tasks.mark(taskNo - 1);
                    fileStored.save(tasks);
                } else if (firstWord.equalsIgnoreCase("unmark")) {
                    tasks.unmark(taskNo - 1);
                    fileStored.save(tasks);
                }
            } else if (firstWord.equalsIgnoreCase("todo")) {
                try {
                    String following = input.substring(4).trim();
                    if (following.isEmpty()) {
                        throw new EmptyBotException("Cannot be empty task.");
                    }
                    Todo todo = new Todo(input);
                    tasks.addTask(todo);
                    System.out.println("Add one todo");
                    System.out.println(todo.toString());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    fileStored.save(tasks);
                } catch (EmptyBotException e) {
                    System.out.println("ILLEGAL INPUT!" + e.getMessage());
                }
            } else if (firstWord.equalsIgnoreCase("deadline")) {
                try {
                    String following = input.substring(8).trim();
                    if (following.isEmpty()) {
                        throw new EmptyBotException("Cannot be empty task.");
                    }
                    String[] parts = input.split("/by");
                    String taskDescription = parts[0].trim(); 
                    String deadline = parts[1].trim(); 
                    Deadline ddl = new Deadline(taskDescription, deadline);
                    tasks.addTask(ddl);
                    System.out.println(ddl.toString());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    fileStored.save(tasks);
                } catch (EmptyBotException e) {
                    System.out.println("ILLEGAL INPUT!" + e.getMessage());
                }
            } else if (firstWord.equalsIgnoreCase("event")) {
                try {
                    String following = input.substring(5).trim();
                    if (following.isEmpty()) {
                        throw new EmptyBotException("Cannot be empty task.");
                    }
                    String[] partsFrom = input.split("/from");
                    String[] partsTo = partsFrom[1].split("/to");
                    String taskDescription = partsFrom[0].trim(); // Task description before "/from"
                    String fromTime = partsTo[0].trim(); // Time after "/from"
                    String toTime = partsTo[1].trim();
                    Event event = new Event(taskDescription, fromTime, toTime);
                    tasks.addTask(event);
                    System.out.println(event.toString());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    fileStored.save(tasks);
                } catch (EmptyBotException e) {
                    System.out.println("ILLEGAL INPUT!" + e.getMessage());
                }

            } else if (firstWord.equalsIgnoreCase("delete")) {
                String following = input.substring(6).trim();
                if (!following.isEmpty() && following.matches("\\d+")) {
                    int taskNo = Integer.parseInt(following); 
                    System.out.println("I have removed the task for you.");
                    tasks.printTask(taskNo - 1);
                    tasks.removeTask(taskNo - 1);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    fileStored.save(tasks);
                } else {
                    System.out.println("Please tell me the number of the task that you want to delete.");
                }
            } else {
                System.out.println("I am sorry! I do not understand what you mean.");
            }      
        }
    }
    public static void main(String[] args) {
        new Darartole("data/tasks.txt").run();
    }
}
