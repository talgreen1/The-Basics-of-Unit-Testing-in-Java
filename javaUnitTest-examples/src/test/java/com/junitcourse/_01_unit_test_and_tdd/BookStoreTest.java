package com.junitcourse._01_unit_test_and_tdd;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("Duplicates")
public class BookStoreTest {

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

}