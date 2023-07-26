package edu.school21.printer;

public class Program {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: need 2 arguments");
            System.exit(-1);
        }

        String white = args[0];
        String black = args[1];

        Logic logic = new Logic();
        logic.printImg(white, black);
    }
}
