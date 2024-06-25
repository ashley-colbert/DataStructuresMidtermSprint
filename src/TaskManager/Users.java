package TaskManager;
import java.util.Arrays;

public class Users {
    User[] userArr = null;


    public Users(int sizeOfArray) {
        userArr = new User[sizeOfArray];
    }

    public void insert(int location, String userName) {
        try {
            if (userArr[location] == null) {
                    if (isUniqueName(userName)) {
                        userArr[location] = new User(userName);
                        System.out.println("User successfully inserted");
                    } else {
                        System.out.println("Username already exists");
                    }
            } else {
                System.out.println("Cell already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array: " + e);
        }
    }


    private boolean isUniqueName(String userName) {
        for (User user : userArr) {
            if (userName.equals(user)) {
                return false;
            }
        }
        return true;
    }

    public int searchUsername(String userName) {
        for(int i = 0; i < userArr.length; i ++) {
            if(userName.equals(userArr[i].getUserName())) {
                return i;
            }
        }
        return -1;
    }

    public TaskList getUserTaskList(String userName) {
        int index = searchUsername(userName);
        if (index != -1) {
            return userArr[index].getTaskList();
        }
        System.out.println("User not found: " + userName);
        return null;
    }

    public void traverseUsers() {
        for (User user : userArr) {
            System.out.println(user != null ? user.getUserName() : "Empty");
        }
    }

}
