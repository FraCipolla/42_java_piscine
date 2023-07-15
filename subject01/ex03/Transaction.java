package ex03;

import java.util.UUID;

public class Transaction {
    private UUID _identifier;
    private int _recipient;
    private int _sender;
    private boolean _category;
    private int _amount;

    // GETTERS
    public UUID getTranID() { return this._identifier; }
    public int getRecipient() { return this._recipient; }
    public int getSender() { return this._sender; }
    public boolean getCat() { return this._category; }
    public int getAmount() { return this._amount; }

    public void setTransaction(UUID id, int recID, int sendID, int amount, boolean category) {
        if (category == false && amount > 0) {
            System.err.println("debit must be negative");
            System.exit(-1);
        } else if (category == true && amount < 0) {
            System.err.println("credit must be positive");
            System.exit(-1);
        }
        this._identifier = id;
        this._recipient = recID;
        this._sender = sendID;
        this._amount = amount;
        this._category = category;
    }
}
