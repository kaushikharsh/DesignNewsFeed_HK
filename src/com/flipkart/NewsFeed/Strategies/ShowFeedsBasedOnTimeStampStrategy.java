package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.FeedRepository;

import java.util.List;

public class ShowFeedsBasedOnTimeStampStrategy implements ShowFeedBasedOnOptionSortingStrategy {
    public ShowFeedsBasedOnTimeStampStrategy(FeedRepository feedRepository) {
    }

    @Override
    public List<Feed> Sort() {
        return null;
    }
}
