package com.flipkart.NewsFeed.dto;

public class VoteRequest {
    public void setFeedId(Long feedId) {
        FeedId = feedId;
    }

    public Long getFeedId() {
        return FeedId;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getWhoPostedThisFeedId() {
        return WhoPostedThisFeedId;
    }

    public void setWhoPostedThisFeedId(Long whoPostedThisFeedId) {
        WhoPostedThisFeedId = whoPostedThisFeedId;
    }

    private Long WhoPostedThisFeedId ;
    private boolean like;
    private Long UserId;  // Get the User WHo Posted the Feed
    private Long FeedId;  // Get the Feed Id which we are looking for to like it

}
