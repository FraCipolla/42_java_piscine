package ex04;

public class UsersArrayList implements UsersList {

    private int _capacity = 10;
    private int _size = 0;
    private User[] _store;

    public UsersArrayList() {
        this._store = new User[this._capacity];
    }
    
    private void increaseSize() {
        User[] tmp = _store;
        this._store = new User[this._capacity];
        for (int i = 0; i < this._size; i++) {
            this._store[i] = tmp[i];
        }
    }

    public User addUser(String name, int balance) {
        User newUser = new User(name, balance);
        this._store[this._size] = newUser;
        this._size++;
        if (this._capacity == this._size) {
            this._capacity += this._capacity / 2;
            this.increaseSize();
        }
        return newUser;
    };

    public User retrieveById(int id) {
        User tmp = null;
        try {
            for (int i = 0; i < this._size; i++) {
                if (this._store[i].getID() == id) {
                    tmp = this._store[i];
                }
            }
        } catch (UserNotFoundException err) {
            throw new UserNotFoundException("user with that id doesn't exist");
        }
        return tmp;
    };

    public User retrieveByIndex(int index){
        User tmp = this._store[index];
        if (tmp == null) {
            throw new UserNotFoundException("no user at that index!");
        }
        return tmp;
    };

    public int  nUser() { return this._size; };

}