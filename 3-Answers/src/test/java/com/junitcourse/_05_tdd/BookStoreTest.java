package com.junitcourse._05_tdd;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.Assert.*;

public class BookStoreTest {
    @Test
    public void Given_empty_store_When_filtering_by_a_name_Then_get_empty_list(){
        BookStore store = new BookStore();
        List<Book> res =  store.filterByName("a");

        assertThat(res).isEmpty();

    }
}