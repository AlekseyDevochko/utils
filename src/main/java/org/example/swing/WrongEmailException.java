package org.example.swing;

public class WrongEmailException extends Exception{

    public WrongEmailException(){
        super("Wrong email address!");
    }

    public WrongEmailException(String message){
        super(message);
    }
}
