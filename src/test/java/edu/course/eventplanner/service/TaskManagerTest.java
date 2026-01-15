package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class TaskManagerTest {
    TaskManager manager = new TaskManager();

    @Test
    public void testAddTask() {
         Task task = new Task("Testing");
         manager.addTask(task);

         assertEquals(1, manager.remainingTaskCount());
    }

    @Test
    public void executeNextTask() {
        Task task = new Task("Testing");
        Task task2 = new Task("Testing2");
        manager.addTask(task);
        manager.addTask(task2);

        Task executed =  manager.executeNextTask();

        assertEquals(task, executed, "In the correct order.");
        assertEquals(1,manager.remainingTaskCount());
    }

    @Test
    public void undoLastTask() {
        Task task = new Task("Testing");
        Task task2 = new Task("Testing2");
        manager.addTask(task);
        manager.addTask(task2);

        Task executed =  manager.executeNextTask();
        Task undone = manager.undoLastTask();

        assertEquals(task, undone, "Undo should return the last completed task");
        assertEquals(1, manager.remainingTaskCount(), "Undo should NOT requeue the task");
    }

    @Test
    public void remainingTaskCount() {
        Task task = new Task("Testing");
        Task task2 = new Task("Testing2");
        manager.addTask(task);
        manager.addTask(task2);

        int remaining = manager.remainingTaskCount();

        assertEquals(2, remaining);
    }
}
