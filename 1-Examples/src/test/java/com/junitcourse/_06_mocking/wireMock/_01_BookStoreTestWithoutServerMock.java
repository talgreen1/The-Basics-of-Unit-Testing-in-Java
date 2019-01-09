package com.junitcourse._06_mocking.wireMock;

import com.junitcourse._06_mocking.BookStore;
import com.junitcourse._06_mocking.dao.BookStoreDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class _01_BookStoreTestWithoutServerMock {
    @Mock
    private BookStoreDao dao;

    @Test
    public void findStore() throws IOException {
        BookStore store = new BookStore(dao);

        // Cannot test it in unit test - there is no server available
        String [] shops = store.getShopsWithBooks(1);
    }

}