package com.kodilla.stream.world;

import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {



        //Given


        World world = new World();
        Continent europe = new Continent("Europe");
        Continent africa = new Continent("Africa");

        world.addContinent(europe);
        world.addContinent(africa);


        //When
        europe.addCountry(new Country("Poland", new BigDecimal("38426000")));
        europe.addCountry(new Country("Russia", new BigDecimal("142893540")));
        europe.addCountry(new Country("Germany", new BigDecimal("82422299")));
        europe.addCountry(new Country("Turkey", new BigDecimal("70413958")));

        africa.addCountry(new Country("Nigeria", new BigDecimal("131000000")));
        africa.addCountry(new Country("Ethiopia", new BigDecimal("74777981")));
        africa.addCountry(new Country("Egypt", new BigDecimal("78887007")));
        africa.addCountry(new Country("RPA", new BigDecimal("44000000")));




        //then
        assertEquals(new BigDecimal("662820785"), world.getPeopleQuantity());
    }
}

