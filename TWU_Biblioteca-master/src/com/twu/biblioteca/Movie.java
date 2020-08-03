package com.twu.biblioteca;

public class Movie {
    private String Director;
    private String PublishedYear;
    private String Name;
    private int Rating;
    private Boolean Available;
    Movie(){}
    Movie(String name,String director,String publishedYear,int rating,boolean available){
        this.Name = name;
        this.Director = director;
        this.PublishedYear = publishedYear;
        this.Rating = rating;
        this.Available = available;
    }
    public void writeInfoOfMovie(String name,String director,String publishedYear,int rating,boolean available){
        this.Name = name;
        this.Director = director;
        this.PublishedYear = publishedYear;
        this.Rating = rating;
        this.Available = available;
    }
    public void showInfoOfMovie(){
        System.out.println("Movie Name:"+this.Name);
        System.out.println("Author:"+this.Director);
        System.out.println("Published Year:"+this.PublishedYear);
        System.out.println("Movie Rating:"+this.Rating);
    }
    public Boolean isAvailable(){
        return this.Available;
    }
    public void changeAvailable(Boolean available){
        this.Available = available;
    }
    public String checkMovieName(){
        return this.Name;
    }
}
