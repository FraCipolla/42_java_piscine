package ex02;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Error, need 1 arguments");
            System.exit(-1);
        }

        String[] path = args[0].split("=");
        Shell shell = new Shell(path[1]);
        shell.loop();
    }
}
