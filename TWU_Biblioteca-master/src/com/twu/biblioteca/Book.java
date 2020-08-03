package com.twu.biblioteca;

import java.time.Year;

public class Book {
    private String Author;
    private String PublishedYear;
    private String BookName;
    private Boolean Available;
    private String Holder;

    Book(String name,String author,String publishedYear,String holder,boolean available){
        this.BookName = name;
        this.Author = author;
        this.PublishedYear = publishedYear;
        this.Holder = holder;
        this.Available = available;
    }
    public void writeInfoOfBook(String name,String author,String publishedYear,boolean available){
        this.BookName = name;
        this.Author = author;
        this.PublishedYear = publishedYear;
        this.Available = available;
    }
    public void showInfoOfBook(){
        System.out.println("Book Name:"+this.BookName);
        System.out.println("Author:"+this.Author);
        System.out.println("Published Year:"+this.PublishedYear);
    }
    public void showInfoOfHolder(){
        System.out.println("holder:"+this.Holder);
    }
    public Boolean isAvailable(){
        return this.Available;
    }
    public void changeAvailable(String holder,Boolean available){
        this.Holder = holder;
        this.Available = available;
    }
    public String checkBookName(){
        return this.BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public String getBookName() {
        return BookName;
    }

    public String getHolder() {
        return Holder;
    }

    public String getPublishedYear() {
        return PublishedYear;
    }
}
