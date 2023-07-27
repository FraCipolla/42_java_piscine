package edu.school21.printer;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Program {
    @Parameter(names = {"--white"})
    private static String white;
	@Parameter(names = {"--black"})
    private static String black;

    public static void run() {
        Logic logic = new Logic();
        logic.printImg(white, black);
    }
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: need 2 arguments");
            System.exit(-1);
        }

        Program main = new Program();
        JCommander.newBuilder().addObject(main).build().parse(args);

        run();
    }
}
