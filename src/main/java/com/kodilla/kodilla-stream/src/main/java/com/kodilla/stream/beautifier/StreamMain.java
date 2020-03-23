package com.kodilla.stream.beautifier;



public class StreamMain {

    public static void main(String[]args){



        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("JAN", (a) -> a + "Test");
        poemBeautifier.beautify("Gwiazdki", (a) -> "***" + a );
        poemBeautifier.beautify("Gwiazdki2",(a) -> "123" + a + "567");
        poemBeautifier.beautify("Niedziela", String::toUpperCase);
        poemBeautifier.beautify("Sobota", String::toLowerCase);
    }



}
