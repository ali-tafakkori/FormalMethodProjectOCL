package onlyUML;

import java.time.LocalDateTime;

class Session {
    private String sessionId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private User user;

    public Session(String sessionId, User user) {
        this.sessionId = sessionId;
        this.user = user;
        this.startTime = LocalDateTime.now();
    }

    public void endSession() {
        this.endTime = LocalDateTime.now();
    }

    public boolean isActive() {
        return endTime == null || LocalDateTime.now().isBefore(endTime);
    }

    public String getSessionId() {
        return sessionId;
    }

    public User getUser() {
        return user;
    }
}
