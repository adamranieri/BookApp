package dev.ranieri.daos;

import dev.ranieri.entities.Book;

import java.util.List;

// The method signature should typically take in an entity and return an entity
public interface BookDAO {

    // Create
    Book createBook(Book book);

    // Read
    Book getBookById(int id);
    List<Book> getAllBooks();

    //Update
    Book updateBook(Book book);

    //Delete
    void deleteBookById(int id);

}
