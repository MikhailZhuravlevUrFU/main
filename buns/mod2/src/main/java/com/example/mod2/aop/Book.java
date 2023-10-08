package com.example.mod2.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и Наказание")
    private String name;

    @Value("Ф.М.Достоевский")
    private String author;

    @Value("1866")
    private int yearOfPublication;

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getYearOfPublication(){
        return yearOfPublication;
    }

}
