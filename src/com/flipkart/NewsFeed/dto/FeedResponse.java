package com.flipkart.NewsFeed.dto;

import com.flipkart.NewsFeed.Models.Feed;

public class FeedResponse {
    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    private Feed feed;
}
