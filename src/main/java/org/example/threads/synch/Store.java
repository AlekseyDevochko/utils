package org.example.threads.synch;


import org.example.threads.ThreadUtils;

class ProducerConsumerTask {
    public static void main(String[] args) {
        Store store = new Store();

        new Producer(store).start();
        new Consumer(store).start();

    }
}

public class Store {

    private int counter = 0; // num of prod
    private int max = 5; // max num of prod


    // producer method
    synchronized int put(){
        if (counter < max){
            counter++;
            System.out.println("Store number of products: " + counter + "    | PUT");
            return 1;
        }
        return 0; // store is full
    }

    // consumer method
    synchronized int get(){
        if(counter > 0){
            counter--;
            System.out.println("Store number of products: " + counter + "    | GET");
            return 1;
        }
        return 0; // store is empty
    }


}



class Producer extends Thread {
    private Store store;
    private int product = 5;

    public Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while (product > 0){
            product -= store.put();
            System.out.println("Left to produce " + product + " (products)");
            ThreadUtils.delay(0.2);
        }
    }
}

class Consumer extends Thread {
    private Store store;
    private int product = 0;

    public Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        while (product < 5){
            product += store.get();
            System.out.println("Left to consume " + (5 - product) + " (products)");
            ThreadUtils.delay(0.1);
        }
    }
}
