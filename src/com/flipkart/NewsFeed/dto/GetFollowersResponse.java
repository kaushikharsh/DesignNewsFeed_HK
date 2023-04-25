package com.flipkart.NewsFeed.dto;

import java.util.ArrayList;
import java.util.List;

public class GetFollowersResponse {
    public void setFollowersNames(List<String> followersNames) {
        FollowersNames = followersNames;
    }

    public void setFollowingNames(List<String> followingNames) {
        FollowingNames = followingNames;
    }

    public void setNoOfFollowers(int noOfFollowers) {
        NoOfFollowers = noOfFollowers;
    }


    public List<String> getFollowersNames() {
        return FollowersNames;
    }

    public List<String> getFollowingNames() {
        return FollowingNames;
    }

    public int getNoOfFollowers() {
        return NoOfFollowers;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // private String userName;
    private Long userId;
    private List<String> FollowersNames;
    private List<String> FollowingNames;
    private int NoOfFollowers;

    public GetFollowersResponse()
    {
        FollowersNames = new ArrayList<>();
        FollowingNames = new ArrayList<>();
    }
}
