package org.example.threads.synch;



import org.example.threads.ThreadUtils;






public class Library {

    private int books = 0;

    public Library(){
    }

    public synchronized void write(){
        while (books >= 7){
            ThreadUtils.logJob("Writer waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        books++;
        ThreadUtils.delay(0.2);
        ThreadUtils.logJob("Wrote new book");
        ThreadUtils.logJob("Lib products: " + books);

        notifyAll();

    }

    public synchronized void read(){
        while (books < 1){
            ThreadUtils.logJob("Reader waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        books--;
        ThreadUtils.logJob("Take new book");
        ThreadUtils.logJob("Lib products: " + books);
        ThreadUtils.delay(0.1);

        notify();
    }

}

class Reader implements Runnable {

    //private static int num = 0;

    private Library lib;

    public Reader(Library lib){
        this.lib = lib;
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();

        for (int i = 0; i < 5; i++) {

            lib.read();

        }

        ThreadUtils.logFinish();
    }
}

class Writer implements Runnable {

    //private static int num = 0;

    private Library lib;

    public Writer(Library lib){
        this.lib = lib;
    }

    @Override
    public void run() {
        ThreadUtils.logBegin();

        for (int i = 0; i < 15; i++) {

            lib.write();

        }

        ThreadUtils.logFinish();
    }
}


class TestLib {
    public static void main(String[] args) {
        Library lib = new Library();
        Thread r1 = new Thread(new Reader(lib));
        r1.setName("Reader1");
        r1.start();

        Thread r2 = new Thread(new Reader(lib));
        r2.setName("Reader2");
        r2.start();

        Thread r3 = new Thread(new Reader(lib));
        r3.setName("Reader1");
        r3.start();

        Thread w = new Thread(new Writer(lib));
        w.setName("Writer");
        w.start();
    }
}
