package com.kodilla.stream.array;


import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int numbers [] = {5,3,2,1,1,1,1,1,2,1,5,8,1,2,1,2,4,5,6,7};
        double averageExpected = 2.95;
        //When
        double average = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(averageExpected, average, 0.0001);
    }

    @Test
    public void testEmptyArray() {
        //Given
        int numbers[] = new int[0];

        double averageExpected = 0;
        //When
        double average = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(averageExpected, average, 0.0001);


    }


    }


