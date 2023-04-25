package com.flipkart.NewsFeed.dto;

public class CommentRequest {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getFeedId() {
        return FeedId;
    }

    public void setFeedId(Long feedId) {
        FeedId = feedId;
    }

    private String text;
    private Long FeedId; //The Feed that is commented By Some Other User

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    private Long UserId; // Feed Posted By This User

    public Long getCommentDoneByUser() {
        return CommentDoneByUser;
    }

    public void setCommentDoneByUser(Long commentDoneByUser) {
        CommentDoneByUser = commentDoneByUser;
    }

    private Long CommentDoneByUser;
}
