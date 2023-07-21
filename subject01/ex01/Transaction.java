package ex01;

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

    public void setTransaction(int recID, int sendID, int amount) {
        this._identifier = UUID.randomUUID();
        this._recipient = recID;
        this._sender = sendID;
        this._amount = amount;
    }
}
