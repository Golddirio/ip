package main.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    /* datetime of the from timestamp */
    protected LocalDateTime from;
    /* datetime of the to timestamp */
    protected LocalDateTime to;

    public Event(String description, String from, String to) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    /**
     * Returns the string format of the event
     * 
     * @return the string that is going to be printed
     */
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
    
    /**
     * Converts the event object to the string that can be written on the txt file.
     * 
     * @return the string that is going to be written on the txt file. 
     */
    public String toFileForm() {
        return "E" + " | " + super.toFileForm() + " | " + this.from + " | " + this.to;
    }

    public static Event fromFileForm(boolean isDone, String description, String from, String to) {
        Event event = new Event(description, from, to);
        if (isDone == true) event.markTask();
        return event;
    }
 
}
