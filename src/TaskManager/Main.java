package TaskManager;

public class Main {
    public static void main(String[] args) {
        Users users = new Users(5);
        users.insert(0, "User1");
        users.insert(1, "User2");
        users.insert(2, "User3");
        users.traverseUsers();

        TaskList taskList = new TaskList();
        taskList.createToDoList("make appointment for car", true, "User1", users);
        taskList.insertNewTask("buy milk", false, 1, "User2", users);
        taskList.insertNewTask("call bank", false, 2, "User2", users);
        taskList.insertNewTask("call school", true, 3, "User2", users);
        taskList.insertNewTask("go to the dump", false, 4, "User2", users);
        taskList.insertNewTask("visit dentist", false, 5, "User2", users);

        taskList.changeTaskStatus("Buy Milk", true);

        taskList.traverseToDoList();
        TaskList user2List = taskList.searchTasksByUser("User2", users);
        System.out.println("To-Do List for User2");
        user2List.traverseToDoList();


        System.out.println("To-Do List for User2");
        user2List.traverseToDoList();
        taskList.traverseToDoList();


    }
}
