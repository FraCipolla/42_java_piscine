package ex01;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length != 2) {
            System.out.println("Error: excpecting 2 arguments!");
            System.exit(-1);
        }
        
        Words words = new Words(args[0], args[1]);

        words.printSimilarity();
    }


}
