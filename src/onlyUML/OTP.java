package onlyUML;

import java.time.LocalDateTime;

class OTP {
    private String code;
    private boolean isUsed;
    private LocalDateTime generatedAt;

    public OTP(String code) {
        this.code = code;
        this.isUsed = false;
        this.generatedAt = LocalDateTime.now();
    }

    public boolean validateOTP(String inputCode) {
        return this.code.equals(inputCode) && !isUsed && isValid();
    }

    private boolean isValid() {
        LocalDateTime expiryTime = this.generatedAt.plusMinutes(5);
        return LocalDateTime.now().isBefore(expiryTime);
    }

    public void markAsUsed() {
        this.isUsed = true;
    }

    public String getCode() {
        return code;
    }

    public boolean isUsed() {
        return isUsed;
    }
}
