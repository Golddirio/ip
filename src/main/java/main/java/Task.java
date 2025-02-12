package main.java;

public class Task {
    /* The description of the task */
    protected String description;
    /* The boolean that records whether the task has been finished */
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the string format that represents the status of the task.
     * 
     * @return the string icon 
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Marks the task to be done
     */
    public void markTask() {
        this.isDone = true;
    }

    /**
     * Unmarks the task that has previously marked as done. 
     */
    public void unmarkTask() {
        this.isDone = false;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }

    public String toFileForm() {
        return (isDone ? 1 : 0) + " | " + this.description;
    }

    public boolean isEqual(Task taskA, Task taskB) {
        boolean isDescriptionSame = taskA.getDescription() == taskB.getDescription();
        boolean isDoneSame = taskA.getStatusIcon() == taskB.getStatusIcon();
        return isDescriptionSame && isDoneSame;
    }


}
