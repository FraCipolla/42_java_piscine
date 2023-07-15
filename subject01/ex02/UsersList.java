package ex02;

/**
 * UsersList
 */
public interface UsersList {
    public void addUser(User user);
    public User retrieveById(int id) throws UserNotFoundException;
    public User retrieveByIndex(int index) throws UserNotFoundException;
    public int  nUser();
    
    public class UserNotFoundException extends Exception {
    
        public UserNotFoundException(String error) {
            super(error);
        }
    }
    
}