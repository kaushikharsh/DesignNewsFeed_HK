package com.flipkart.NewsFeed.Models;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Session extends BaseModel{
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //private User user;
    private Long userId;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private LocalDateTime createdAt;
}
