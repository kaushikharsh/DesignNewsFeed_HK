package com.flipkart.NewsFeed.Models;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment extends BaseModel{
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Long getFeedId() {
        return FeedId;
    }

    public void setFeedId(Long feedId) {
        FeedId = feedId;
    }

    public LocalDateTime getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDateTime commentedAt) {
        this.commentedAt = commentedAt;
    }

    public int getNoOFLikes() {
        return NoOFLikes;
    }

    public void setNoOFLikes(int noOFLikes) {
        NoOFLikes = noOFLikes;
    }

    public int getNoOfDislike() {
        return NoOfDislike;
    }

    public void setNoOfDislike(int noOfDislike) {
        NoOfDislike = noOfDislike;
    }
    private String text;
    private Long userId;
    private String UserName;
    private Long FeedId;
    private LocalDateTime commentedAt;
    private int NoOFLikes;
    private int NoOfDislike;
}
