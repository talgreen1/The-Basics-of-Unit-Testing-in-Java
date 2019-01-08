package com.junitcourse._904_final_exercies_1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * This method returns a list of books written by a specific author
     * @param author    The author of the books
     * @return  List of books written by the author parameter. If there are no such books, empty list will be returned.
     */
    public List<Book> getBooksByAuthor(String author){
        return this.books.stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
    }

    /**
     * This method updates an existing book. It gets a book, search an existing book with the same id and updates it.
     * @param updatedBook   The updated book
     * @return  If an existing book was updated, the old book is returned. If the book didn't exist, null will be return.
     */
    public Book updateBook(Book updatedBook){
        Book book = removeBookById(updatedBook.getId());
        if (book == null){
            return null;
        }

        addBook(updatedBook);
        return book;
    }

    /**
     * Removes a book by it's id
     * @param id    The id of the book to remove
     * @return  The removed book. If the book didn't exist, null will be return.
     */
    public Book removeBookById(int id){
        Book res = null;

        for (Book book : books){
            if (book.getId() == id){
                books.remove(book);
                res = book;
                break;
            }
        }
        return res;
    }

    public List<Book> getBooks(){
        return Collections.unmodifiableList(books);
    }

}
