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
    public String list() {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= list.size(); i++) {
            Task curr = list.get(i - 1);
            res.append(i).append(". ").append(curr.toString()).append("\n");
            //System.out.println(i + ". " + curr.toString());
        }
        return res.toString();
    }

    /**
     * Marks the specific task as finished
     *
     * @param no the number of the task that the user want to mark
     */

    public String mark(int no) {
        StringBuilder res = new StringBuilder();
        Task target = list.get(no);
        target.markTask();
        res.append("Good job. You have just finished one task.").append("\n")
                        .append("[" + target.getStatusIcon() + "] " + target.getDescription());
        //System.out.println("Good job. You have just finished one task.");
        //System.out.println("[" + target.getStatusIcon() + "] " + target.getDescription());
        return res.toString();
    }

    /**
     * Unmarks the task that has previously been marked
     *
     * @param no the number of the task that the user wants to unmark
     */
    public String unmark(int no) {
        StringBuilder res = new StringBuilder();
        Task target = list.get(no);
        target.unmarkTask();
        res.append("I have helped you unmark the task.").append("\n")
                        .append("[" + target.getStatusIcon() + "] " + target.getDescription());
        //System.out.println("I have helped you unmark the task.");
        //System.out.println("[" + target.getStatusIcon() + "] " + target.getDescription());
        return res.toString();
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
    public String findTask(String s) {
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDescription().contains(s)) {
                matchingTasks.add(list.get(i));
            }
        }

        if (matchingTasks.isEmpty()) {
            //System.out.println("There is not matching task.");
            return "There is not matching task.";
        } else {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < matchingTasks.size(); i++) {
                res.append(i + 1).append(". ").append(matchingTasks.get(i)).append("\n");
                //System.out.println((i + 1) + ". " + matchingTasks.get(i));
            }
            return res.toString();
        }
    }
}
