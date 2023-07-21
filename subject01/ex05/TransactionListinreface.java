package ex05;

import java.util.UUID;

public interface TransactionListinreface {
    public void addTransaction(Transaction data);
    public void removeTransactionById(UUID ID);
    public Transaction[] transformToArray();

    public class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String msg) {
            super("\n" + msg + "\n");
        }
    }

}
