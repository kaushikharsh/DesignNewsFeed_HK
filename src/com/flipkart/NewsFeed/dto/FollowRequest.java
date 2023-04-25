package com.flipkart.NewsFeed.dto;

import com.flipkart.NewsFeed.Models.User;

public class FollowRequest {
    public void setUserToBeFollowed(Long userToBeFollowed) {
        UserToBeFollowed = userToBeFollowed;
    }

    public void setUserFollowed(Long userFollowed) {
        UserFollowed = userFollowed;
    }

    public Long getUserToBeFollowed() {
        return UserToBeFollowed;
    }

    public Long getUserFollowed() {
        return UserFollowed;
    }

    private Long UserToBeFollowed;   //User1  will be following by User2
    private Long UserFollowed;      //User2
}
