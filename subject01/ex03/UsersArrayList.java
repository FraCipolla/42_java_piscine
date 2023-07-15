package ex03;

/**
 * UsersArrayList
 */
public class UsersArrayList implements UsersList {

    private int _capacity = 10;
    private int _size = 0;
    private User[] _store = new User[_capacity];
    
    private void increasesize() {
        User[] tmp = _store;
        this._store = new User[this._capacity];
        for (int i = 0; i < this._size; i++) {
            this._store[i] = tmp[i];
        }
    }

    public void addUser(User user) {
        for (int i = 0; i < _capacity; i++) {
            if (this._store[i] == null) {
                this._store[i] = user;
                this._size++;
                if (this._capacity == this._size) {
                    this._capacity += this._capacity / 2;
                    this.increasesize();
                }
                return ;
            }
        }
    };

    public User retrieveById(int id) throws UserNotFoundException  {
        User tmp = null;

        for (int i = 0; i < this._size; i++) {
            if (this._store[i].getID() == id) {
                tmp = this._store[i];
            }
        }
        if (tmp == null) {
            throw new UserNotFoundException("user with that id doesn't exist");
        }
        return tmp;
    };

    public User retrieveByIndex(int index) throws UserNotFoundException {
        User tmp = this._store[index];
        if (tmp == null) {
            throw new UserNotFoundException("no user at that index!");
        }
        return tmp;
    };

    public int  nUser() { return this._size; };

}