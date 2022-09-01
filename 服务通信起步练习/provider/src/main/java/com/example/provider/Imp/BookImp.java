package com.example.provider.Imp;

import com.example.provider.model.Book;
import com.example.provider.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: provider
 * @description:
 * @Author: 曹红亮
 * @create: 2022-08-30 19:22
 **/
@Service
public class BookImp implements BookService {


    @Override
    public String getbook(Book book) {
        if (book.getBookName() != null) {
            return "鋼鐵是怎麼煉成的";
        }
        return "不能為空";
    }
}

