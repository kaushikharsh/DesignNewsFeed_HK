package com.flipkart.NewsFeed.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class LoginResponse
{
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public LocalDateTime getSessionTime() {
        return SessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        SessionTime = sessionTime;
    }

    private Long sessionId;
    private Long UserId;
    private LocalDateTime SessionTime;

}
