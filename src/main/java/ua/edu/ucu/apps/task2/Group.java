package ua.edu.ucu.apps.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group<T> extends Task<T> {
    private String groupUuid;
    List<Task<T>> tasks;

    public Group() {
        this.tasks = new ArrayList<>();
    }

    public Group<T> addTask(Task<T> task) {
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        if (groupUuid == null) {
            groupUuid = UUID.randomUUID().toString();
            super.freeze();
            for (Task<T> task : tasks) {
                task.freeze();
                task.setHeader("groupId", groupUuid);
            }
            tasks = Collections.unmodifiableList(tasks);
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        tasks = Collections.unmodifiableList(tasks);
        for (Task<T> task: tasks) {
            task.apply(arg);
        }
    }

    public String getGroupUuid() {
        return groupUuid;
    }
}
