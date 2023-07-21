package ex03;

public class Program {

	static public void	main(String[] args) {
	
		User				bob = new User("bob", 250);
		User				john = new User("jhon", 300);

		System.out.println(bob.toString());
		System.out.println(john.toString());


		Transaction			transaction = new Transaction(bob.getID(), john.getID(), 20);
		Transaction			transaction2 = new Transaction(bob.getID(), john.getID(), -120);
		Transaction			transaction3 = new Transaction(john.getID(), bob.getID(), 50);

		System.out.println("\n" + bob.toString());
		System.out.println(john.toString() + "\n");

		Transaction bobList[] = bob.getUserTransactions().transformToArray();
		Transaction johnList[] = john.getUserTransactions().transformToArray();


		for(int i = 0; i < bobList.length; i++)
			System.out.println(bobList[i].toString());
		System.out.println();
		for(int i = 0; i < johnList.length; i++)
			System.out.println(johnList[i].toString());

		System.out.println();
		bob.getUserTransactions().removeTransactionById(transaction.getTranID());
		bob.getUserTransactions().removeTransactionById(transaction2.getTranID());
		john.getUserTransactions().removeTransactionById(transaction3.getTranID());
		bobList = bob.getUserTransactions().transformToArray();
		johnList = john.getUserTransactions().transformToArray();

		for(int i = 0; i < bobList.length; i++)
			System.out.println(bobList[i].toString());
		System.out.println();
		for(int i = 0; i < johnList.length; i++)
			System.out.println(johnList[i].toString());

	}
}