package com.kodilla.stream.array;

import java.util.*;
import java.lang.*;
import java.io.*;


class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    /*
    public Book(String title, String author) {
        this.title = title;
        this.author = author;


    }

    public boolean equals(Object o){
        final Book e = (Book) o;
        return this.title.equals(e.title) && this.author.equals(e.author);
    }

    public int hashCode(){
        return Integer.parseInt(title.substring(0, 5));
    }


    public String toString(){
        return title + " " +  author;
    }
*/
}
