package main.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    /* The datetime of the deadline */
    protected LocalDateTime by;

    public Deadline(String description, String by ) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HHmm");
        this.by = LocalDateTime.parse(by, formatter);
    }
    /**
     * Returns the string format of deadline
     * 
     * @return the string that is printed
     */
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
    /**
     * Converts the deadline task to the string that can be written to the file
     * 
     * @return the string that is going to be written on txt file
     */
    public String toFileForm() {
        return "D" + " | " + super.toFileForm() + " | " + this.by;
    }
}
