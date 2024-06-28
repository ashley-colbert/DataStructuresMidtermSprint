package TaskManager;

public class User {
    private String userName;
    private TaskList taskList;


    public User(String userName) {
        this.userName = userName;
        this.taskList = new TaskList();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}