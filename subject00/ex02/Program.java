import java.util.Scanner;

public class Program {

    public static boolean isPrime(int n) {
        if (n <= 0) {
            System.err.println("IllegalArgument\n");
        }

        int i = 2;
        while (i < n) {
            if (n % i == 0 || n % 2 == 0 || n == 1) {
                return false;
            } else if (i * i > n) {
                return true;
            }
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int primes = 0;
        while (true) {
            System.out.print("-> ");
            int n = input.nextInt();
            int tot = 0;
            if (n == 42) {
                break ;
            }
            while (n > 0) {
                tot += n % 10;
                n /= 10;
            }
            if (isPrime(tot)) {
                primes++;
            }
        }
        System.out.println("Count of coffee-request - " + primes);
    }
    
}
