package com.kodilla.patterns.factory.tasks;


public class TaskFactory {
    public static final String DRIVE = "Driving";
    public static final String PAINT = "Painting";
    public static final String SHOP = "Shoppping";

    public final Task makeTask(final String TaskClass) {

        switch (TaskClass) {
            case DRIVE:

                return new DrivingTask("Drive", "Poland", "test");
            case PAINT:

                return new PaintingTask("Paint", "Blue", "Landscape");
            case SHOP:

                return new ShoppingTask("Buy", "notebook", 3);
            default:
                return null;

        }
    }
}

