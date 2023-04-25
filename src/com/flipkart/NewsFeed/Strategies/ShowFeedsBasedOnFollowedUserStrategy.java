package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.FeedRepository;

import java.util.List;

public class ShowFeedsBasedOnFollowedUserStrategy implements ShowFeedBasedOnOptionSortingStrategy{
    private FeedRepository _feedRepository;
    public ShowFeedsBasedOnFollowedUserStrategy(FeedRepository feedRepository)
    {
        _feedRepository = feedRepository;
    }
    @Override
    public List<Feed> Sort() {
        return null;
    }
}
