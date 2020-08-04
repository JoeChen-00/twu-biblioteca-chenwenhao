package com.twu.biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        Library myTest = new Library();
        myTest.initTest();
        Customer user = null;
        while (user==null){
            user = myTest.loginLibrary();
        }
        while(myTest.userServiceHandler(user));
    }
}
