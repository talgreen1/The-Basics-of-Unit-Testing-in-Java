package com.junitcourse._04_mocking.dao;

import com.junitcourse._04_mocking.model.Book;

import java.sql.Driver;
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
