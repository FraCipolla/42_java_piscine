package ex01;

public class User {
    public final int _ID;
    private String _name;
    private int _balance;
 
    // Costructor
    public User(String name, int balance) {
        if (balance < 0) {
            System.err.println("Cannot input a negative amount");
            System.exit(-1);
        }
        this._balance = balance;
        this._name = name;
        this._ID = UserIdsGenerator.getInstance().generateId();
    }

    // GETTERS
    public int getID() { return this._ID; }
    public String getName() { return this._name; }
    public int getBalance() { return this._balance; }
}