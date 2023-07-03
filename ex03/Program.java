import java.util.Scanner;

public class Program {

    public static char[] get_word(Scanner input, int size) {
        char[] ret = new char[size];
        int i = 0;
        while(input.hasNext()) {
            ret[i] = input.next().charAt(0);
            if (i > 1 && ret[0] == '4' && ret[1] == '2') {
                return null;
            }
            if (ret[i] == '\n') {
                return ret;
            }
            i++;
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int week = 1;
        int tot = 0;
        int lowest = 10;
        input.useDelimiter("");
        while (true) {
            System.out.print("-> ");
            char[] word = get_word(input, 7);
            if (word == null) {
                break ;
            }
            if (word.equals("Week " + (char)week++)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            System.out.print("-> ");
            char[] grades = get_word(input, 10);
            for (int i = 0; i < 10; i += 2) {
                int n = (grades[i]) - 48;
                if (n < lowest) {
                    lowest = n;
                }
            }
            tot += lowest;
            tot *= 10;
            lowest = 10;
            word = new char[0];
            grades = new char[0];
        }
        System.out.println(tot);
    }
}
