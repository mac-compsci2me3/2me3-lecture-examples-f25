package fourthWeek;
import java.io.FileNotFoundException;

// - Different exceptions can be handled by different catch blocks (specific messages).
// - Always order catch blocks from most specific to most general.
// - finally block always runs, useful for cleanup.
// - Multi-catch can be used if handling is identical.
public class MultipleCatchExample {
    public static class MyException extends Exception {
        public MyException(String msg) { super(msg); }
    }

    // This method can throw 3 different exceptions depending on input
    public static void errorProneMethod(String filename, int idx)
            throws FileNotFoundException, ArrayIndexOutOfBoundsException, MyException {
        if (filename == null || filename.isEmpty())
            throw new FileNotFoundException("empty file name"); // filename error
        if (idx < 0)
            throw new ArrayIndexOutOfBoundsException("negative idx"); // index error
        if (filename.endsWith(".pdf"))
            throw new MyException("don't use pdf okay?"); // custom rule
        // otherwise "success"
    }

    public static void main(String[] args) {
        String filename = (args.length > 0) ? args[0] : "";
        int idx =  (args.length > 1) ? Integer.parseInt(args[1]) : -1;

        try {
            errorProneMethod(filename, idx);
            System.out.println("No exception occurred.");
        } catch (FileNotFoundException fe) { // the most specific
            System.out.println("FileNotFoundException: " + fe.getMessage());
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("ArrayIndexOutOfBoundsException: " + ae.getMessage());
        } catch (MyException me) { // more general
            System.out.println("MyException: " + me.getMessage());
            // IO exception could be inserted between, filenotfound is a subclass of IO
            // and then ended with Exception 
        } finally {
            System.out.println("Finally: clean up or logging here.");
        }

       
    }
}
