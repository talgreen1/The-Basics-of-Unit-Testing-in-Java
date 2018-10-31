package com.junitcourse._04_mocking;

import com.junitcourse._04_mocking.dao.BookStoreDao;
import com.junitcourse._04_mocking.model.Book;

import java.util.List;

public class BookStore {

    private List<Book> books;
    private BookStoreDao bookStoreDao;

    public BookStore(BookStoreDao bookStoreDao) {
        this.bookStoreDao = bookStoreDao;
        books = bookStoreDao.getAllBooks();
    }

    public int getBookCount() {
        return books.size();
    }

    /**
     * Add a new book to the book store.
     *
     * @param book The book to add
     * @return The book if it was added, null if the book already exists
     */
    public Book addBook(Book book) {
        if (books.contains(book)) {
            return null;
        } else {
            books.add(book);
            bookStoreDao.addBook(book);
            return book;
        }
    }

    /**
     * Return a book by it's ID
     * @param id    The ID of the book to return
     * @return  The book if it was found, otherwise null
     */
    public Book getBookById(int id){
        for (Book book : books){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks(){
        return this.books;
    }
}
