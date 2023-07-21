package ex05;

import java.util.Scanner;
import java.util.UUID;

import ex05.UsersList.UserNotFoundException;

public class Menu {
    private TransactionService _transactionService;
    private String _dev = "1. Add a user\n2. View user balances\n3. Perform a transfer\n4. View all transactions for a specific user\n5. DEV - remove a transfer by ID\n6. DEV - check transfer validity\n7. Finish execution";
    private Scanner input = new Scanner(System.in);

    public Menu() {
        if (this._transactionService == null) {
            this._transactionService = new TransactionService();
        }
    }

    public void loop_dev() throws UserNotFoundException{
        System.out.println();
        while (true) {
            System.out.println(_dev);
            System.out.print("-> ");
            final int n = input.nextInt();
            switch (n) {
                case 1: {
                    System.out.println("Enter a user name and a balance");
                    System.out.print("-> ");
                    final String name = input.next();
                    final int balance = input.nextInt();
                    User user = this._transactionService.addUser(name, balance);
                    System.out.println("User with id = " + user.getID() + " is added");
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 2: {
                    System.out.println("Enter a user ID");
                    System.out.print("-> ");
                    final int id = input.nextInt();
                    System.out.println(this._transactionService.getUserById(id).getName() + " - " + this._transactionService.getBalance(id));
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 3: {
                    System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                    System.out.print("-> ");
                    final int sender = input.nextInt();
                    final int recipient = input.nextInt();
                    final int amount = input.nextInt();
                    this._transactionService.transfer(recipient, sender, amount);
                    System.out.println("The transfer is completed");
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 4: {
                    System.out.println("Enter a user ID");
                    System.out.print("-> ");
                    final int id = input.nextInt();
                    final Transaction[] transactions = this._transactionService.getTransfer(id);
                    for (int i = 0; transactions[i] != null; i++) {
                        User user = null;
                        char sign = '+';
                        if (transactions[i].getCat() == false) {
                            System.out.print("To ");
                            user = this._transactionService.getUserById(transactions[i].getRecipient());
                            sign = '-';
                        } else {
                            System.out.print("From ");
                            user = this._transactionService.getUserById(transactions[i].getSender());
                        }
                        System.out.println(user.getName() + "(id = " + user.getID() + ") " + sign + transactions[i].getAmount() + " with id = " + transactions[i].getTranID());
                    }
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 5: {
                    System.out.println("Enter a user ID and a transfer ID");
                    System.out.print("-> ");
                    final int id = input.nextInt();
                    final UUID uuid = UUID.fromString(input.next());
                    final Transaction toDel = this._transactionService.removeTransactions(id, uuid);
                    System.out.print("Transfer " );
                    User user = null;
                    if (toDel.getCat() == false) {
                        System.out.print("To ");
                        user = this._transactionService.getUserById(toDel.getRecipient());
                    } else {
                        System.out.print("From ");
                        user = this._transactionService.getUserById(toDel.getSender());
                    }
                    System.out.println(user.getName() + "(id = " + user.getID() +") " + toDel.getAmount() + " removed");
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 6: {
                    System.out.println("Check results:");
                    final Transaction[] check = this._transactionService.checkValidity();
                    for (int i = 0; check[i] != null; i++) {
                        final int id = check[i].getRecipient() == 0 ? check[i].getSender() : check[i].getRecipient();
                        final User user = this._transactionService.getUserById(id);
                        final Transaction transaction = user.getTransaction(check[i].getTranID());
                        final int otherId = transaction.getRecipient() == id ? transaction.getSender() : transaction.getRecipient();7
                        System.out.print(user.getName() + "(id = " + id + ") as an unacknowledged transfer id = " + check[i].getTranID());
                        String from_to = transaction.getRecipient() == id ? " from " : " to ";
                        System.out.print(from_to + this._transactionService.getUserById(otherId).getName() + "(id = " + otherId + ") for " + check[i].getAmount());
                    }
                    System.out.println("\n---------------------------------------------------------");
                    break ;
                }
                case 7:
                    System.exit(0);
                    break ;
                default: {
                    System.out.println("Please insert a number between 1 and 7");
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
            }
        }
    }

    public void loop_prod() throws UserNotFoundException{
        System.out.println();
        while (true) {
            System.out.println(_dev);
            System.out.print("-> ");
            final int n = input.nextInt();
            switch (n) {
                case 1: {
                    System.out.println("Enter a user name and a balance");
                    System.out.print("-> ");
                    final String name = input.next();
                    final int balance = input.nextInt();
                    User user = this._transactionService.addUser(name, balance);
                    System.out.println("User with id = " + user.getID() + " is added");
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 2: {
                    System.out.println("Enter a user ID");
                    System.out.print("-> ");
                    final int id = input.nextInt();
                    System.out.println(this._transactionService.getUserById(id).getName() + " - " + this._transactionService.getBalance(id));
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 3: {
                    System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                    System.out.print("-> ");
                    final int sender = input.nextInt();
                    final int recipient = input.nextInt();
                    final int amount = input.nextInt();
                    this._transactionService.transfer(recipient, sender, amount);
                    System.out.println("The transfer is completed");
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 4: {
                    System.out.println("Enter a user ID");
                    System.out.print("-> ");
                    final int id = input.nextInt();
                    final Transaction[] transactions = this._transactionService.getTransfer(id);
                    for (int i = 0; transactions[i] != null; i++) {
                        User user = null;
                        char sign = '+';
                        if (transactions[i].getCat() == false) {
                            System.out.print("To ");
                            user = this._transactionService.getUserById(transactions[i].getRecipient());
                            sign = '-';
                        } else {
                            System.out.print("From ");
                            user = this._transactionService.getUserById(transactions[i].getSender());
                        }
                        System.out.println(user.getName() + "(id = " + user.getID() + ") " + sign + transactions[i].getAmount() + " with id = " + transactions[i].getTranID());
                    }
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
                case 5:
                    System.exit(0);
                    break ;
                default: {
                    System.out.println("Please insert a number between 1 and 5");
                    System.out.println("---------------------------------------------------------");
                    break ;
                }
            }
        }
    }
}
