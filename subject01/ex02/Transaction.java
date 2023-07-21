package ex02;

import java.util.UUID;

public class Transaction {
    private UUID _identifier;
    private int _recipient;
    private int _sender;
    private boolean _category;
    private int _amount;

    public Transaction() {};
    public Transaction(Transaction transaction) {
        this._identifier = transaction.getTranID();
        this._recipient = transaction.getRecipient();
        this._sender = transaction.getSender();
        this._category = transaction.getCat();
        this._amount = transaction.getAmount();
    }
    // GETTERS
    public UUID getTranID() { return this._identifier; }
    public int getRecipient() { return this._recipient; }
    public int getSender() { return this._sender; }
    public boolean getCat() { return this._category; }
    public int getAmount() { return this._amount; }

    public void setRecipient() { this._recipient = 0; }
    public void setSender() { this._sender = 0; }

    public Transaction setTransaction(int sendID, int recID, int amount) {
        this._identifier = UUID.randomUUID();
        this._recipient = recID;
        this._sender = sendID;
        this._amount = amount;
        return this;
    }


    public Transaction setCategory(boolean category) {
        this._category = category;
        return this;
    }
    
}
