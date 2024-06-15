package TaskManager;
import java.util.Arrays;

public class Users {
    int[] userArr = null;

    public Users(int sizeOfArray) {
        userArr = new int[sizeOfArray];
        for (int i = 0; i < userArr.length; i++) {
            userArr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, String userName) {
        try {
            if (userArr[location] == Integer.MIN_VALUE) {
                    if (isUniqueName(userName)) {
                        userArr[location] = Integer.parseInt(userName);
                        System.out.println("User successfully inserted");
                    } else {
                        System.out.println("Username already exists");
                    }
            } else {
                System.out.println("Cell already occudied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array: " + e);
        }
    }

    private boolean isUniqueName (String userName) {
        int userNameInt = Integer.parseInt(userName);
        for (int value : userArr) {
            if (value == userNameInt) {
                return false;
            }
        }
        return true;
    }

    public void traverseUsers() {
        for (int i = 0; i < userArr.length; i++) {
            System.out.println(userArr[i]);
        }
    }



}
