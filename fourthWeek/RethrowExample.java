package fourthWeek;

import java.io.*;

public class RethrowExample {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Caught rethrown exception in main: " + e.getMessage());
        }
    }

    // Method that handles and rethrows the exception
    public static void readFile() throws FileNotFoundException {
        try {
            // Attempt to read a file that doesn't exist
            FileReader fileReader = new FileReader("nonexistentfile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught in readFile method: " + e.getMessage());
            
            // Rethrowing the exception to be handled by the caller
            // The throw e statement in the readFile method sends the exception back up the call stack, 
            // allowing the main method to handle it.
            // This technique is useful for logging or adding additional information to an exception 
            // before passing it on to higher levels of the application.
            throw e; 
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}