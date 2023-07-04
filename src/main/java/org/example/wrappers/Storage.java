package org.example.wrappers;

//import sun.plugin.dom.exception.InvalidAccessException;

import java.util.Arrays;


public class Storage {

    private static final int DEFAULT_SIZE = 32;
    private static final int INTEGER_ZERO = 0;
    private static final int EXTRA_SIZE = 64;
    private int index;
    private int [] data;

    public Storage() {
        this.data = new int[DEFAULT_SIZE];
    }

    public Storage(int size) {
        this.data = new int[size];
    }

    public void add(int value){
        ensureCapacity();
        data[this.index] = value;

    }

    private void ensureCapacity(){
        if (data.length - index <= 0){
            this.data = Arrays.copyOf(this.data, EXTRA_SIZE + this.data.length);
        }
    }

    public int get(int index){
        if (index < INTEGER_ZERO || index >= this.index){
            throw new IndexOutOfBoundsException();
        } else {
            return data[index];
        }

    }

    public int getFirst(){
        return data[INTEGER_ZERO];

    }

    public int getLast(){
        return data[this.index - 1];
    }


    public void replace(int value, int index){
        if (index < INTEGER_ZERO || index >= this.index) {

            throw new IndexOutOfBoundsException();
        } else {
            data[index] = value;
        }
    }

    public int length(){
        return --this.index;
    }
}
