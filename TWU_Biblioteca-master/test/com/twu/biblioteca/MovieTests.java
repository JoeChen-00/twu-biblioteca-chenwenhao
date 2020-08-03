package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTests {

    @Test
    public void getTitleShouldReturnTitle() {
        Movie movie = new Movie("One day in TWU","Joechen","2020",10,"Librarian",true);

        String result = movie.getName();

        assertThat(result, is("One day in TWU"));
    }
}
