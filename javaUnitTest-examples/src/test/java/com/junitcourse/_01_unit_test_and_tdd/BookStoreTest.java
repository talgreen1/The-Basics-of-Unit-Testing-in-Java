package com.junitcourse._01_unit_test_and_tdd;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
@SuppressWarnings("Duplicates")
public class BookStoreTest {

    @Test
    public void emptyStore() {
        //Given you have new book store
        BookStore store = new BookStore();

        //When you get it's book count
        int bookCount = store.getBookCount();

        //Then it's book count is 0
        assertThat(bookCount).isEqualTo(0);
    }

    @Test
    public void addBook() {
        //Arrange:
        //1. Create new book store
        //2. Create new book

        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);

        // Act: Add the book to the book store
        Book result = store.addBook(b);

        // Assert that the store contains only 1 book
        assertThat(store.getBookCount()).isEqualTo(1);

        // Assert that the addBook method returns the added book
        assertThat(result).isSameAs(b);
    }

    @Test
    public void getBookById() {
        //Given - new book store and new book
        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);

        //When doing nothing

        //Then - you get null when trying to get a book by ID
        Book result;
        result = store.getBookById(b.getId());
        assertThat(result).isNull();

        //When adding the book to the book store and getting a book by the correct ID
        store.addBook(b);
        result = store.getBookById(b.getId());

        //Then you get the same book you've added before
        assertThat(result).isSameAs(b);

        //When trying to get a book by incorrect ID
        result = store.getBookById(2);

        //Then you get null
        assertThat(result).isNull();
    }

}