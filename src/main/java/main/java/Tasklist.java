package main.java;

import java.util.ArrayList;

public class Tasklist {
    /* The list that contains all the task objects */
    protected static ArrayList<Task> list;

    public Tasklist(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getter() {
        return this.list;
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
        this.list.add(task);
    }

    /**
     * Removes the task from the list
     * 
     * @param no the number of the task that the user want to remove
     */

    public void removeTask(int no) {
        this.list.remove(no);
    }

    /**
     * Prints out the content of the tasklist
     */
    public void list() {
        for (int i = 1; i <= list.size(); i++) {
            Task curr = this.list.get(i-1);
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
}
