package TaskManager;

public class Main {
    public static void main(String[] args) {
        Users users = new Users(5);
        users.insert(0, "User1");
        users.insert(1, "User2");
        users.insert(2, "User3");

        users.traverseUsers();

        TaskList user1TaskList = users.getUserTaskList("User1");

        user1TaskList.createToDoList("Task 1", false, "User1", users);
        user1TaskList.insertNewTask("Task 2", true, 1, "User1", users);
        user1TaskList.traverseToDoList();


        TaskList user2TaskList = users.getUserTaskList("User2");

        user2TaskList.createToDoList("buy milk", false, "User2", users);
        user2TaskList.insertNewTask("call bank", false, 1, "User2", users);
        user2TaskList.insertNewTask("call school", true, 2, "User2", users);
        user2TaskList.insertNewTask("go to the dump", false, 3, "User2", users);
        user2TaskList.insertNewTask("visit dentist", false, 4, "User2", users);
        user2TaskList.traverseToDoList();

        user2TaskList.changeTaskStatus("go to the dump", true);
        user2TaskList.traverseToDoList();


    }
}
