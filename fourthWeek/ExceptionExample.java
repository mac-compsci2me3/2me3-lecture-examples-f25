package fourthWeek;

import java.io.*;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            // Checked Exception: This block attempts to open a file that doesn't exist
            //readFile("nonexistentfile.txt");
            readFile("example.txt");
            
            // Unchecked Exception: This block attempts to divide by zero
            int result = divide(10, 0);
            System.out.println("Result: " + result);
            
        } catch (FileNotFoundException e) {
            System.out.println("Caught a checked exception: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Caught an unchecked exception: " + e);
        } finally {
            System.out.println("Finally block executed.");
        }
    }
    
    // Method that throws a checked exception - FileNotFoundException
    // These are exceptions that are checked at compile time. 
    // The compiler ensures that the code handles these exceptions, 
    // either by catching them in a try-catch block or declaring them 
    // with a throws clause in the method signature.
    // If checked exception are not handled, there will be a compilation error
    // error: unreported exception FileNotFoundException; must be caught or declared to be thrown
    public static void readFile(String fileName) throws FileNotFoundException {
        FileReader file = new FileReader(fileName);
        BufferedReader fileInput = new BufferedReader(file);

        throw new FileNotFoundException("File not found");
    }
    
    // Method that throws an unchecked exception - ArithmeticException
    // These are exceptions that are not checked at compile time. 
    // They derive from RuntimeException and its subclasses. 
    // The compiler doesn't force you to handle or declare them.
    public static int divide(int a, int b) {
        return a / b;
    }
}