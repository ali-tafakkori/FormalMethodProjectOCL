package withOCL;

public class Main {
    public static void main(String[] args) {
        // ایجاد یک ادمین
        Admin admin = new Admin();
        System.out.println("Admin created.");

        // ایجاد یک کاربر توسط ادمین
        User user = admin.createUser("user1", "password123");
        System.out.println("User created: " + user);

        // کاربر ورود می‌کند
        boolean loginSuccess = user.login("password123");
        System.out.println("Login successful: " + loginSuccess);

        // تولید و اضافه کردن OTP
        OTP otp = new OTP("123456");
        System.out.println("OTP generated: " + otp);

        // بررسی و استفاده از OTP
        boolean otpValid = otp.validateOTP("123456");
        System.out.println("OTP valid: " + otpValid);

        if (otpValid) {
            otp.markAsUsed();
            System.out.println("OTP marked as used.");
        }

        // ایجاد یک نشست برای کاربر
        Session session = new Session(user);
        System.out.println("Session started for user: " + user);

        // بررسی وضعیت نشست
        System.out.println("Session active: " + session.isActive());

        // پایان دادن به نشست
        session.endSession();
        System.out.println("Session active after end: " + session.isActive());
    }
}

