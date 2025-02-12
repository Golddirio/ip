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

    /**
     * Converts the text in the txt to the object Todo
     *
     * @param isDone whether the todo has been finished
     * @param description the content of the todo
     * @return Todo object having the same information
     */
    public static Todo fromFileForm(boolean isDone, String description) {
        Todo td = new Todo(description);
        if (isDone == true) {
            td.markTask();
        }
        return td;
    }
}
