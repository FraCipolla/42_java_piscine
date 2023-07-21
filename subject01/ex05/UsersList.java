package ex05;

public interface UsersList {
    public User addUser(String name, int balance);
    public User retrieveById(int id);
    public User retrieveByIndex(int index);
    public int  nUser();
    
    public class UserNotFoundException extends RuntimeException {
    
        public UserNotFoundException(String error) {
            super("\n" + error + "\n");
        }
    }
    
}