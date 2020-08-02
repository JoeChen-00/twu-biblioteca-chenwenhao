package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibliotecaApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        List<Book> Booklist = new ArrayList<Book>();
        Booklist.add(new Book("Chinese food","chenwenhao","2020",true));
        Booklist.add(new Book("Chinese KungFu","chenwenhao","2020",true));
        while(true){
            System.out.println("Here is our service menu! Please choose the function you want :)");
            System.out.println("1.show book list");
            System.out.println("2.check out book");
            System.out.println("3.return book");
            System.out.println("0.quit system");
            System.out.println("Please enter instructions[0-3]! Press the Enter to continue...");
            int menuchoose = inputCheck();
            if(menuchoose==0)
                break;
            switch(menuchoose){
                case 1:
                    showAllBook(Booklist);
                    break;
                case 2:
                    checkOutBook(Booklist);
                    break;
                case 3:
                    returnBook(Booklist);
                    break;
                default:
                    System.out.println("None service found! Please check again");
                    break;
            }
        }
    }

    public static void showAllBook(List<Book> Booklist){
        //assume that we have list
        System.out.println("there is the book list:");
        for(Book a:Booklist){
            if(a.isAvailable())
                a.showInfoOfBook();
        }
    }

    public static void checkOutBook(List<Book> Booklist) {
        System.out.println("Please enter name of book:");
        Scanner input = new Scanner(System.in);
        String val = null;
        val = input.nextLine();
        for (Book a : Booklist) {
            if (val.contains(a.checkBookName())) {
                if (a.isAvailable()) {
                    System.out.println("Thank you! Enjoy the book");
                    a.changeAvailable(false);
                    return;
                } else {
                    System.out.println("Sorry, that book is not available");
                    return;
                }
            }
        }
        System.out.println("Sorry, can not find this book named:" + val);
    }

    public static void returnBook(List<Book> Booklist){
        System.out.println("Please enter name of book:");
        Scanner input = new Scanner(System.in);
        String val = null;
        val = input.nextLine();
        for (Book a : Booklist) {
            if (val.contains(a.checkBookName())) {
                System.out.println("Thank you for returning the book");
                a.changeAvailable(true);
                return;
            }
        }
        System.out.println("That is not a valid book to return");
    }

    public static int inputCheck(){
        Scanner input = new Scanner(System.in);
        String val = null;
        val = input.next();
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) val);
        while (!matcher.matches()){
            System.out.println("Please enter right number...");
            val = input.next();
            matcher = pattern.matcher((CharSequence)val);
        }
        return Integer.parseInt(val);
    }
}
