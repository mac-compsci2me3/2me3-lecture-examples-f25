package fourthWeek;
import java.io.FileNotFoundException;
 
// - Rethrowing: preserves the original exception object and stack trace.
// - Wrapping: converts a low-level exception to a domain-specific one, but may lose the cause.
// - Chaining: links the new exception to the original with initCause(), useful for debugging.
// - Debugging tip: Always print getCause() to see the original reason.
public class RethrowAndChainingExample {
    // Custom checked exception as in slides
    public static class MyException extends Exception {
        public MyException() { super(); }
        public MyException(String msg) { super(msg); }
        // TODO: Add a constructor here that also takes a Throwable cause
        // you can use super(msg, cause) for the constructor
         public MyException(String msg, Throwable cause) { 
            super(msg, cause); 
        }
    
    }

    // Lowest level check - throws FileNotFoundException if invalid filename
    public static void validateFilename(String filename) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
            throw new FileNotFoundException("empty file name");
        }
    }

    // Rethrow SAME exception, stack trace preserved
    public static void rethrowSame(String filename) throws FileNotFoundException {
        try {
            validateFilename(filename);
        } catch (FileNotFoundException fe) {
            System.out.println("peek & log: " + fe.getMessage());
            throw fe; // rethrow the SAME exception
        }
    }

    //  Wrap into MyException, original cause is lost
    public static void rethrowWrap(String filename) throws MyException {
        try {
            validateFilename(filename);
        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException: " + fe.getMessage());
            throw new MyException("wrapped as MyException"); // cause NOT chained here
        }
    }

    // Chain with initCause to link new exception to the original
    public static void rethrowChain(String filename) throws MyException {
        try {
            validateFilename(filename);
        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException: " + fe.getMessage());
            // MyException me = new MyException(fe.getMessage());
            // me.initCause(fe); // explicit chaining to preserve original cause
            // TODO: Replace with constructor that accepts cause once added.
            throw new MyException(fe.getMessage(), fe);
            //throw me;
        }
    }

    public static void main(String[] args) {
        String empty = "";
        System.out.println("=== Rethrow SAME exception ===");
        try {
            rethrowSame(empty);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //  observe same stack trace
        }

        System.out.println("\n=== Wrap as MyException (no cause) ===");
        try {
            rethrowWrap(empty);
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("Cause? " + e.getCause()); // expected null cause
        }

        System.out.println("\n=== Chain with initCause ===");
        try {
            rethrowChain(empty);
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("Chained cause: " + e.getCause()); // points to FileNotFoundException (original)
        }
    }
}
