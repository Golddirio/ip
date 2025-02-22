package Darartole.ui;

import java.util.Scanner;

import Darartole.exception.EmptyBotException;
import main.java.Deadline;
import main.java.Event;
import main.java.Storage;
import main.java.Tasklist;
import main.java.Todo;

/**
 * The main class for the chatbot
 */
public class Darartole {
    /* The Tasklist object that manages all the tasks */
    private Tasklist tasks;
    /* The txt file stored containing the tasklist */
    private Storage fileStored = new Storage();
    /* The response returned by the bot*/
    private String response;

    /**
     * Opens the chatbot for the user
     */
    public Darartole() {
        tasks = fileStored.load();
    }
    /**
     * Turn on the chatbot to read in whatever the user type on the screen
     */
    public void run(String input) {
        Scanner scanInput = new Scanner(input);
        String firstWord = scanInput.next();
        assert firstWord == null : "Please give me some input so that I can process for you.";
        if (input.equalsIgnoreCase("bye")) {
            this.response = "Bye. Hope to see you again!";
        } else if (input.equalsIgnoreCase("list")) {
            this.response = this.tasks.list();
        } else if (scanInput.hasNextInt()) {
            int taskNo = scanInput.nextInt();
            if (firstWord.equalsIgnoreCase("mark")) {
                this.response = tasks.mark(taskNo - 1);
                fileStored.save(tasks);
            } else if (firstWord.equalsIgnoreCase("unmark")) {
                this.response = tasks.unmark(taskNo - 1);
                fileStored.save(tasks);
            } else if (firstWord.equalsIgnoreCase("delete")) {
                StringBuilder res = new StringBuilder();
                try {
                    tasks.removeTask(taskNo - 1);
                } catch (EmptyBotException e) {
                    this.response = "ILLEGAL INPUT!" + e.getMessage();
                    return;
                }
                fileStored.save(tasks);
                res.append("I have removed the task for you.").append("\n")
                        .append("Now you have ").append(tasks.size()).append(" tasks in the list. ");
                this.response = res.toString();
            }
        } else if (firstWord.equalsIgnoreCase("find")) {
            StringBuilder res = new StringBuilder();
            res.append("Here are the matching tasks in the list: ");
            String following = input.substring(4).trim();
            this.response = res.append(tasks.findTask(following)).toString();
        } else if (firstWord.equalsIgnoreCase("todo")) {
            this.response = Todo.addTodo(input, this.tasks, this.fileStored);
        } else if (firstWord.equalsIgnoreCase("deadline")) {
            this.response = Deadline.addDeadline(input, this.tasks, this.fileStored);
        } else if (firstWord.equalsIgnoreCase("event")) {
            this.response = Event.addEvent(input, this.tasks, this.fileStored);
        } else {
            this.response = "I am SOOOO sorry! I do not understand what you mean... ";
        }
    }

    public String getResponse(String input) {
        this.run(input);
        return this.response;
    }

}
