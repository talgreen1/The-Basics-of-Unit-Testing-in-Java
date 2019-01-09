package com.junitcourse._05_tdd;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.Assert.*;

public class BookStoreTest {
    @Test
    public void Given_empty_store_When_filtering_by_a_name_Then_get_empty_list(){
        BookStore store = new BookStore();
        List<Book> res =  store.filterByName("a", false);

        assertThat(res).isEmpty();
    }

    @Test
    public void Given_store_with_books_When_filtering_by_partial_name_Then_all_mathced_books_returned(){
        BookStore store = new BookStore();
        Book b1 = new Book(1, "flatland", "a", 1800);
        Book b2 = new Book(2, "Harry Potter", "a", 1810);
        Book b3 = new Book(3, "flatland 2", "a", 1830);

        store.addBook(b1);
        store.addBook(b2);
        store.addBook(b3);

        List<Book> res = store.filterByName("flatland", false);

        assertThat(res).containsExactlyInAnyOrder(b1,b3);
    }

    @Test
    public void Given_store_with_books_When_filtering_by_regex_Then_all_mathced_books_returned(){
        BookStore store = new BookStore();
        Book b1 = new Book(1, "flatland", "a", 1800);
        Book b2 = new Book(2, "Harry Potter", "a", 1810);
        Book b3 = new Book(3, "flatland 2", "a", 1830);

        store.addBook(b1);
        store.addBook(b2);
        store.addBook(b3);

        List<Book> res = store.filterByName(".*fla.*", true);

        assertThat(res).containsExactlyInAnyOrder(b1,b3);
    }

    @Test
    public void Given_store_with_books_When_filtering_by_unknown_name_Then_empty_list_returned(){
        BookStore store = new BookStore();
        Book b1 = new Book(1, "flatland", "a", 1800);

        store.addBook(b1);

        List<Book> res = store.filterByName("dddddd", false);

        assertThat(res).isEmpty();
    }
}