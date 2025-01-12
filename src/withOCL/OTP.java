package withOCL;

import java.time.LocalDateTime;

public class OTP {
    private String code;
    private LocalDateTime generatedAt;
    private boolean isUsed;

    // OCL: Code must have at least 6 digits and be numeric.
    public OTP(String code) {
        if (code.length() < 6 || !code.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid OTP code.");
        }
        this.code = code;
        this.generatedAt = LocalDateTime.now();
        this.isUsed = false;
    }

    // OCL: OTP is valid for 5 minutes.
    public boolean isValid() {
        return !isUsed && generatedAt.plusMinutes(5).isAfter(LocalDateTime.now());
    }

    // OCL: Precondition: Input must not be empty.
    // OCL: Postcondition: True if code matches and is valid.
    public boolean validateOTP(String inputCode) {
        if (inputCode.isEmpty()) {
            throw new IllegalArgumentException("Input code cannot be empty.");
        }
        return this.code.equals(inputCode) && isValid();
    }

    // OCL: Precondition: OTP must be expired or used.
    // OCL: Postcondition: New OTP is generated.
    public void regenerate(String newCode) {
        if (!isUsed && isValid()) {
            throw new IllegalStateException("Current OTP is still valid.");
        }
        if (newCode.length() < 6 || !newCode.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid OTP code.");
        }
        this.code = newCode;
        this.generatedAt = LocalDateTime.now();
        this.isUsed = false;
    }

    public void markAsUsed() {
        this.isUsed = true;
    }
}
