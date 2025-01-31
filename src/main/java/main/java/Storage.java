package main.java;

import java.io.*;
import java.util.ArrayList;


public class Storage {
    /* The path of the file that records all the tasks */
    private static final String FILE_PATH = "./data/tasks.txt";

    public Storage() {
        ensureFileExists();
    }
    /**
     * Ensures that the file exists. 
     * If it does not exist, a new directory and a new file will be created under the specified path. 
     */
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

    /**
     * Saves the task to the txt file. 
     * 
     * @param ls the tasklist object
     */
    public void save(Tasklist ls) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            ArrayList<Task> list = ls.getter();
            for (Task task: list) {
                writer.write(task.toFileForm());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error when saving the task: " + e.getMessage());
        }
    }

    // public ArrayList<Task> load() {
    //     ArrayList<Task> list = new ArrayList<>();
    //     try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             char type = line.charAt(0);
    //             if (type == "T") {
    //                 Todo todo = Todo.
    //             }
    //         }
    //     }
    // }
}
