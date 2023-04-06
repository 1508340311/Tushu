package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    boolean save(Book book);
    Boolean delete(Integer id);
    Boolean update(Book book);

    IPage<Book> getPage(Integer currentPage, Integer pageSize);
    IPage<Book> getPage(Integer currentPage,Integer pageSize,Book book);
}
