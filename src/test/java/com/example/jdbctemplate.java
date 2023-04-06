package com.example;

import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class jdbctemplate {

    
    @Test
    void testTemplate(@Autowired JdbcTemplate jdbcTemplate){
        String sql=new String("select * from tbl_book");
        RowMapper<Book> rowMapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setType(resultSet.getString("type"));
                book.setName(resultSet.getString("name"));
                book.setDescription(resultSet.getString("description"));
                return book;
            }
        };

        List<Book> query = jdbcTemplate.query(sql, rowMapper);
        System.out.println(query);
    };
    }
