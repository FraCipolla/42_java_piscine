package ex02;
public class Program {

	static public void	main(String[] args) {
		
		UsersArrayList usersAr = new UsersArrayList();

		System.out.println("Array size = " + usersAr.nUser());
		System.out.println("Adding Bob to the array");
		usersAr.addUser("bob", 100);
		System.out.println("Array size = " + usersAr.nUser());
		
		System.out.println("Printing user ad position 1");
		System.out.println(usersAr.retrieveByIndex(0));
		
		System.out.println("Adding John to the array");
		usersAr.addUser("John", 100);
		System.out.println("Array size = " + usersAr.nUser());
		
		System.out.println("Adding multiple users to check array size increase");
		
		System.out.println("Starting max capacity " + usersAr.getCapacity());
		int current = usersAr.getCapacity();
        for (int i = 0; i < 50; i++) {
			if (usersAr.nUser() == current) {
				System.out.println("Array size = " + usersAr.nUser());
				System.out.println("Total Capacity = " + usersAr.getCapacity());
				current = usersAr.getCapacity();
			}
			usersAr.addUser("Carlo" + i, 10);
        }

		
		System.out.println("Printing user ad position 1000 - ginving error");
		System.out.println(usersAr.retrieveByIndex(1000));
	}
}