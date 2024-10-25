public class main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Task task1 = new Task();
        task1.setId(1);

        Task task2 = new Task();
        task2.setId(2);

        Epic epic1 = new Epic();
        Epic epic2 = new Epic();

        Subtask subtask1 = new Subtask();
        subtask1.setEpic(epic1);

        Subtask subtask2 = new Subtask();
        subtask2.setEpic(epic1);

        Subtask subtask3 = new Subtask();
        subtask3.setEpic(epic2);

        manager.createTask(task1);
        manager.createTask(task2);
        manager.createEpic(epic1);
        manager.createEpic(epic2);
        manager.createSubtask(epic1, subtask1);
        manager.createSubtask(epic1, subtask2);
        manager.createSubtask(epic2, subtask3);

        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubtasks());

        manager.removeTask(task1.getId());
        manager.removeEpic(epic1.getId());

        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubtasks());
    }
}
