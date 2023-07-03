import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("-> ");

        int n = input.nextInt();

        if (n <= 0) {
            System.err.println("IllegalArgument\n");
        }
        int steps = 0;
        int i = 2;
        while (i < n) {
            steps++;
            if (n % i == 0 || n % 2 == 0) {
                System.out.println("false " + steps);
                return ;
            } else if (i * i > n) {
                System.out.println("true " + steps);
                return ;
            }
            i++;
        }
        System.out.println(n == 1 ? "false " + steps : "true " + steps);
    }
}