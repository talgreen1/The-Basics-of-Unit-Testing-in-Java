package com.junitcourse._01_unit_test_and_tdd;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("Duplicates")
public class BookStoreTestExercise {


    @Test
    public void getBookCount() {
        Assert.fail("Need to design this test...");

    }
    @Test
    public void addBook() {
        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);

        Book result = store.addBook(b);

        // Verify that the store contains only 1 book
        assertThat(store.getBookCount()).isEqualTo(1);

        // Verify that the addBook method returns the added book
        assertThat(result).isSameAs(b);
    }

    @Test
    public void getBookById() {
        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
        Book result;

        result = store.getBookById(b.getId());
        assertThat(result).isNull();

        store.addBook(b);

        result = store.getBookById(b.getId());
        assertThat(result).isSameAs(b);

        result = store.getBookById(2);
        assertThat(result).isNull();

    }
}