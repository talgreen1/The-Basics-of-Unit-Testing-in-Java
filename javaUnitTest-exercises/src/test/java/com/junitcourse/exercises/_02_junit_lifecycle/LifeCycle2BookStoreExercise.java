package com.junitcourse.exercises._02_junit_lifecycle;

import com.junitcourse._01_unit_test_and_tdd.Book;
import com.junitcourse._01_unit_test_and_tdd.BookStore;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("Duplicates")
/**
 * Change the code to create 2 final books once, before the very first test.
 * These books should be used by all the tests.
 *
 * Change the code to create new empty book store before each test
 */
public class LifeCycle2BookStoreExercise {


    @Test
    public void getBookCount() {
        //Given - Create book store and 2 books
        BookStore store = new BookStore();
        Book b1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
        Book b2 = new Book(2, "Harry Potter", "J. K. Rowling", 1997);

        //When adding 1 book
        store.addBook(b1);

        //Then - count of books is 1
        assertThat(store.getBookCount()).isEqualTo(1);

        //When adding another book
        store.addBook(b2);

        //Then - count of books is 2
        assertThat(store.getBookCount()).isEqualTo(2);

        //When trying to add existing book again
        store.addBook(b1);

        //Then - number of books is still 2
        assertThat(store.getBookCount()).isEqualTo(2);

    }
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