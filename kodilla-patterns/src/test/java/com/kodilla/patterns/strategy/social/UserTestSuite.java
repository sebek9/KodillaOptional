package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;



public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User jan=new Millenials("Janex");
        User broda=new YGeneration("Brodix");
        User piotr=new ZGeneration("Piotrex");

        //When

        String janPost=jan.share();
        System.out.println("Jan post on: " + janPost);
        String broPost=broda.share();
        System.out.println("Broda post on: " + broPost);
        String piotrPost=piotr.share();
        System.out.println("Piotr post on: " + piotrPost);

        //Then
        Assert.assertEquals("Twitter post shared!", janPost);
        Assert.assertEquals("Facebook post shared!", broPost);
        Assert.assertEquals("Snapchat post shared!", piotrPost);


    }

    @Test
    public void testIndividualSharingStrategy() {

        //Given
        User jan = new Millenials("janex");

        //When
        String janPost = jan.share();
        System.out.println("Current Jan post: " + janPost);
        jan.sharePost(new SnapchatPublisher());
        janPost = jan.share();
        System.out.println("Updated Jan post: " + janPost);

        //Then
        Assert.assertEquals("Snapchat post shared!", janPost);
    }

}


