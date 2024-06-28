package TaskManager;

public class Main {
    public static void main(String[] args) {
        //Add users to an array.
        Users users = new Users(5);
        users.insert(0, "User1");
        users.insert(1, "User2");
        users.insert(2, "User3");
        System.out.println();

        //print the user array
        System.out.println("User array:");
        users.traverseUsers();
        System.out.println();

        //create a task list(single dimension linked list) for User1
        TaskList user1TaskList = users.getUserTaskList("User1");

        //Load User1's tasks
        user1TaskList.createToDoList("Task 1", false, "User1", users);
        user1TaskList.insertNewTask("Task 2", true, 1, "User1", users);

        System.out.println("User1 To-Do List:");
        //Print User1's tasks
        user1TaskList.traverseToDoList();
        System.out.println();

        //Create User2's task list
        TaskList user2TaskList = users.getUserTaskList("User2");

        //Add tasks to User2's list
        user2TaskList.createToDoList("buy milk", false, "User2", users);
        user2TaskList.insertNewTask("call bank", false, 1, "User2", users);
        user2TaskList.insertNewTask("call school", true, 2, "User2", users);
        user2TaskList.insertNewTask("go to the dump", false, 3, "User2", users);
        user2TaskList.insertNewTask("visit dentist", false, 4, "User2", users);

        System.out.println("User2 To-Do List:");
        //Print user2's list
        user2TaskList.traverseToDoList();
        System.out.println();

        //Change the status of a task from pending to completed
        user2TaskList.changeTaskStatus("go to the dump", true);

        System.out.println("User 2 To-Do List with the status of 'go to dump' changed to 'completed':");
        //reprint the list with the status changed
        user2TaskList.traverseToDoList();

    }
}
