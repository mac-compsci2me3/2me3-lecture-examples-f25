package fourthWeek;

import java.io.*;

public class ChainingExample {
    public static void main(String[] args) {
        try {
            processFile();
        } catch (MyException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
            System.out.println("Original cause: " + e.getCause());
        }
    }

    // Method that throws a custom exception
    public static void processFile() throws MyException {
        try {
            // Attempt to read a file that doesn't exist
            readFile();
        } catch (FileNotFoundException e) {
            // Wrapping the original exception into a custom exception and chaining it
            throw new MyException("Error while processing file", e);
        }
    }

    // Method that throws a FileNotFoundException
    public static void readFile() throws FileNotFoundException {
        throw new FileNotFoundException("The file 'data.txt' was not found.");
    }
}

// Custom exception class
class MyException extends Exception {
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
