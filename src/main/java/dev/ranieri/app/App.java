package dev.ranieri.app;

import dev.ranieri.daos.BookDAO;
import dev.ranieri.daos.BookDaoPostgres;
import dev.ranieri.entities.Book;
import dev.ranieri.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
//        Book book = bookDAO.getBookById(3);
//        book.setReleaseYear(2000); // update a field
//        bookDAO.updateBook(book); // save the update in the database

//        Book mockingbird = new Book(0,"To Kill a Mocking Bird", "Harper Lee", 1965);
//        bookDAO.createBook(mockingbird);

        List<Book> allBooks = bookDAO.getAllBooks();
        System.out.println(allBooks);

        //Collections is a utility class for dealing with collections
        //Collections.reverse(allBooks);// flip the order
        //Collections.shuffle(allBooks);// randomize the list

        // Sorting lists is among the most common tasks in programming
        // lambda syntax => a function that is treated like a variable/object in the code
        Comparator<Book> sortByYear = (b1,b2) ->{
            if(b1.getReleaseYear()< b2.getReleaseYear()){
                return  -1;
            }
            if(b1.getReleaseYear()> b2.getReleaseYear()){
                return  1;
            }
            return 0;
        };
        // you can create as many comparators as you want for as many different ways of sorting as you want
        // adds a lot more flexiblility than just a comparable

        Collections.sort(allBooks, sortByYear);
        System.out.println(allBooks);


    }
}
