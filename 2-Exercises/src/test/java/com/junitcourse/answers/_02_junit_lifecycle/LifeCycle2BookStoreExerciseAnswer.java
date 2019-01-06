package com.junitcourse.answers._02_junit_lifecycle;

import com.junitcourse._901_unit_test_and_tdd.Book;
import com.junitcourse._901_unit_test_and_tdd.BookStore;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void Given_new_store_When_getting_book_count_Then_count_is_0() {
        //Given you have new book store

        //When you get it's book count
        int bookCount = bookStore.getBookCount();

        //Then it's book count is 0
        assertThat(bookCount).isEqualTo(0);
    }

    @Test
    public void Given_new_store_When_adding_book_Then_count_should_be_1_and_book_should_be_returned() {
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
    public void Given_new_store_When_trying_to_get_a_book_Then_null_is_returned() {
        //Given - new book store

        //When trying to get a book by ID
        Book result = bookStore.getBookById(1);

        //Then - You get null
        assertThat(result).isNull();
    }

    @Test
    public void Given_new_store_When_adding_book_Then_you_can_get_it_by_id() {
        //Given - new book store and new book

        //When adding the book to the book store and getting a book by the correct ID
        bookStore.addBook(book1);
        Book result = bookStore.getBookById(book1.getId());

        //Then you get the same book you've added before
        assertThat(result).isSameAs(book1);
    }

    @Test
    public void Given_store_with_book_When_getting_book_by_incorrect_id_Then_you_get_null() {
        //Given - book store with 1 book
        bookStore.addBook(book1);

        //When trying to get a book by incorrect ID
        Book result = bookStore.getBookById(book2.getId());

        //Then you get null
        assertThat(result).isNull();
    }

    @Test
    public void Given_store_with_2_books_When_getting_books_count_Then_get_2() {
        //Given store with 2 books
        bookStore.addBook(book1);
        bookStore.addBook(book2);

        //When getting the book count
        int count = bookStore.getBookCount();

        //Then - count is 2
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void Given_new_store_When_adding_same_book_twice_Then_count_is_1() {
        //Given new store

        // When adding the same book twice
        bookStore.addBook(book1);
        bookStore.addBook(book1);

        //Then - the count is 1
        int count = bookStore.getBookCount();
        assertThat(count).isEqualTo(1);
    }
}