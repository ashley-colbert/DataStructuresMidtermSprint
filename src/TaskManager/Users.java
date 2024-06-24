package TaskManager;
import java.util.Arrays;

public class Users {
    String[] userArr = null;
    String userName;

    public Users(int sizeOfArray) {
        userArr = new String[sizeOfArray];
        Arrays.fill(userArr, null);
    }

    public void insert(int location, String userName) {
        try {
            if (userArr[location] == null) {
                    if (isUniqueName(userName)) {
                        userArr[location] = userName;
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
        for (String user : userArr) {
            if (userName.equals(user)) {
                return false;
            }
        }
        return true;
    }

    public int searchUsername(String userName) {
        for(int i = 0; i < userArr.length; i ++) {
            if(userName.equals(userArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public void traverseUsers() {
        for (String user : userArr) {
            System.out.println(user != null ? user : "Empty");
        }
    }

}
