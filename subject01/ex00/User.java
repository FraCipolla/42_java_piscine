package ex00;

public class User {
    private int _ID;
    private String _name;
    private int _balance;
 
    // Costructor
    User(int id, String name, int balance) {
        if (balance < 0) {
            System.err.println("Cannot input a negative amount");
            System.exit(-1);
        } else {
            this._ID = id;
            this._balance = balance;
            this._name = name;
        }
    }

    // GETTERS
    public int getID() { return this._ID; }
    public String getName() { return this._name; }
    public int getBalance() { return this._balance; }
}