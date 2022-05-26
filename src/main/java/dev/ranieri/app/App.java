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
        Book b = bookDAO.getBookById(2);
        System.out.println(b);

    }
}
