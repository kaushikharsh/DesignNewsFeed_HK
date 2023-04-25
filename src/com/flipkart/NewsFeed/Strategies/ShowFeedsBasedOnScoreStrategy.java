package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.FeedRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShowFeedsBasedOnScoreStrategy implements ShowFeedBasedOnOptionSortingStrategy {

    private FeedRepository _feedRepository;
    public ShowFeedsBasedOnScoreStrategy(FeedRepository feedRepository) {
        _feedRepository = feedRepository;
    }

    @Override
    public List<Feed> Sort(Long UserId) {
        List<Feed> DbFeeds = _feedRepository.getAllFeedsForUserWhoHavePosted(UserId);
        Collections.sort(DbFeeds,(Feed f1,Feed f2) -> {
            if((f1.getNo_Of_UpVotes() - f1.getNo_Of_DownVotes()) > (f2.getNo_Of_UpVotes() - f2.getNo_Of_DownVotes()))
                return -1;
            else
                return 1;
        });
        return DbFeeds;
    }
}
