package com.junitcourse._04_unit_tests;

import com.junitcourse._04_unit_tests.Book;
import com.junitcourse._04_unit_tests.BookStore;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("Duplicates")
public class Exe06_BookStoreTest_Answer {

    /*----------------------------------
     |   getBookCount() tests
     ----------------------------------*/

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
    public void Given_store_with_one_book_When_getting_book_count_Then_count_is_1() {
        //Given you have store with 1 book
        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
        store.addBook(b);

        //When you get it's book count
        int bookCount = store.getBookCount();

        //Then it's book count is 1
        assertThat(bookCount).isEqualTo(1);
    }


    /*----------------------------------
     |   addBook(Book book) tests
     ----------------------------------*/
    @Test
    public void Given_new_store_When_adding_new_book_Then_count_should_be_1_and_book_should_be_returned() {
        //Arrange:
        //1. Create new book store
        //2. Create new book

        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);

        // Act: Add the book to the book store
        Book result = store.addBook(b);

        // Assert that the store contains 1 book
        AssertionsForClassTypes.assertThat(store.getBookCount()).isEqualTo(1);

        // Assert that the addBook method returned the added book
        assertThat(result).isSameAs(b);
    }

    @Test
    public void Given_store_with_one_book_When_adding_the_same_book_Then_count_should_be_1_and_null_should_be_returned() {
        BookStore store = new BookStore();
        Book b = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);

        store.addBook(b);
        Book result = store.addBook(b);

        AssertionsForClassTypes.assertThat(store.getBookCount()).isEqualTo(1);

        assertThat(result).isNull();
    }

    @Test
    public void Given_store_with_one_book_When_adding_new_book_Then_count_should_be_2_and_new_book_should_be_returned() {
        BookStore store = new BookStore();
        Book b1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
        Book b2 = new Book(2, "The Hobbit 2", "J. R. R. Tolkien", 1940);

        store.addBook(b1);
        Book result = store.addBook(b2);

        AssertionsForClassTypes.assertThat(store.getBookCount()).isEqualTo(2);

        assertThat(result).isSameAs(b2);
    }



}