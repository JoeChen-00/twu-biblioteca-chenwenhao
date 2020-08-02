package com.twu.biblioteca;

import java.time.Year;

public class Book {
    private String Author;
    private String PublishedYear;
    private String BookName;
    private Boolean Available;
    Book(){}
    Book(String name,String author,String publishedYear,boolean available){
        this.BookName = name;
        this.Author = author;
        this.PublishedYear = publishedYear;
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
    public Boolean isAvailable(){
        return this.Available;
    }
    public void changeAvailable(Boolean available){
        this.Available = available;
    }
    public String checkBookName(){
        return this.BookName;
    }
}
