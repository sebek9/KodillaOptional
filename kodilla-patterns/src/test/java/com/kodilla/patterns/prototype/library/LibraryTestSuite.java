package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library theLibraryList = new Library("Library 1");


        Book book1 = new Book("Pan Tadeusz", "Adam Mickiewicz", LocalDate.now());
        Book book2 = new Book("Los", "Jan Kowalski", LocalDate.now());
        Book book3 = new Book("Zmierzch", "Piotr Chmielewski", LocalDate.now());

        theLibraryList.getBooks().add(book1);
        theLibraryList.getBooks().add(book2);
        theLibraryList.getBooks().add(book3);

        //making a shallow clone of object board
        Library clonedTheListLibrary = null;
        try {
            clonedTheListLibrary = theLibraryList.shallowCopy();
            clonedTheListLibrary.setName("Library2");
        } catch(CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Library deepClonedTheListLibrary = null;
        try {
            deepClonedTheListLibrary = theLibraryList.deepCopy();
            deepClonedTheListLibrary.setName("Library 3");
        } catch(CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        theLibraryList.getBooks().remove(book1);

        //Then
        System.out.println(theLibraryList);
        System.out.println(clonedTheListLibrary);
        System.out.println(deepClonedTheListLibrary);
        Assert.assertEquals(2, theLibraryList.getBooks().size());
        Assert.assertEquals(2, clonedTheListLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedTheListLibrary.getBooks().size());
        Assert.assertEquals(clonedTheListLibrary.getBooks(), theLibraryList.getBooks());
        Assert.assertNotEquals(deepClonedTheListLibrary.getBooks(), theLibraryList.getBooks());
    }
}
