package com.junitcourse.answers._01_unit_test_and_tdd;

import com.junitcourse._901_unit_test_and_tdd.Book;
import com.junitcourse._901_unit_test_and_tdd.BookStore;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("Duplicates")
public class BookStoreTestExerciseAnswer {
    /*
        Design 2 unit tests. For each test give meaningful name
        and write comments inside it for the different test parts.
        If you want - you can write the actual test code.

        The 2 tests are:
        1. Test the count after adding 2 books
        2. Test the count after adding the same book twice
    */

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