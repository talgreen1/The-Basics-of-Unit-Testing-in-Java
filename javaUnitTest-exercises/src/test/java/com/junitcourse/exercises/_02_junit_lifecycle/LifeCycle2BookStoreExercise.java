package com.junitcourse.exercises._02_junit_lifecycle;

import com.junitcourse._01_unit_test_and_tdd.Book;
import com.junitcourse._01_unit_test_and_tdd.BookStore;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("Duplicates")
/**
 * Change the following unit test code:
 * - Create 2 books once, before the very first test.
 *   These books should be used by all the tests.
 *
 * - Create new empty book store before each test. Use it in all tests
 */
public class LifeCycle2BookStoreExercise {


    @Test
    public void Given_new_store_When_getting_book_count_Then_count_is_0() {
        //Given you have new book store
        BookStore store = new BookStore();

        //When you get it's book count
        int bookCount = store.getBookCount();

        //Then it's book count is 0
        assertThat(bookCount).isEqualTo(0);
    }

    @Test
    public void Given_new_store_When_adding_book_Then_count_should_be_1_and_book_should_be_returned() {
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
    public void Given_new_store_When_trying_to_get_a_book_Then_null_is_returned() {
        //Given - new book store
        BookStore store = new BookStore();

        //When trying to get a book by ID
        Book result = store.getBookById(1);

        //Then - You get null
        assertThat(result).isNull();
    }

    @Test
    public void Given_new_store_When_adding_book_Then_you_can_get_it_by_id() {
        //Given - new book store and new book
        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);

        //When adding the book to the book store and getting a book by the correct ID
        store.addBook(b);
        Book result = store.getBookById(b.getId());

        //Then you get the same book you've added before
        assertThat(result).isSameAs(b);
    }

    @Test
    public void Given_store_with_book_When_getting_book_by_incorrect_id_Then_you_get_null() {
        //Given - book store with 1 book
        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
        store.addBook(b);

        //When trying to get a book by incorrect ID
        Book result = store.getBookById(2);

        //Then you get null
        assertThat(result).isNull();
    }

    @Test
    public void Given_store_with_2_books_When_getting_books_count_Then_get_2() {
        //Given store with 2 books
        BookStore store = new BookStore();
        store.addBook(new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937));
        store.addBook(new Book(2, "Harry Potter", "J. K. Rowling", 1997));

        //When getting the book count
        int count = store.getBookCount();

        //Then - count is 2
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void Given_new_store_When_adding_same_book_twice_Then_count_is_1() {
        //Given new store
        BookStore store = new BookStore();

        // When adding the same book twice
        Book book = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
        store.addBook(book);
        store.addBook(book);

        //Then - the count is 1
        int count = store.getBookCount();
        assertThat(count).isEqualTo(1);
    }
}