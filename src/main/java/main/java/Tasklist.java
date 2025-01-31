package main.java;

import java.util.ArrayList;

public class Tasklist {
    protected static ArrayList<Task> list;

    public Tasklist(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getter() {
        return this.list;
    }

    public int size() {
        return list.size();
    }

    public void addTask(Task task) {
        this.list.add(task);
    }

    public void removeTask(int no) {
        this.list.remove(no);
    }

    public void list() {
        for (int i = 1; i <= list.size(); i++) {
            Task curr = this.list.get(i-1);
            System.out.println(i + ". " + curr.toString());
        }
    }

    public void mark(int no) {
        Task target = list.get(no);
        target.markTask();
        System.out.println("Good job. You have just finished one task.");
        System.out.println("[" + target.getStatusIcon() + "] " + target.getDescription());
    }

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
