package com.junitcourse.answers._05_final_exercise_1;

import com.junitcourse._04_final_exercies_1.Book;
import com.junitcourse._04_final_exercies_1.BookStore;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateBookTests {
    private static final Book BOOK_ID_1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
    private static final Book BOOK_ID_2_ORIG = new Book(2, "Harry Potter", "J. K. Rowling", 1997);
    private static final Book BOOK_ID_2_NEW = new Book(2, "Flatland", "Edwin Abbott Abbott", 1884);
    private static final Book BOOK_ID_3 = new Book(3, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979);

    private static BookStore store;

    @Before
    public void setup() {
        store = new BookStore();
        store.addBook(BOOK_ID_1);
        store.addBook(BOOK_ID_2_ORIG);
    }

    @Test
    public void Given_store_with_books_When_updating_existing_book_Then_book_is_updated_and_old_book_returned() {
        Book oldBook = store.updateBook(BOOK_ID_2_NEW);

        List<Book> books = store.getBooks();
        assertThat(books).contains(BOOK_ID_2_NEW);
        assertThat(books).doesNotContain(BOOK_ID_2_ORIG);
        assertThat(oldBook).isSameAs(BOOK_ID_2_ORIG);
    }

    @Test
    public void Given_store_with_books_When_updating_non_existing_book_Then_null_returned_and_books_not_changed() {
        List<Book> booksBeforeUpdate = store.getBooks();
        Book book = store.updateBook(BOOK_ID_3);
        List<Book> booksAfterUpdate = store.getBooks();

        assertThat(book).isNull();
        assertThat(booksBeforeUpdate).containsExactlyInAnyOrderElementsOf(booksAfterUpdate);
    }

    @Test
    public void Given_empty_store_When_updating_book_Then_null_returned_and_store_still_empty(){
        store = new BookStore();
        Book updatedBook = store.updateBook(BOOK_ID_1);

        assertThat(updatedBook).isNull();
        assertThat(store.getBooks()).isEmpty();


    }


}
