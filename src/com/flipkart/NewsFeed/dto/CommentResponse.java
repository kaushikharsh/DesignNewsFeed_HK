package com.flipkart.NewsFeed.dto;

import com.flipkart.NewsFeed.Models.Feed;

public class CommentResponse {
    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    private Feed feed; // we can return the Feed with the comments that is added on the Feed By the user.
}
