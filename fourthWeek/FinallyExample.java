package fourthWeek;

import java.io.FileReader;
import java.io.IOException;

public class FinallyExample {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("example.txt");
            // Code that might throw IOException
            // For example, reading from the file
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Cleanup code: Ensure the file is closed 
            // Code inside finally block will execute any way
            System.out.println("Finally Block:");
            if (fileReader != null) {
                try {
                    fileReader.close();
                    System.out.println("File closed successfully.");
                } catch (IOException e) {
                    System.out.println("Failed to close the file: " + e.getMessage());
                }
            }
        }


    }
}