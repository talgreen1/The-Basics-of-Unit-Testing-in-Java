package com.junitcourse._04_mocking.mockito;

import com.junitcourse._04_mocking.BookStore;
import com.junitcourse._04_mocking.dao.BookStoreDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

public class _01_BookStoreTestWithoutDaoMock {

    private BookStoreDao dao;

    @Test
    public void readBooksFromDbWhenStoreIsCreated() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        // Cannot create instance of BookStoreDao: DB is not available in Unit Test Phase
        BookStore store = new BookStore(new BookStoreDao());
    }

}