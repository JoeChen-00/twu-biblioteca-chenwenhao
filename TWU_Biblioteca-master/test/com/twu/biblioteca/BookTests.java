package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTests {
    private Book book;

    @Before
    public void setUp() {
        this.book = new Book("Title", "Author", "2019","Librarian",true);
    }

    @Test
    public void getBookNameShouldReturnBookName() {
        //Act
        String result = book.getBookName();
        //Assert
        assertEquals("Title", result);
    }

    @Test
    public void getAuthorShouldReturnAuthor() {
        //Act
        String result = book.getAuthor();
        //Assert
        assertEquals("Author", result);
    }

    @Test
    public void getPublishedYearShouldReturnPublishedYear() {
        //Act
        String result = book.getPublishedYear();
        //Assert
        assertEquals("2019", result);
    }
}
