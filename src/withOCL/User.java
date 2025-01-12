package withOCL;

class User {
    private String username;
    private String password;
    private boolean isLoggedIn;

    // OCL: Username and password cannot be empty.
    // OCL: Password must have at least 8 characters.
    public User(String username, String password) {
        if (username.isEmpty() || password.isEmpty() || password.length() < 8) {
            throw new IllegalArgumentException("Invalid username or password.");
        }
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }

    // OCL: Precondition: Password cannot be empty.
    // OCL: Postcondition: Logged in if password matches.
    public boolean login(String password) {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        this.isLoggedIn = this.password.equals(password);
        return this.isLoggedIn;
    }

    // OCL: Precondition: Must be logged in.
    // OCL: Postcondition: Logged out.
    public void logout() {
        if (!this.isLoggedIn) {
            throw new IllegalStateException("onlyUML.User is not logged in.");
        }
        this.isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
