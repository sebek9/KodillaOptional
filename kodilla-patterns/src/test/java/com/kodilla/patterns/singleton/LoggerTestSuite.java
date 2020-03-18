package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {


    @BeforeClass
    public static void log() {
    Logger.getInstance().log("Test");
    }

    @Test
    public void getLastLog() {
        //Given
        //When
        String lastLog = Logger.getInstance().getLastLog();
        System.out.println("Last saved log: " + lastLog);
        //Then
        Assert.assertEquals("Test",lastLog);

    }

}