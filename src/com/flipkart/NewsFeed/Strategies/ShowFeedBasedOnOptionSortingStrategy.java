package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Models.Feed;

import java.util.List;

public interface ShowFeedBasedOnOptionSortingStrategy {
    List<Feed> Sort(Long UserId);
}
