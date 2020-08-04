package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library {
    private List<Book> Booklist = new ArrayList<Book>();
    private List<Movie> Movielist = new ArrayList<Movie>();
    private List<Customer> Customerlist = new ArrayList<Customer>();

    public void initTest(){
        System.out.println("Test data has loaded");
        Customerlist.add(new Customer("Joe","123456","chen","wenhao.chen@thoughtworks.com","15907130615",true));
        Customerlist.add(new Customer("Joechen01","123456","chen","wenhao.chen@thoughtworks.com","15907130615",false));
        Booklist.add(new Book("Chinese food","chenwenhao","2020","Librarian",true));
        Booklist.add(new Book("Chinese KungFu","chenwenhao","2020","Librarian",true));
        Movielist.add(new Movie("One day in TWU","Joechen","2020",10,"Librarian",true));
        Movielist.add(new Movie("other day in TWU","Joechen","2020",9,"Librarian",true));
    }

    public Customer loginLibrary(){
        Customer customer = null;
        System.out.println("Username:");
        Scanner input = new Scanner(System.in);
        String Username = input.nextLine();
        System.out.println("Password:");
        String Password = input.nextLine();
        for(Customer a:Customerlist){
            if(a.getUserName().equals(Username)){
                customer = a;
                break;
            }
        }
        if(customer==null)
            System.out.println("User doesn't exist");
        else if(customer.signIn(Password))
            return customer;
        else
            System.out.println("Wrong password");
        return customer;
    }

    public int userServiceSelect(Customer customer){
        System.out.println("Here is our service menu! Please choose the function you want :)");
        System.out.println("1.show book list");
        System.out.println("2.check out book");
        System.out.println("3.return book");
        System.out.println("4.show movie list");
        System.out.println("5.check out movie");
        System.out.println("6.return movie");
        System.out.println("7.check borrow list(only for Librarian)");
        System.out.println("0.quit system");
        System.out.println("Please enter instructions[0-7]! Press the Enter to continue...");
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

    public boolean userServiceHandler(Customer customer){
        switch(userServiceSelect(customer)){
            case 1:
                showAllBook(Booklist);
                break;
            case 2:
                checkOutBook(Booklist,customer);
                break;
            case 3:
                returnBook(Booklist);
                break;
            case 4:
                showAllMovie(Movielist);
                break;
            case 5:
                checkOutMovie(Movielist,customer);
                break;
            case 6:
                returnMovie(Movielist);
                break;
            case 7:
                if(customer.getIsRoot())
                    showCheckOutList(Booklist,Movielist);
                else
                    System.out.println("permission denied!");
                break;
            case 0:
                return false;
            default:
                System.out.println("None service found! Please check again");
                break;
        }
        return true;
    }

    public static void showCheckOutList(List<Book> Booklist,List<Movie> MovieList){
        //assume that we have list
        System.out.println("there is the borrow list:");
        for(Book a:Booklist){
            if(!a.isAvailable()){
                a.showInfoOfBook();
                a.showInfoOfHolder();
            }
        }
        for(Movie a:MovieList){
            if(!a.isAvailable()){
                a.showInfoOfMovie();
                a.showInfoOfHolder();
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

    public static void checkOutBook(List<Book> Booklist,Customer customer) {
        System.out.println("Please enter name of book:");
        Scanner input = new Scanner(System.in);
        String val = null;
        val = input.nextLine();
        for (Book a : Booklist) {
            if (val.contains(a.checkBookName())) {
                if (a.isAvailable()) {
                    System.out.println("Thank you! Enjoy the book");
                    a.changeAvailable(customer.getUserName(),false);
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
                a.changeAvailable("Librarian",true);
                return;
            }
        }
        System.out.println("That is not a valid book to return");
    }

    public static void showAllMovie(List<Movie> list){
        //assume that we have list
        System.out.println("there is the movie list:");
        for(Movie a:list){
            if(a.isAvailable())
                a.showInfoOfMovie();
        }
    }

    public static void checkOutMovie(List<Movie> list,Customer customer) {
        System.out.println("Please enter name of movie:");
        Scanner input = new Scanner(System.in);
        String val = null;
        val = input.nextLine();
        for (Movie a : list) {
            if (val.contains(a.checkMovieName())) {
                if (a.isAvailable()) {
                    System.out.println("Thank you! Enjoy the movie");
                    a.changeAvailable(customer.getUserName(),false);
                    return;
                } else {
                    System.out.println("Sorry, that movie is not available");
                    return;
                }
            }
        }
        System.out.println("Sorry, can not find this movie named:" + val);
    }

    public static void returnMovie(List<Movie> list){
        System.out.println("Please enter name of Movie:");
        Scanner input = new Scanner(System.in);
        String val = null;
        val = input.nextLine();
        for (Movie a : list) {
            if (val.contains(a.checkMovieName())) {
                System.out.println("Thank you for returning the Movie");
                a.changeAvailable("Librarian",true);
                return;
            }
        }
        System.out.println("That is not a valid Movie to return");
    }
}
