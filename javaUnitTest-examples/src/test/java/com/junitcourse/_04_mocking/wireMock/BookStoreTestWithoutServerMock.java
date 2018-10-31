package com.junitcourse._04_mocking.wireMock;

import com.junitcourse._04_mocking.BookStore;
import com.junitcourse._04_mocking.dao.BookStoreDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BookStoreTestWithoutServerMock {
    @Mock
    private BookStoreDao dao;

    @Test
    public void findStore() throws IOException {
        BookStore store = new BookStore(dao);

        String shops = store.getShopsWithBooks(1);
    }

}