package com.junitcourse._06_mocking.dao;

import com.junitcourse._06_mocking.model.Book;

import java.util.List;

public class BookStoreDao {

    public BookStoreDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    }

    public void addBook(Book book) {
        // Production DB code should be here...
    }

    public List<Book> getAllBooks() {
        // Production DB code should be here...
        return null;
    }
}
