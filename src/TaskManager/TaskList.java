package TaskManager;

public class TaskList {
    public Task head;
    public Task tail;
    public int size;

    public Task createToDoList(String taskDescription, Boolean completed, String userName, Users users) {
        if (!isUser(userName, users)) {
            System.out.println(" User, " + userName + " doesn't exist");
            return null;
        }

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

    private boolean isUser(String userName, Users users) {
        return users.searchUsername(userName) != -1;
    }

    public void insertNewTask(String taskDescription, Boolean completed, int location, String userName, Users users) {
        if (!isUser(userName, users)) {
            System.out.println(" User, " + userName + " doesn't exist");
            return;
        }

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

    public TaskList searchTasksByUser(String userName, Users users) {
        TaskList userTaskList = new TaskList();
        Task tempTask = head;
        while (tempTask != null) {
            if (tempTask.userName != null && tempTask.userName.equals(userName)) {
                userTaskList.insertNewTask(tempTask.description, tempTask.completed, userTaskList.size, userName, users);
            }
            tempTask = tempTask.nextTask;
        }
        return userTaskList;
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
