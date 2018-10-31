package com.junitcourse._04_mocking.mockito;

import com.junitcourse._04_mocking.BookStore;
import com.junitcourse._04_mocking.dao.BookStoreDao;
import com.junitcourse._04_mocking.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookStoreTestWithDaoMock {


    @Mock
    private BookStoreDao dao;

    @Test
    public void readBooksFromDbWhenStoreIsCreated() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //When creating new bookStore - use the dao mock
        BookStore store = new BookStore(dao);

        //Verify that the method 'getAllBooks' was executed on the mock dao
        verify(dao).getAllBooks();
    }

    @Test
    public void returnBooksFromDb(){
        //Create a book list to be return by the dao mock
        List<Book> books = new LinkedList<>();

        books.add(new Book(1, "The Hobbit", "J. R. R. Tolkien", 1937));
        books.add(new Book(2, "Harry Potter", "J. K. Rowling", 1997));

        //Adding stub to the mock - when the method 'getAllBooks' is called - return books
        when(dao.getAllBooks()).thenReturn(books);

        BookStore store = new BookStore(dao);

        //Verify that the method 'getAllBooks' was executed on the mock dao
        verify(dao).getAllBooks();
        List<Book> allBooks = store.getAllBooks();

        //Verify that the books that was returned from the stores are taken from the dao (stub)
        assertThat(allBooks).isSameAs(books);
    }

}