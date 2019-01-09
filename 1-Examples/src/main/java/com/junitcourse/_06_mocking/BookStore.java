package com.junitcourse._06_mocking;

import com.junitcourse._06_mocking.dao.BookStoreDao;
import com.junitcourse._06_mocking.model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    /**
     * Returns a list of shops that have this book in stock
     * @param id    The ID of the book
     * @return  String with all the shops names that have this book in stock. The list is seperated by ';'
     * @throws IOException
     */
    public String[] getShopsWithBooks(int id) throws IOException {
        String result = "";

        URL url = new URL("http://localhost:8090/stores/findStoreForBook/" + id);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        while ((output = br.readLine()) != null) {
            result += output;
        }

        conn.disconnect();


        // Add code to extract the store list from the response
        return result.split(";");
    }
}
