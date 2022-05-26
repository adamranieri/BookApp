package dev.ranieri.app;

import dev.ranieri.daos.BookDAO;
import dev.ranieri.daos.BookDaoPostgres;
import dev.ranieri.entities.Book;
import dev.ranieri.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {
//
//        Connection conn = ConnectionUtil.getConnection();
//
//        String sql = "select * from book where book_id = 1";
//        Statement statement = conn.createStatement();
//        ResultSet rs = statement.executeQuery(sql); // ResultSet contains the info I want
//        // you must manually extract the information ot of it
//        rs.next();// get the first record in the result set
//        String bookTitle = rs.getString("title");
//        System.out.println(bookTitle);

        BookDAO bookDAO = new BookDaoPostgres();
        //System.out.println(bookDAO.getAllBooks());

        // If I want to create a new Book Record in my database you create an Object that has an ID of 0
        // An object that has an ID of 0 by convetion is not saved in a database yet
        // Once the object is SAVED it is given an ID and returned
//        Book kiteRunner = new Book(0,"Kite Runner", "Khaled Hosseini",2005);
//
//        bookDAO.createBook(kiteRunner);
//        System.out.println(kiteRunner);
//        bookDAO.deleteBookById(2);

        // get a book from the database
        Book book = bookDAO.getBookById(3);
        book.setReleaseYear(2000); // update a field
        bookDAO.updateBook(book); // save the update in the database

    }
}
