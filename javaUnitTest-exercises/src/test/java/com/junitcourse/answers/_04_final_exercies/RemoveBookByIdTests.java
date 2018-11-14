package com.junitcourse.answers._04_final_exercies;

import com.junitcourse._04_final_exercies.Book;
import com.junitcourse._04_final_exercies.BookStore;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RemoveBookByIdTests {
    private static final Book BOOK_ID_1 = new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937);
    private static final Book BOOK_ID_2 = new Book(2, "Harry Potter", "J. K. Rowling", 1997);
    private static final Book BOOK_ID_3 = new Book(2, "Flatland", "Edwin Abbott Abbott", 1884);
    private static final Book BOOK_ID_4 = new Book(3, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979);

    private static BookStore store;

    @Before
    public void setup() {
        store = new BookStore();
        store.addBook(BOOK_ID_1);
        store.addBook(BOOK_ID_2);
        store.addBook(BOOK_ID_3);
    }

    @Test
    public void Given_store_with_books_When_removing_existing_book_Then_book_is_removed_and_returned(){
        int booksCountBeforeRemove = store.getBookCount();
        Book removedBook = store.removeBookById(BOOK_ID_1.getId());
        int booksCountAfterRemove = store.getBookCount();

        assertThat(removedBook).isSameAs(BOOK_ID_1);
        assertThat(store.getBooks()).doesNotContain(removedBook);

        assertThat(booksCountBeforeRemove).isEqualTo(booksCountAfterRemove + 1);
    }

    @Test
    public void Given_store_with_books_When_removing_non_existing_book_Then_null_returned_and_books_not_changed(){
        List<Book> booksBeforeRemove = store.getBooks();
        Book removedBook = store.removeBookById(BOOK_ID_4.getId());
        List<Book> booksAfterRemove = store.getBooks();

        assertThat(removedBook).isNull();
        assertThat(booksBeforeRemove).containsExactlyInAnyOrderElementsOf(booksAfterRemove);
    }

    @Test
    public void Given_empty_store_When_removing_book_Then_null_returned_and_store_still_empty() {
        store = new BookStore();
        Book removedBook = store.removeBookById(BOOK_ID_1.getId());

        assertThat(removedBook).isNull();
        assertThat(store.getBooks()).isEmpty();
    }


    }
