package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    final String taskName;
    final String where;
    final String using;
    private boolean executed;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;

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
        executed=true;
    }
}
