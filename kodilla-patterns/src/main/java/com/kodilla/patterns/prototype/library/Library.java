package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }
    @Override
    public String toString() {
        String s = "Library [" + name + "]\n";
        for (Book book : books) {
            s = s + book.toString() + "\n";
        }
        return s;
    }

    public Library shallowCopy () throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy () throws CloneNotSupportedException {
        Library cloneLibrary = (Library) super.clone();
        cloneLibrary.books = new HashSet<>();
        for (Book theBook : books) {
            Book clonedList = new Book(theBook.getTitle(), theBook.getAuthor(), theBook.publicationDate);
            cloneLibrary.getBooks().add(clonedList);
        }
        return cloneLibrary;
    }

    }






