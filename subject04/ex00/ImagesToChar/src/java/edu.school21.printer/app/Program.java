package edu.school21.printer;

public class Program {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: need 3 arguments");
            System.exit(-1);
        }

        String white = args[0];
        String black = args[1];
        String path = args[2];

        Logic logic = new Logic();
        logic.printImg(white, black, path);
    }
}
