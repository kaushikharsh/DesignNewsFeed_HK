package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.FeedRepository;

import java.util.Collections;
import java.util.List;

public class ShowFeedsBasedOnTimeStampStrategy implements ShowFeedBasedOnOptionSortingStrategy {

    private FeedRepository _feedRepository;
    public ShowFeedsBasedOnTimeStampStrategy(FeedRepository feedRepository) {
        _feedRepository = feedRepository;
    }

    @Override
    public List<Feed> Sort(Long UserId) {
        List<Feed> DbFeeds = _feedRepository.getAllFeedsForUserWhoHavePosted(UserId);
        Collections.sort(DbFeeds,(Feed f1, Feed f2) -> {
            if((f1.getPostedAt()).isBefore(f2.getPostedAt()))
                return -1;
            else
                return 1;
        });
        return DbFeeds;
    }
}
