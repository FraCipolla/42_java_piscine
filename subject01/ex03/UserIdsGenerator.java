package ex03;

public class UserIdsGenerator {
    // unica instanza della classe
    private static UserIdsGenerator instance = null;
    
    // costruttore invisibile
    private UserIdsGenerator() {};
    
    // crea l'oggetto solo se non esiste
    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    
    private int _id = 0;
    
    public int generateId() {
        return this._id++;
    }
}
