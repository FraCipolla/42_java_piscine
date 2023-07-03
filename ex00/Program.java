public class Program {
    public static void main(String[] args) {
        int number = 479598;
        int total = 0;
    
        while (number > 0) {
            total += number % 10;
            number /= 10;
        }
    
        System.out.println(total);
    }
}
