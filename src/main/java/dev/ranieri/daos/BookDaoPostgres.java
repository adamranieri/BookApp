package dev.ranieri.daos;

import dev.ranieri.entities.Book;
import dev.ranieri.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDaoPostgres implements BookDAO{

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        // try with resources. Automatically closes the connection once the try block finishes

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from book where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery(); // JDBC actually interacts with the DB

            //Get First Record
            rs.next();

            // Create a book and set the values of that book to the information in the result set
            Book book = new Book();
            book.setBookId(id);
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setReleaseYear(rs.getInt("release_year"));
            return book;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public void deleteBookById(int id) {

    }
}
