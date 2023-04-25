package com.flipkart.NewsFeed.dto;

public class GetFollowersRequest {
    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    private Long UserId;
}
