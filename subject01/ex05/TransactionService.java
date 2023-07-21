package ex05;

import java.util.UUID;

import ex05.UsersList.UserNotFoundException;
import ex05.TransactionLinkedList;
import ex05.TransactionLinkedList.Node;;

public class TransactionService {
    private UsersArrayList _userList = new UsersArrayList();
    private TransactionLinkedList _List = new TransactionLinkedList();

    public User addUser(String name, int balance) {
        final User user = this._userList.addUser(name, balance); 
        return user; 
    }
    public int getBalance(int id) throws UserNotFoundException {
        return this._userList.retrieveById(id).getBalance();
    }
    public User getUserById(int id) throws UserNotFoundException { return this._userList.retrieveById(id); }

    public void print() { this._List.printList(); }

    public void transfer(int recID, int sendID, int amount) throws UserNotFoundException {
        User recipient = this._userList.retrieveById(recID);
        User sender = this._userList.retrieveById(sendID);

        if (sender.getBalance() < amount) {
            throw new IllegalTransactionException("Not enought money!");
        }
        recipient.add(amount);
        sender.decrease(amount);
        Transaction transaction = new Transaction();
        transaction.setTransaction(sendID, recID, amount);
        Transaction newTransaction = new Transaction(transaction);
        this._List.addTransaction(newTransaction);
        recipient.getUserTransactions().addTransaction(transaction.setCategory(true));
        sender.getUserTransactions().addTransaction(transaction.setCategory(false));
    }

    public Transaction[] getTransfer(int id) throws UserNotFoundException {
        return this._userList.retrieveById(id).getUserTransactions().transformToArray();
    }

    public Transaction removeTransactions(int userID, UUID id) throws UserNotFoundException {
        System.out.println(userID);
        User user = this._userList.retrieveById(userID);
        Node tmp = this._List.getTransactionById(id);
        System.out.println(tmp);
        Transaction ret = tmp.getData();
        user.getUserTransactions().removeTransactionById(id);
        if (tmp.data.getRecipient() == userID) {
            tmp.data.setRecipient();
        } else {
            tmp.data.setSender();
        }
        return ret;
    }

    public Transaction[] checkValidity() throws UserNotFoundException {
        Transaction[] transactions = this._List.transformToArray();
        int size = this._List.getSize();
        for (int i = 0; transactions[i] != null; i++) {
            if (transactions[i].getRecipient() != 0 && transactions[i].getSender() != 0) {
                transactions[i] = null;
                transactions[size--] = transactions[i]; 
            }
        }
        return transactions;
    }

    private class IllegalTransactionException extends RuntimeException {
        public IllegalTransactionException(String msg) {
            super ("\n" + msg + "\n");
        }
        
    }
}
