import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("123", "Test Task", "This is a test description");
        assertEquals("123", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Task", "Test Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Task", "Test Description");
        });
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", null, "Test Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name that is way too long for this field", "Test Description");
        });
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Test Task", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Test Task", "Description that exceeds the maximum length of fifty characters.");
        });
    }
}
