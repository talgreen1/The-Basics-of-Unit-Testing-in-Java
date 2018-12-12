package com.junitcourse.answers._05_final_exercise;

import com.junitcourse._04_final_exercies.Book;
import com.junitcourse._04_final_exercies.BookStore;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GetBooksByAuthorTests {
    private static final Book BOOK1 = new Book(1, "Harry Potter and the Philosopher's Stone", " J.K. Rowling", 1997);
    private static final Book BOOK2 = new Book(2, "Harry Potter and the Chamber of Secrets", " J.K. Rowling", 1998);
    private static final Book BOOK3 = new Book(3, "The Hobbit", "J. R. R. Tolkien", 1937);

    private static BookStore store;

    @Before
    public void setup(){
        store = new BookStore();
        store.addBook(BOOK1);
        store.addBook(BOOK2);
        store.addBook(BOOK3);
    }

    @Test
    public void Given_store_with_books__When_getting_books_by_author_of_1_book_Then_only_1_book_returned(){
        List<Book> books = store.getBooksByAuthor(BOOK3.getAuthor());
        assertThat(books).containsExactlyInAnyOrder(BOOK3);
    }

    @Test
    public void Given_store_with_books_of_same_author_When_getting_books_by_author_Then_only_author_books_returned(){
        List<Book> books = store.getBooksByAuthor(BOOK1.getAuthor());
        assertThat(books).containsExactlyInAnyOrder(BOOK1, BOOK2);
    }

    @Test
    public void Given_store_with_books_When_getting_books_by_invalid_author_Then_empty_list_returned(){
        List<Book> books = store.getBooksByAuthor(BOOK1.getAuthor().toLowerCase());
        assertThat(books).isEmpty();
    }

    @Test
    public void Given_empty_store_When_getting_books_by_author_Then_empty_list_returned(){
        store = new BookStore();

        List<Book> books = store.getBooksByAuthor(BOOK1.getAuthor().toLowerCase());
        assertThat(books).isEmpty();
    }
}
