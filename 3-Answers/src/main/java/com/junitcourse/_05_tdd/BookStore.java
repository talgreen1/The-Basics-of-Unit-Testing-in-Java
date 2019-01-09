package com.junitcourse._05_tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookStore {

    private List<Book> books;

    public BookStore() {
        this.books = new LinkedList<>();
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

    public List<Book> filterByName(String name, boolean isRegex) {

        List<Book> res =  new ArrayList<>();

        for (Book book : this.books) {
            if (isRegex){
                if (book.getName().matches(name)) {
                    res.add(book);
                }

            }else{
                if (book.getName().contains(name)){
                    res.add(book);
                }
            }


        }
        return res;
    }
}
