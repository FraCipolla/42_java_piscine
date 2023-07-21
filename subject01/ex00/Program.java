package ex00;

public class Program {
    static int id = 0;
    public static void main(String[] args) {
        System.out.println("Creating user Gouken, with tremenodus balance");

        User user1 = new User("Gouken", 10000000);

        System.out.println("User id: " + user1.getID());
        System.out.println("User name: " + user1.getName());
        System.out.println("User balance: " + user1.getBalance());

        System.out.println("Creating user Blanka, with negative balance. Expecting error!");

        User user2 = new User("Blanka", -1000000);
    }
}
