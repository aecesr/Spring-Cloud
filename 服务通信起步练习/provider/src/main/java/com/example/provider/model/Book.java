package com.example.provider.model;

import lombok.Data;

/**
 * @program: provider
 * @description:
 * @Author: 曹红亮
 * @create: 2022-08-30 19:14
 **/
@Data
public class Book {
    private String bookName;
    private String number;

    public String getBookName() {
        return bookName;
    }

    public String getNumber() {
        return number;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
