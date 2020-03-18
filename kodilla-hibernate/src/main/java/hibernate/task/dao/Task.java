package hibernate.task.dao;


import hibernate.tasklist.TaskList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
/*
@NamedQueries({
        @NamedQuery(
        name="Task.retrieveLongTasks",
        query="FROM Task WHERE duration>10"
),
@NamedQuery(
        name="Task.retrieveShortTasks",
        query=" FROM Task WHERE duration>10"

),
@NamedQuery(
        name="Task.retrieveTasksWitDurationLongerThan",
        query="FROM Task WHERE duration > :DURATION"

        })
@NamedNativeQuery(
        name="Task.retrieveTasksWithoutEnoughTime",
        query="SELECT * FROM" +
                "WHERE DATEDIFF(DATE_ADD(CREATED, INTERVAL DURATION DAY ),NOW()) > 5",
        resultClass =Task.class
)
*/

@Entity
@Table(name = "TASKS")
public final class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS FINANCIALS ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name="TASKLIST ID")
    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (duration != task.duration) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        return created != null ? created.equals(task.created) : task.created == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }
}
