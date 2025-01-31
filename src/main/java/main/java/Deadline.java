package main.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDateTime by;

    public Deadline(String description, String by ) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HHmm");
        this.by = LocalDateTime.parse(by, formatter);
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String toFileForm() {
        return "D" + " | " + super.toFileForm() + " | " + this.by;
    }
}
