package edu.course.eventplanner.service;

import edu.course.eventplanner.model.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    @DisplayName("Adding a task increases remainingTaskCount")
    @Test
    void addTaskStoresCorrectTask() {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task("Decorate"));
        assertEquals(1, manager.remainingTaskCount());
    }

    @DisplayName("executeNextTask removes from upcoming and returns the correct task")
    @Test
    void executeNextTaskMovesTaskCorrectly() {
        TaskManager manager = new TaskManager();
        Task t1 = new Task("A");
        Task t2 = new Task("B");
        manager.addTask(t1);
        manager.addTask(t2);
        Task executed = manager.executeNextTask();
        assertEquals(t1, executed);
        assertEquals(1, manager.remainingTaskCount());
    }

    @DisplayName("executeNextTask returns null when no tasks remain")
    @Test
    void executeNextTaskOnEmptyQueue() {
        TaskManager manager = new TaskManager();
        assertNull(manager.executeNextTask());
    }

    @DisplayName("undoLastTask returns the last executed task")
    @Test
    void undoLastTaskReturnsLastCompleted() {
        TaskManager manager = new TaskManager();
        Task t1 = new Task("A");
        Task t2 = new Task("B");
        manager.addTask(t1);
        manager.addTask(t2);
        manager.executeNextTask();
        Task undone = manager.undoLastTask();
        assertEquals(t1, undone);
        assertEquals(1, manager.remainingTaskCount());
    }
    @DisplayName("undoLastTask returns null when no tasks have been executed")
    @Test void undoLastTaskOnEmptyCompletedStack() {
        TaskManager manager = new TaskManager();
        assertNull(manager.undoLastTask());
    }
    @DisplayName("remainingTaskCount reflects number of tasks in upcoming queue")
    @Test void remainingTaskCountWorks() {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task("A"));
        manager.addTask(new Task("B"));
        assertEquals(2, manager.remainingTaskCount());
    }
}