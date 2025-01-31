package main.java;

import java.util.ArrayList;

public class Tasklist {
    /* The list that contains all the task objects */
    protected static ArrayList<Task> list;

    public Tasklist(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getter() {
        return list;
    }

    /**
     * Returns that number of tasks in the list
     * 
     * @return the number of tasks
     */
    public int size() {
        return list.size();
    }

    /**
     * Adds the task to the list
     * 
     * @param task the task the user wants to add
     */
    public void addTask(Task task) {
        list.add(task);
    }

    /**
     * Removes the task from the list
     * 
     * @param no the number of the task that the user want to remove
     */

    public void removeTask(int no) {
        list.remove(no);
    }

    /**
     * Prints out the content of the tasklist
     */
    public void list() {
        for (int i = 1; i <= list.size(); i++) {
            Task curr = list.get(i-1);
            System.out.println(i + ". " + curr.toString());
        }
    }

    /**
     * Marks the specific task as finished
     * 
     * @param no the number of the task that the user want to mark
     */

    public void mark(int no) {
        Task target = list.get(no);
        target.markTask();
        System.out.println("Good job. You have just finished one task.");
        System.out.println("[" + target.getStatusIcon() + "] " + target.getDescription());
    }

    /**
     * Unmarks the task that has previously been marked
     * 
     * @param no the number of the task that the user wants to unmark
     */
    public void unmark(int no) {
        Task target = list.get(no);
        target.unmarkTask();
        System.out.println("I have helped you unmark the task.");
        System.out.println("[" + target.getStatusIcon() + "] " + target.getDescription());
    }

    public void printTask(int no) {
        Task task = list.get(no);
        System.out.println(task.toString());
    }

    /**
     * Finds the tasks whose description contains the query string s
     * 
     * @param s the query string that I want to find
     */
    public void findTask(String s) {
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDescription().contains(s)) {
                matchingTasks.add(list.get(i));
            }
        }

        if (matchingTasks.isEmpty()) {
            System.out.println("There is not matching task.");
        } else {
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + matchingTasks.get(i));
            }
        }
    }
}
