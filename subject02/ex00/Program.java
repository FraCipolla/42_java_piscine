package ex00;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            Parser parser = new Parser("ex00/signatures.txt");
            parser.loop();
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
    }
}
