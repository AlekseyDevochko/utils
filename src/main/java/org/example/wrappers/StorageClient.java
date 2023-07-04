package org.example.wrappers;

public class StorageClient {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        Storage storage1 = new Storage(1);
        Storage storage2 = new Storage(512);
        storage1.add(64);
        storage1.add(512);
        storage1.add(72);
        storage1.add(55);
        storage1.add(-3);

        System.out.println("first " + storage1.getFirst());
        System.out.println("last " + storage1.getLast());

        System.out.println("get " + storage1.get(2));
        System.out.println("END");
    }
}
