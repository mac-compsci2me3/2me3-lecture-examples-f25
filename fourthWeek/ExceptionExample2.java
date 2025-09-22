package fourthWeek;

import java.io.*;

public class ExceptionExample2 {
    public static void main(String[] args) {
        readFile("nonexistentfile.txt");
        //readFile("example.txt");

        System.out.println("Finally block executed.");

    }
    
    public static void readFile(String fileName) {
        InputStream inputStream = ExceptionExample.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        // FileReader fileReader = new FileReader(fileName); // This line causes a problem
        // BufferedReader bufferedReader = new BufferedReader(fileReader);
    }
    
}