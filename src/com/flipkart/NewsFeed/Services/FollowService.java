package com.flipkart.NewsFeed.Services;

import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.Repositories.FollowRepository;
import com.flipkart.NewsFeed.dto.FollowRequest;
import com.flipkart.NewsFeed.dto.GetFollowersRequest;
import com.flipkart.NewsFeed.dto.GetFollowersResponse;

import java.util.ArrayList;
import java.util.List;

public class FollowService {
    private FollowRepository _followRepository;
    public FollowService(FollowRepository followRepository)
    {
        _followRepository = followRepository;
    }

    public void FollowUser(FollowRequest followRequest)
    {
        _followRepository.followUser(followRequest.getUserToBeFollowed(),followRequest.getUserFollowed());
    }

    public GetFollowersResponse getFollowersById(GetFollowersRequest getFollowersRequest) {
        List<User> userFollowers = _followRepository.getAllUserFollowers(getFollowersRequest.getUserId());
        List<User> userFollowing =  _followRepository.getAllUserFollowing(getFollowersRequest.getUserId());
        GetFollowersResponse getFollowersResponse = new GetFollowersResponse();
        getFollowersResponse.setUserId(getFollowersRequest.getUserId());
        List<String>  Followers = new ArrayList<>();
        for(User u : userFollowers)
        {
            Followers.add(u.getName());
        }
        getFollowersResponse.setFollowersNames(Followers);
        List<String> Following = new ArrayList<>();
        for(User u : userFollowing)
        {
            Following.add(u.getName());
        }
        getFollowersResponse.setFollowingNames(Following);
        getFollowersResponse.setNoOfFollowers(Followers.size());
        return getFollowersResponse;
    }
}
