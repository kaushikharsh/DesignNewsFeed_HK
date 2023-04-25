package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.FeedRepository;

import java.util.List;

public class ShowFeedsBasedOnScoreStrategy implements ShowFeedBasedOnOptionSortingStrategy {
    public ShowFeedsBasedOnScoreStrategy(FeedRepository feedRepository) {
    }

    @Override
    public List<Feed> Sort() {
        return null;
    }
}
