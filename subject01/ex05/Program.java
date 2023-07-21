package ex05;

import ex05.UsersList.UserNotFoundException;

public class Program {
    public static void main(String[] args) throws UserNotFoundException {
        Menu menu = new Menu();

        if (args[1].equals("--profile=dev")) {
            menu.loop_dev();
        } else if (args[1].equals("--profile=production") || args[1] == null) {
            menu.loop_prod();
        }
    }
    
}
