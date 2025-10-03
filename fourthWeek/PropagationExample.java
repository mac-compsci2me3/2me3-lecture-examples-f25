package fourthWeek;
 
// Exception propagation aligned with course slides
//
// - Exceptions bubble up the call chain until caught.
// - If not caught, the program terminates with an uncaught exception.
// - The stack trace shows the propagation path (C → B → A → main).
// - Top-level try/catch can prevent crashes.


public class PropagationExample {
    public static class MyException extends Exception {
        public MyException(String msg) { super(msg); }
    }

    // methodC throws -> exits immediately
    static void methodC() throws MyException {
        throw new MyException("error in methodC()"); // deepest level throws
    }

    // methodB receives exception -> exits immediately (if unhandled)
    static void methodB() throws MyException { //no catch here, propagates upward
        methodC();
    }

    // methodA receives exception -> exits immediately (if unhandled)
    static void methodA() throws MyException { //still not caught, keeps bubbling up
        methodB();
    }

    public static void main(String[] args) throws MyException {
        // Top-level catch illustrates the propagation path.
        // try {
        //     methodA();  // exception eventually caught here
        //     System.out.println("This line will not run due to exception.");
        // } catch (MyException e) {
        //     System.out.println("Caught at top level: " + e);
        //     System.out.println("Stack trace shows propagation:");
        //     e.printStackTrace(); // a built-in method with Throwable class
        // }
        methodA();
        // If remove the try/catch above, the program will terminate when main()
        // receives the unhandled exception, matching the slide's description.
        System.out.println("Program continues after handling at top level.");
    }
}
