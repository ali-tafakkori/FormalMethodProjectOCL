package withOCL;

import java.time.LocalDateTime;

public class Session {
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // OCL: Precondition: No active session for user.
    // OCL: Postcondition: Session started.
    public Session(User user) {
        if (user.isLoggedIn()) {
            throw new IllegalStateException("User already has an active session.");
        }
        this.user = user;
        this.startTime = LocalDateTime.now();
        this.endTime = null;
    }

    // OCL: Precondition: Session must be active.
    // OCL: Postcondition: Session ended.
    public void endSession() {
        if (endTime != null) {
            throw new IllegalStateException("Session already ended.");
        }
        this.endTime = LocalDateTime.now();
    }

    public boolean isActive() {
        return endTime == null;
    }

    public User getUser() {
        return user;
    }
}
