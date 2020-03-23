/*package com.kodilla.stream.array;

import java.util.LinkedList;

public class LinkedListBook {

    public static void main (String[] args) throws java.lang.Exception
    {


    //Creating collection with 600000 elements of type Book
		LinkedList<Book> books = new LinkedList<>();
        Book theGenerator = new Book;
		for(int n = 0; n < 600000; n++) {
            books.add(theGenerator.get(n));
			//books.add(n);
		}
        //Random theGenerator = new Random();
        //for (int n=0; n<2000000; n++){
          //  theBigList.add(theGenerator.nextInt(50000));

System.out.println("Ilosc elementow na liscie: " + books.size());

/*

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

}


class LinkedListBook
{
public static void main (String[] args) throws java.lang.Exception
{


    //Creating collection with 600000 elements of type Book
		LinkedList<Book> books = new LinkedList<Book>();
		for(int n = 0; n < 600000; n++) {
		    books.add(new Book("Test", "Jan"));

		}


System.out.println("Ilosc elementow na liscie: " + books.size());


//Czas dodania pierwszego elementu
long begin1 = System.nanoTime();
	books.add(0, new Book("Test1","Test1"));
long end1 = System.nanoTime();
System.out.println("Czas dodania pierwszego elementu: " + (end1 - begin1) + "ms");

//Dodawanie ostatniego elementu
long begin2 = System.nanoTime();
books.add(new Book("Test2","Test2"));
long end2 = System.nanoTime();

System.out.println("Czas dodania ostatniego elementu: " + (end2 - begin2) + "ms");

//Usuwanie pierwszego elementu

long begin3 = System.nanoTime();
books.remove(0);
long end3 = System.nanoTime();

//Czas usuniecia pierwszego elementu
System.out.println("Czas usuniecia pierwszego elementu: " + (end3 - begin3) + "ms");

//Usuwanie ostatniego elementu
long begin4 = System.nanoTime();
books.remove(books.size()-1);

long end4 = System.nanoTime();

//Czas usuniecia ostatniego elementu
System.out.println("Czas usuniecia ostatniego elementu: " + (end4 - begin4) + "ms");


     // Tworzenie hashmap
       Map<Integer, Book> booksMap = new HashMap<>();
        Random randomGenerator = new Random();
        for (int i = 0; i < 100000; i++) {
        booksMap.put( i, new Book("Adam Mickiewicz","Pan Tadeusz"));
        }

        long begin5 = System.nanoTime();
        booksMap.get(80);
        long end5 = System.nanoTime();
        System.out.println("Wielkosc mapy: " + booksMap.size() + "\n Wyszukiwana pozycja: " + booksMap.get(80) + " " + "\n Czas wyszukiwania po kluczu: "+ (end5 - begin5) + "ms");


	 //Dodawanie do mapy

	long begin6 = System.nanoTime();
    booksMap.put(100001, new Book("Test 4", "Test 4"));
    long end6 = System.nanoTime();

    System.out.println("Wielkosc mapy po dodaniu: " + booksMap.size() + " Czas dodania: " + (end6 - begin6) + "ms");



    //Usuwanie z mapy

    long begin7 = System.nanoTime();
    booksMap.remove(books.size()-1);
    long end7 = System.nanoTime();

    System.out.println("Wielkosc mapy po usunieciu elementu: " + booksMap.size() + " Czas usuniecia: " + (end7 - begin7) + "ms");


}

}


////
//Czas dodania pierwszego elementu
long begin1 = System.nanoTime();
	books.add(0);
long end1 = System.nanoTime();
System.out.println("Czas dodania pierwszego elementu: " + (end1 - begin1) + "ms");

//Dodawanie ostatniego elementu
long begin2 = System.nanoTime();
books.add(books.size());
long end2 = System.nanoTime();

System.out.println("Czas dodania ostatniego elementu: " + (end2 - begin2) + "ms");

//Usuwanie pierwszego elementu
long begin3 = System.nanoTime();
books.remove(0);
long end3 = System.nanoTime();

//Czas usuniecia pierwszego elementu
System.out.println("Czas usuniecia pierwszego elementu: " + (end3 - begin3) + "ms");

//Usuwanie ostatniego elementu
long begin4 = System.nanoTime();
books.remove(books.size()-1);
long end4 = System.nanoTime();

//Czas usuniecia ostatniego elementu
System.out.println("Czas usuniecia ostatniego elementu: " + (end4 - begin4) + "ms");
*/
/*
        // Tworzenie hashmap
        Map<Integer, Integer> booksMap = new HashMap<>();
        Random randomGenerator = new Random();
        int list = 1000000;
        for (int i = 0; i < list; i++) {
            booksMap.put(i, randomGenerator.nextInt(101));
        }
        long begin5 = System.nanoTime();
        booksMap.get(80);
        long end5 = System.nanoTime();
        System.out.println("Wielkosc mapy: " + booksMap.size() + " Wyszukiwana pozycja: " + booksMap.get(80) + " " + "Czas wyszukiwania po kluczu: "+ (end5 - begin5) + "ms");


        //Dodawanie do mapy

        long begin6 = System.nanoTime();
        booksMap.put(1000000,1000000);
        long end6 = System.nanoTime();

        System.out.println("Wielkosc mapy: " + booksMap.size() + " Czas dodania: " + (end6 - begin6) + "ms");



	/*
    //Usuwanie z mapy

    long begin7 = System.nanoTime();
    booksMap.remove(books.size()-1);
    long end7 = System.nanoTime();

    System.out.println("Wielkosc mapy: " + booksMap.size() + " Czas usuniecia: " + (end7 - begin7) + "ms");
   */

