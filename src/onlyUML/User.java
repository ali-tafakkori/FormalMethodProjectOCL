package onlyUML;

import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String password;
    private boolean isLoggedIn;
    private List<OTP> otps = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }

    public boolean login(String password) {
        if (this.password.equals(password)) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        this.isLoggedIn = false;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public List<OTP> getOtps() {
        return otps;
    }

    public void addOtp(OTP otp) {
        otps.add(otp);
    }
}
