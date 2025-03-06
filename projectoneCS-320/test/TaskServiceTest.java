import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Test Task", "Test Description");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("123"));
    }

    @Test
    public void testAddDuplicateTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Test Task", "Test Description");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task);
        });
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Test Task", "Test Description");
        taskService.addTask(task);
        taskService.deleteTask("123");
        assertNull(taskService.getTask("123"));
    }

    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Test Task", "Test Description");
        taskService.addTask(task);
        taskService.updateTaskName("123", "Updated Name");
        assertEquals("Updated Name", taskService.getTask("123").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService();
        Task task = new Task("123", "Test Task", "Test Description");
        taskService.addTask(task);
        taskService.updateTaskDescription("123", "Updated Description");
        assertEquals("Updated Description", taskService.getTask("123").getDescription());
    }

    @Test
    public void testUpdateNonexistentTask() {
        TaskService taskService = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("999", "Updated Name");
        });
    }
}
