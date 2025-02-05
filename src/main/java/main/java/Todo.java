package main.java;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    public String toString() {
        return "[T]" + super.toString();
    }

    public String toFileForm() {
        return "T" + " | " + super.toFileForm();
    }

    public static Todo fromFileForm(boolean isDone, String description) {
        Todo td = new Todo(description);
        if (isDone == true) td.markTask();
        return td;
    }
}
