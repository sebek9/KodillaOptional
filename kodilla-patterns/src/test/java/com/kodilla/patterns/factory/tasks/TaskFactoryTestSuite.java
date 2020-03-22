package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite   {

    @Test
    public void testFactoryDrivingTask() {

        //Given

        TaskFactory factory=new TaskFactory();

        //When
        Task drive=factory.makeTask(TaskFactory.DRIVE);
        drive.executeTask();
        //Then
        Assert.assertEquals("Drive", drive.getTaskName());
        Assert.assertEquals(true, drive.isTaskExecuted());
        System.out.println(drive.getTaskName() + " Executed: "  + drive.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {

        //Given

        TaskFactory factory=new TaskFactory();

        //When
        Task paint=factory.makeTask(TaskFactory.PAINT);
        paint.executeTask();

        //Then
        Assert.assertEquals("Paint", paint.getTaskName());
        Assert.assertEquals(true, paint.isTaskExecuted());
        System.out.println(paint.getTaskName() + " Executed: "  + paint.isTaskExecuted());
    }

    @Test
    public void testFactoryShoppingTask() {

        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shop = factory.makeTask(TaskFactory.SHOP);
        shop.executeTask();

        //Then
        Assert.assertEquals("Buy",shop.getTaskName());
        Assert.assertEquals(false, shop.isTaskExecuted());
        System.out.println(shop.getTaskName() + " Executed: "  + shop.isTaskExecuted());
    }
}
