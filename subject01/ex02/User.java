package ex02;

public class User {
    public  int _ID;
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
    }

    // GETTERS
    public int getID() { return this._ID; }
    public String getName() { return this._name; }
    public int getBalance() { return this._balance; }

    public void add(int amount) { this._balance += amount; }
    public void decrease(int amount) { this._balance -= amount; }
}