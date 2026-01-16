package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    @DisplayName("Adding a task stores it in the upcoming queue")
    @Test
    void addTaskStoresCorrectTask() {
        TaskManager m = new TaskManager();
        m.addTask(new Task("Decorate"));
        List<Task> tasks = m.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("Decorate", tasks.get(0).getDescription());
    }

    @DisplayName("executeNextTask removes from upcoming and pushes to completed")
    @Test
    void executeNextTaskMovesTaskCorrectly() {
        TaskManager m = new TaskManager();
        Task t1 = new Task("A");
        Task t2 = new Task("B");
        m.addTask(t1);
        m.addTask(t2);
        Task executed = m.executeNextTask();
        assertEquals(t1, executed);
        assertEquals(1, m.remainingTaskCount());
        assertEquals(t1, m.getCompletedTasks().peek());
    }

    @DisplayName("executeNextTask returns null when no tasks remain")
    @Test
    void executeNextTaskOnEmptyQueue() {
        TaskManager m = new TaskManager();
        assertNull(m.executeNextTask());
    }

    @DisplayName("undoLastTask pops from completed stack and does not requeue")
    @Test
    void undoLastTaskReturnsLastCompleted() {
        TaskManager m = new TaskManager();
        Task t1 = new Task("A");
        Task t2 = new Task("B");
        m.addTask(t1);
        m.addTask(t2);
        m.executeNextTask();
        Task undone = m.undoLastTask();
        assertEquals(t1, undone);
        assertEquals(1, m.remainingTaskCount());
        assertTrue(m.getCompletedTasks().isEmpty());
    }

    @DisplayName("undoLastTask returns null when no tasks have been executed")
    @Test
    void undoLastTaskOnEmptyCompletedStack() {
        TaskManager m = new TaskManager();
        assertNull(m.undoLastTask());
    }

    @DisplayName("remainingTaskCount reflects number of tasks in upcoming queue")
    @Test
    void remainingTaskCountWorks() {
        TaskManager m = new TaskManager();
        m.addTask(new Task("A"));
        m.addTask(new Task("B"));
        assertEquals(2, m.remainingTaskCount());
    }
}