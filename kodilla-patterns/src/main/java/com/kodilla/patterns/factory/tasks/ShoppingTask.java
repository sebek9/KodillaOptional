package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    final String taskName;
    final String whatToBuy;
    final double quantity;
    private boolean executed;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;

    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if(executed)return true;
        else return false;
    }

    @Override
    public void executeTask() {
        executed=false;

    }
}

