import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] students = new String[10];
        int i = 0;
        while (input.hasNext()) {
            if (i == 10) {
                System.err.println("Max 10 names!");
                System.exit(-1);
            }
            String in = input.nextLine();
            if (in.equals(".")) {
                break ;
            }
            if (in.length() > 10) {
                System.err.println("Name too long!");
                System.exit(-1);
            }
            students[i++] = in;
        }

        String[][] schedule = new String[10][2];
        int j = 0;
        while (input.hasNext()) {
            if (j == 10) {
                System.err.println("Max 10 classes!");
                System.exit(-1);
            }
            String time = input.next();
            if (time.equals(".")) {
                break ;
            }
            schedule[j][0] = time;
            String day = input.next();
            schedule[j][1] = day;
            j++;
        }

        String[][] records = new String[100][4];
        int k = 0;
        while (input.hasNext()) {
            String name = input.next();
            if (name.equals(".")) {
                break ;
            }
            records[k][0] = name;
            records[k][1] = input.next();
            records[k][2] = input.next();
            records[k][3] = input.next();
            if (!records[k][3].equals("HERE") && !records[k][3].equals("NOT_HERE")) {
                System.err.println("unrecognized argument, valid: HERE, NOT_HERE");
                System.exit(-1);
            }
            k++; 
        }

        String[] week = new String[] {"TU", "WE", "TH", "FR", "SA", "SU", "MO"};
        System.out.print("         ");
        for (int d = 0; d < 31; d++) {
            for (int n = 0; n < 7; n++) {
                for (int z = 0; z < j; z++) {
                    if (week[n].equals(schedule[z][1]) && d % 7 == n) {
                        System.out.print(schedule[z][0] + ":00 " + schedule[z][1]);
                        if (d < 10) {
                            System.out.print("  ");
                        } else {
                            System.out.print(" ");
                        }
                        System.out.print((d + 1) + "|");
                    }
                }    
            }
        }
        System.out.println();
        for (int n = 0; n < i; n++) {   // number of students
            for (int s = students[n].length(); s < 9; s++)
                System.out.print(" ");
            System.out.print(students[n]);
            for (int d = 0; d < 31; d++) { // number of days
                for (int e = 0; e < 7; e++) {
                    for (int z = 0; z < j; z++) {
                        if (week[e].equals(schedule[z][1]) && d % 7 == e) {
                            int m = 0;
                            for (m = 0; m < k; m++) { // number or records
                                if (students[n].equals(records[m][0])) {
                                    char[] tmp = records[m][2].toCharArray();
                                    int day = 0;
                                    for (int t = 0; t < records[m][2].length(); t++) {
                                        day += tmp[t] - 48;
                                        day *= 10;
                                    }
                                    if (day == (d + 1) * 10) {
                                        if (records[m][3].equals("HERE")) {
                                            System.out.print("         1|");
                                        } else {
                                            System.out.print("        -1|");
                                        }
                                        break ;
                                    }
                                }
                            }
                            if (m == k) {
                                System.out.print("          |");
                            }
                        }
                    }
                }    
            }
            System.out.println();    
        }
        System.out.println();
    }
}