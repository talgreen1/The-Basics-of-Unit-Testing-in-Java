package com.junitcourse.answers._02_junit_lifecycle;

import com.junitcourse._01_unit_test_and_tdd.Book;
import com.junitcourse._01_unit_test_and_tdd.BookStore;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("Duplicates")
/**
 * Change the code to create 2 books once, before the very first test.
 * These books should be used by all the tests.
 *
 * Change the code to create new empty book store before each test
 */
public class LifeCycle2BookStoreExerciseAnswer {

    private static  Book book1;
    private static  Book book2;
    private BookStore bookStore;

    @BeforeClass
    public static void setup(){
        book1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
        book2 = new Book(2, "Harry Potter", "J. K. Rowling", 1997);
    }

    @Before
    public void createNewBookStore(){
        bookStore = new BookStore();
    }

    @Test
    public void getBookCount() {
        //Given - Create book store and 2 books

        //When adding 1 book
        bookStore.addBook(book1);

        //Then - count of books is 1
        assertThat(bookStore.getBookCount()).isEqualTo(1);

        //When adding another book
        bookStore.addBook(book2);

        //Then - count of books is 2
        assertThat(bookStore.getBookCount()).isEqualTo(2);

        //When trying to add existing book again
        bookStore.addBook(book1);

        //Then - number of books is still 2
        assertThat(bookStore.getBookCount()).isEqualTo(2);

    }
    @Test
    public void emptyStore() {
        //Given you have new book store

        //When you get it's book count
        int bookCount = bookStore.getBookCount();

        //Then it's book count is 0
        assertThat(bookCount).isEqualTo(0);
    }

    @Test
    public void addBook() {
        //Arrange:
        //1. Create new book store
        //2. Create new book


        // Act: Add the book to the book store
        Book result = bookStore.addBook(book1);

        // Assert that the store contains only 1 book
        assertThat(bookStore.getBookCount()).isEqualTo(1);

        // Assert that the addBook method returns the added book
        assertThat(result).isSameAs(book1);
    }

    @Test
    public void getBookById() {
        //Given - new book store and new book

        //When doing nothing

        //Then - you get null when trying to get a book by ID
        Book result;
        result = bookStore.getBookById(book1.getId());
        assertThat(result).isNull();

        //When adding the book to the book store and getting a book by the correct ID
        bookStore.addBook(book1);
        result = bookStore.getBookById(book1.getId());

        //Then you get the same book you've added before
        assertThat(result).isSameAs(book1);

        //When trying to get a book by incorrect ID
        result = bookStore.getBookById(book2.getId());

        //Then you get null
        assertThat(result).isNull();
    }
}