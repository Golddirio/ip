package main.java;

import java.util.ArrayList;

public class Tasklist {
    protected static ArrayList<Task> list;

    public Tasklist(ArrayList<Task> list) {
        this.list = list;
    }

    public ArrayList<Task> getter() {
        return list;
    }

    public int size() {
        return list.size();
    }

    public void addTask(Task task) {
        list.add(task);
    }

    public void removeTask(int no) {
        list.remove(no);
    }

    public void list() {
        for (int i = 1; i <= list.size(); i++) {
            Task curr = list.get(i-1);
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
}
