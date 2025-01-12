package withOCL;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<User> users;

    public Admin() {
        this.users = new ArrayList<>();
    }

    // OCL: Precondition: Username and password must not be empty.
    // OCL: Postcondition: User is created and added.
    public User createUser(String username, String password) {
        User user = new User(username, password);
        users.add(user);
        return user;
    }

    // OCL: Precondition: User must exist in the list.
    // OCL: Postcondition: User is removed.
    public void deleteUser(User user) {
        if (!users.contains(user)) {
            throw new IllegalArgumentException("User not found.");
        }
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
