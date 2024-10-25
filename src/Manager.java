import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private final HashMap<Integer, Task> tasks;
    private final HashMap<Integer, Subtask> subtasks;
    private final HashMap<Integer, Epic> epics;
    private int uniqueId = 1;

    public Manager() {
        tasks = new HashMap<>();
        subtasks = new HashMap<>();
        epics = new HashMap<>();
    }
    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    public ArrayList<Subtask> getAllSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public void removeAll() {
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public void createTask(Task task) {
        task.setId(getUniqueId());
        tasks.put(task.getId(), task);
    }

    public void createEpic(Epic epic) {
        epic.setId(getUniqueId());
        epics.put(epic.getId(), epic);
    }
    public void createSubtask(Epic epic, Subtask subtask) {
        if (epics.containsValue(epic)) {
            subtask.setId(getUniqueId());
            subtasks.put(subtask.getId(), subtask);
        } else {
            System.out.println("Такого эпика не существует");
        }
    }

    public void updateTask(int existingTaskId, Task task) {
        if (tasks.containsKey(existingTaskId)) {
            task.setId(existingTaskId);
            tasks.put(existingTaskId, task);
        } else {
            System.out.println("Такой задачи не существует");
        }
    }

    public void updateEpic(int existingEpicId, Epic epic) {
        if (epics.containsKey(existingEpicId)) {
            epic.setId(existingEpicId);
            epics.put(existingEpicId, epic);
        } else {
            System.out.println("Такого эпика не существует");
        }
    }

    public void updateSubtask(int existingSubtaskId, Subtask subtask) {
        if (subtasks.containsKey(existingSubtaskId)) {
            subtask.setId(existingSubtaskId);
            subtasks.put(existingSubtaskId, subtask);
        } else {
            System.out.println("Такой подзадачи не существует");
        }
    }

    public void removeTask(int id) {
        tasks.remove(id);
    }

    public void removeEpic(int id) {
        if (epics.containsKey(id)) {
            Epic epic = epics.get(id);
            for (Subtask subtask : subtasks.values()) {
                if (subtask.getEpic().equals(epic)) {
                    subtasks.remove(subtask.getId());
                }
            }
            epics.remove(id);
        } else {
            System.out.println("Такого эпика не существует");
        }
    }

    public void removeSubtask(int id) {
        if (subtasks.containsKey(id)) {
            Subtask subtask = subtasks.get(id);
            Epic epic = subtask.getEpic();
            if (epic != null) {
                epic.getSubtasks().remove(subtask);
            }
            subtasks.remove(id);
        } else {
            System.out.println("Такой подзадачи не существует");
        }
    }

    public int getUniqueId() {
        return uniqueId++;
    }
}