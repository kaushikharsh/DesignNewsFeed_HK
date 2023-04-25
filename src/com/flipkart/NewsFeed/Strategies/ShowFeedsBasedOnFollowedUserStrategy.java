package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.Repositories.FeedRepository;
import com.flipkart.NewsFeed.Repositories.FollowRepository;

import java.util.ArrayList;
import java.util.List;

public class ShowFeedsBasedOnFollowedUserStrategy implements ShowFeedBasedOnOptionSortingStrategy{
    private FeedRepository _feedRepository;
    private FollowRepository _followRepository;
    public ShowFeedsBasedOnFollowedUserStrategy(FeedRepository feedRepository,FollowRepository followRepository)
    {
        _feedRepository = feedRepository;
        _followRepository = followRepository;
    }

    @Override
    public List<Feed> Sort(Long UserId) {
        List<User> DbFollowingUserByUserId = _followRepository.getAllUserFollowing(UserId);  // Get the Following Users
        List<Feed> FollowedUserFeeds = new ArrayList<>();
        for(User u : DbFollowingUserByUserId)
        {
            List<Feed> DbFeedsOfUser = _feedRepository.getAllFeedsForUserWhoHavePosted(u.getId());  // Add all the following user Feeds to the Feeds that we have to return
            FollowedUserFeeds.addAll(DbFeedsOfUser);
        }
        List<Feed> CurrentUserFeed = _feedRepository.getAllFeedsForUserWhoHavePosted(UserId);
        FollowedUserFeeds.addAll(CurrentUserFeed);    // Now Add all the Feed of current Ussr As well, after the User Following.
        return FollowedUserFeeds;
    }
}
