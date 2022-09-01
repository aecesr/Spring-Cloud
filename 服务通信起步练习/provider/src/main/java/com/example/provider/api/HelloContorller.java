package com.example.provider.api;

import com.example.provider.model.Book;
import com.example.provider.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: provider
 * @description:
 * @Author: 曹红亮
 * @create: 2022-08-30 15:43
 **/
@RestController
@RequestMapping(value = "/api")
public class HelloContorller {
    @Resource
    private BookService bookService;

    @GetMapping("/getbook")
    public String getHello(@RequestParam String bookName,@RequestParam String number){
        Book book = new Book();
        book.setBookName(bookName);
        book.setNumber(number);

        return bookService.getbook(book);
    }
}
