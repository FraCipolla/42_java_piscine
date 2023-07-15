import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("->");
        String world = input.nextLine();
        if (world.length() > 999) {
            System.err.println("Invalid Argument");
            System.exit(-1);
        }

        int[] unicode_BMP = new int[65535];
        char[] top_ten = new char[10];
        char[] array = world.toCharArray();
        for (int i = 0; i < world.length(); i++) {
            unicode_BMP[array[i]] += 1;
            int min = 0;
            for (int j = 0; j < 10; j++) {
                if (array[i] == top_ten[j]) {
                    min = -1;
                    break ;
                } else if (unicode_BMP[top_ten[j]] < unicode_BMP[top_ten[min]]) {
                    min = j;
                }
            }
            if (min != -1 && unicode_BMP[top_ten[min]] < unicode_BMP[array[i]]) {
                top_ten[min] = array[i];
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if ((unicode_BMP[top_ten[i]] < unicode_BMP[top_ten[i + 1]]) ||
                (unicode_BMP[top_ten[i]] == unicode_BMP[top_ten[i + 1]] && top_ten[i] > top_ten[i + 1])) {
                top_ten[i] ^= top_ten[i + 1];
                top_ten[i + 1] ^= top_ten[i];
                top_ten[i] ^= top_ten[i + 1];
                i = -1;
            }
        }
        System.out.println();
        float max = unicode_BMP[top_ten[0]];
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 10; i++) {
                if (top_ten[i] == 0) {
                    break;
                }
                float percent = (100 / max) * unicode_BMP[top_ten[i]];
                if (percent - (100 - j * 10) >= 0 && percent - (100 - j * 10) < 10) {
                    if (unicode_BMP[top_ten[i]] < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(unicode_BMP[top_ten[i]] + " ");
                } else if (j != 11 && percent > 100 - j * 10) {
                    System.out.print(" # ");
                } else if (j == 11) {
                    System.out.print(" " + top_ten[i] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
