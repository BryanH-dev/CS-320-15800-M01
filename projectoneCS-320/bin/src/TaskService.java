
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap;

    public TaskService() {
        taskMap = new HashMap<>();
    }

    // Add a new task
    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        taskMap.put(task.getTaskId(), task);
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        taskMap.remove(taskId);
    }

    // Update task name
    public void updateTaskName(String taskId, String name) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        taskMap.get(taskId).setName(name);
    }

    // Update task description
    public void updateTaskDescription(String taskId, String description) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        taskMap.get(taskId).setDescription(description);
    }

    // Retrieve task (optional for testing purposes)
    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }
}
