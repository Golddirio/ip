package main.java;

import java.io.*;
import java.util.ArrayList;


public class Storage {
    private static final String FILE_PATH = "./data/tasks.txt";

    public Storage() {
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            File file = new File(FILE_PATH);
            File directory = file.getParentFile();

            if (directory != null && !directory.exists()) {
                directory.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error when creating the file: " + e.getMessage());
        }
    }

    public void save(ArrayList<Task> list) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task: list) {
                writer.write(task.toFileForm());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error when saving the task: " + e.getMessage());
        }
    }
}
