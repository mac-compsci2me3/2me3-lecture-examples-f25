package fourthWeek;

import java.io.*;

/**
 * 1) finally ALWAYS runs (normal path, handled exception, rethrow) — great for cleanup/logging.
 * 2) try-with-resources closes resources automatically (real I/O types here), but finally still runs.
 * 3) return inside try/catch still executes finally (unless JVM exits or fatal error).
 * 4) Order of execution: try → (catch?) → finally → caller (or next line).
 **/

public class FinallyExample {

    // Case A: Normal path → try → finally → after
    static void caseA_Normal() {
        System.out.println("\n=== Case A: Normal path ===");
        try {
            System.out.println("[A] try: doing work (no exception)");
        } finally {
            System.out.println("[A] finally: cleanup/log");
        }
        System.out.println("[A] after try/finally");
    }

    // Case B: Handled exception (no rethrow) → try → catch → finally → after
    static void caseB_Handled() {
        System.out.println("\n=== Case B: Handled exception (no rethrow) ===");
        try {
            System.out.println("[B] try: about to throw");
            throw new IOException("B oom!");
        } catch (IOException e) {
            System.out.println("[B] catch: " + e.getMessage());
        } finally {
            System.out.println("[B] finally: cleanup/log");
        }
        System.out.println("[B] after try/catch/finally");
    }

    // Case C: Rethrow after catch → try → catch (rethrow) → finally → caller handles
    static void caseC_Rethrow() throws Exception {
        System.out.println("\n=== Case C: Rethrow after catch ===");
        try {
            System.out.println("[C] try: about to throw");
            throw new FileNotFoundException("C missing file");
        } catch (FileNotFoundException e) {
            System.out.println("[C] catch: wrapping and rethrowing");
            throw new Exception("C wrapped", e);
        } finally {
            System.out.println("[C] finally: runs BEFORE caller sees rethrow");
        }
        // unreachable if rethrow occurred
    }

    // Case D: try-with-resources with real I/O + finally still runs
    static void caseD_TryWithResources() throws IOException {
        System.out.println("\n=== Case D: try-with-resources (FileReader) + finally ===");
        // Talking cue: The FileReader will be auto-closed before 'finally' executes.
        try (FileReader fr = new FileReader("example.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String first = br.readLine();
            System.out.println("[D] read first line: " + first);
            // Uncomment to simulate error AFTER opening:
            // if (true) throw new IOException("D simulated I/O error after opening");
        } finally {
            System.out.println("[D] finally: runs after resources are closed");
        }
        System.out.println("[D] after try-with-resources/finally");
    }

    // Case E: return inside try — finally still runs
    static int caseE_ReturnFinally() {
        System.out.println("\n=== Case E: return inside try (finally still runs) ===");
        try {
            System.out.println("[E] try: going to return 42");
            return 42;
        } finally {
            System.out.println("[E] finally: runs even with return");
        }
    }

    public static void main(String[] args) {
        caseA_Normal();
        caseB_Handled();

        try {
            caseC_Rethrow();
        } catch (Exception e) {
            System.out.println("[main] caught rethrow from C, cause = " + e.getCause());
        } finally {
            System.out.println("[main] finally after caseC_Rethrow");
        }

        try {
            caseD_TryWithResources();
        } catch (IOException ioe) {
            System.out.println("[main] IOException in D: " + ioe.getMessage());
        }

        int v = caseE_ReturnFinally();
        System.out.println("[main] value from E = " + v);
    }
}
