package ex00;

public class myThread implements Runnable {
    private String _name;
    private Thread t;
    private int _count;

    public myThread(String name, int count) {
        this._name = name;
        this._count = count;
    }

    public void run() {
        for (int i = 0; i < this._count; i++) {
            System.out.println(this._name + " " + i);
        }
    }

    public void start() {
        if (this.t == null) {
            t = new Thread(this, this._name);
            t.start();
        }
    }

}
