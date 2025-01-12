package onlyUML;

import java.util.ArrayList;
import java.util.List;

class Admin {
    private String username;
    private String password;
    private boolean isSuperAdmin;
    private List<User> users = new ArrayList<>();

    public Admin(String username, String password, boolean isSuperAdmin) {
        this.username = username;
        this.password = password;
        this.isSuperAdmin = isSuperAdmin;
    }

    public User createUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void resetUserPassword(User user, String newPassword) {
        user.updatePassword(newPassword);
    }

    public List<User> getUsers() {
        return users;
    }
}
