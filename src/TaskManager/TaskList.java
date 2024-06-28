package TaskManager;

public class TaskList {
    public Task head;
    public Task tail;
    public int size;

    public Task createToDoList(String taskDescription, Boolean completed, String userName, Users users) {

        head = new Task();
        Task task = new Task();
        task.nextTask = null;
        task.description = taskDescription;
        task.completed = completed;
        task.userName = userName;
        head = task;
        tail = task;
        size = 1;
        return head;
    }

    public void insertNewTask(String taskDescription, Boolean completed, int location, String userName, Users users) {

        Task task = new Task();
        task.description = taskDescription;
        task.completed = completed;
        task.userName = userName;

        if(head == null) {
            createToDoList(taskDescription, completed, userName, users);
            return;
        } else if (location == 0) {
            task.nextTask = head;
            head = task;
        } else if (location >= size) {
            tail.nextTask = task;
            tail = task;
        } else {
            Task tempTask = head;
            int index = 0;
            while (index < location -1) {
                tempTask = tempTask.nextTask;
                index++;
            }
            task.nextTask = tempTask.nextTask;
            tempTask.nextTask = task;
        }
        size++;
    }

    public void traverseToDoList() {
        if (head == null) {
            System.out.println("To-do list doesn't exist");
            return;
        }
            Task tempTask = head;
            while (tempTask != null) {
                System.out.println(tempTask.description + (tempTask.completed ? " - completed" : " - pending"));
                tempTask = tempTask.nextTask;
            }
            System.out.println();
        }

    public void deleteTask(int location) {
        if (head == null) {
            System.out.println("To-do list doesn't exist");
            return;
        }
        if (location == 0) {
            head = head.nextTask;
        } else if (location >= size) {
            Task tempTask = head;
            for (int i = 0; i < size - 1; i++) {
                tempTask = tempTask.nextTask;
            }
            tempTask.nextTask = null;
            tail = tempTask;
        } else {
            Task prevTask = head;
            int index = 0;
            while (index < location - 1) {
                prevTask = prevTask.nextTask;
                index++;
            }
            Task task = prevTask.nextTask;
            prevTask.nextTask = task.nextTask;
        }
        size--;
    }


    public void changeTaskStatus (String taskDescription, Boolean isCompleted) {
        Task tempTask = head;
        while (tempTask != null) {
            if(tempTask.description.equalsIgnoreCase(taskDescription)) {
                tempTask.completed = isCompleted;
                return;
            }
            tempTask = tempTask.nextTask;
        }
        System.out.println("Task not found");
    }


}
