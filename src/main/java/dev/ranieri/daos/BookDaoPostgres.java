package dev.ranieri.daos;

import dev.ranieri.entities.Book;
import dev.ranieri.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoPostgres implements BookDAO{

    @Override
    public Book createBook(Book book) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "insert into book values (default,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getReleaseYear());

            ps.execute();

            // getting the generated primary key value
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("book_id");

            book.setBookId(generatedId);// the book id changing for 0 to a non zero values means that it is saved
            return book;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
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

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from book";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Book> books = new ArrayList<Book>();

            while (rs.next()){
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setReleaseYear(rs.getInt("release_year"));
                books.add(book);
            }
            return books;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Book updateBook(Book book) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "update book set title = ?, author = ?, release_year = ? where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getReleaseYear());
            ps.setInt(4, book.getBookId());

            ps.execute();

            return book;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteBookById(int id) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "delete from book where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
