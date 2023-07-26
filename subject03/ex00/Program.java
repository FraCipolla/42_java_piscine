package ex00;

public class Program {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error: need one argument");
            System.exit(-1);
        }
        final String[] split = args[0].split("=");
        if (!split[0].equals("--count")) {
            System.out.println("Error: wrong input. Please insert '--count=n'");
            System.exit(-1);
        }
        if (split.length < 2) {
            System.out.println("Error: wrong input. Please insert '--count=n'");
            System.exit(-1);
        }
        int count = Integer.parseInt(split[1]);
        myThread thread1 = new myThread("Egg", count);
        myThread thread2 = new myThread("Hen", count);
        Thread t1 = new Thread(thread1);
        t1.start();
        Thread t2 = new Thread(thread2);
        t2.start();

        for (int i = 0; i < count; i ++) {
            System.out.println("Human");
        }
    }
}
