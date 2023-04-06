package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.controller.utils.R;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
<<<<<<< HEAD
=======


>>>>>>> 835a6c3 (第三版)
    @Autowired
    private BookService bookService;
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        Boolean flag=bookService.save(book);
        return new R(flag,flag?"保存成功":"保存失败");
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) throws IOException{
        return new R(bookService.delete(id));
    }
    @PutMapping
    public R update(@RequestBody Book book) throws IOException{
        boolean flag = bookService.update(book);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)throws IOException {
        return new R(true, bookService.getById(id));
    }
    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize, Book book) throws IOException{
        IPage<Book> page=bookService.getPage(currentPage,pageSize,book);
        if (currentPage>page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }
}
