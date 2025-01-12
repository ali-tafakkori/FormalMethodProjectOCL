package onlyUML;

public class Main {
    public static void main(String[] args) {
        // ایجاد یک ادمین
        Admin admin = new Admin("admin1", "password123", true);

        // ایجاد یک کاربر
        User user = admin.createUser("user1", "user123");

        // کاربر ورود می‌کند
        boolean loginSuccess = user.login("user123");
        System.out.println("Login successful: " + loginSuccess);

        // تولید و اضافه کردن onlyUML.OTP
        OTP otp = new OTP("123456");
        user.addOtp(otp);

        // بررسی و استفاده از onlyUML.OTP
        boolean otpValid = otp.validateOTP("123456");
        System.out.println("onlyUML.OTP valid: " + otpValid);

        if (otpValid) {
            otp.markAsUsed();
        }

        // ایجاد یک نشست برای کاربر
        Session session = new Session("session1", user);
        System.out.println("onlyUML.Session active: " + session.isActive());

        // پایان دادن به نشست
        session.endSession();
        System.out.println("onlyUML.Session active after end: " + session.isActive());
    }
}
