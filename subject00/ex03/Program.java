import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int week = 1;
        int tot = 0;
        int lowest = 10;
        input.useDelimiter("");
        while (week <= 18) {
            System.out.print("-> ");
            String word = input.nextLine();
            if (word.equals("42")) {
                tot /= 10;
                break ;
            }
            if (!word.equals("Week " + week++)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            System.out.print("-> ");
            int i = 0;
            while (input.hasNext()) {
                final int in = input.nextInt();
                if (in > 9 && in < 0) {
                    System.err.println("Grades must be betweens 0 and 9");
                    System.exit(-1);
                } else {
                    lowest = in < lowest ? in : lowest;
                }
                final String sep = input.next();
                if (sep.equals("\n")) {
                    break ;
                }
                if (!sep.equals(" ")) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                i++;
            }
            if (i != 4) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            tot += lowest;
            if (week == 18) {
                break;
            }
            tot *= 10;
            lowest = 10;
        }
        int reverse = 0;
        while (tot > 0) {
            reverse += tot % 10;
            tot /= 10;
            if (tot != 0) {
                reverse *= 10;
            }
        }
        week = 1;
        for (; reverse > 0; reverse /= 10) {
            int size = reverse % 10;
            System.out.print("Week " + week++ + " ");
            while (size-- > 0) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }
}
