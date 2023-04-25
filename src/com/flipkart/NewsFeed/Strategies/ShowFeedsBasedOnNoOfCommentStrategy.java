package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.FeedRepository;

import java.util.List;

public class ShowFeedsBasedOnNoOfCommentStrategy implements ShowFeedBasedOnOptionSortingStrategy {

    private FeedRepository _feedRepository;
    public ShowFeedsBasedOnNoOfCommentStrategy(FeedRepository feedRepository) {
        _feedRepository = feedRepository;
    }

    @Override
    public List<Feed> Sort() {
        return null;
    }
}
