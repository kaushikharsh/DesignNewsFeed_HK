package com.flipkart.NewsFeed.Controllers;

import com.flipkart.NewsFeed.Services.FollowService;
import com.flipkart.NewsFeed.dto.FollowRequest;
import com.flipkart.NewsFeed.dto.GetFollowersRequest;
import com.flipkart.NewsFeed.dto.GetFollowersResponse;

import java.util.List;

public class FollowController {

    private FollowService _followService;
    public FollowController(FollowService followService)
    {
        _followService = followService;
    }

    public void FollowUser(FollowRequest followRequest)
    {
        _followService.FollowUser(followRequest);
    }
    public GetFollowersResponse getAllFollowersByUser(GetFollowersRequest getFollowersRequest)
    {
        return _followService.getFollowersById(getFollowersRequest);
    }
}
