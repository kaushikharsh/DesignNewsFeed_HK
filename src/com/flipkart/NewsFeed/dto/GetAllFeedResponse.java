package com.flipkart.NewsFeed.dto;

import com.flipkart.NewsFeed.Models.Comment;
import com.flipkart.NewsFeed.Models.Feed;

import java.util.List;

public class GetAllFeedResponse {
    public Long getFeedId() {
        return FeedId;
    }

    public void setFeedId(Long feedId) {
        FeedId = feedId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public List<Comment> getComments() {
        return Comments;
    }

    public void setComments(List<Comment> comments) {
        Comments = comments;
    }

    public int getNoOfLikes() {
        return NoOfLikes;
    }

    public void setNoOfLikes(int noOfLikes) {
        NoOfLikes = noOfLikes;
    }

    public int getNoOfDislikes() {
        return NoOfDislikes;
    }

    public void setNoOfDislikes(int noOfDislikes) {
        NoOfDislikes = noOfDislikes;
    }

    public Long getWhoPostedThisFeed() {
        return WhoPostedThisFeed;
    }

    public void setWhoPostedThisFeed(Long whoPostedThisFeed) {
        WhoPostedThisFeed = whoPostedThisFeed;
    }

    private Long FeedId;
    private String Content;
    private List<Comment> Comments;
    private int NoOfLikes;
    private int NoOfDislikes;
    private Long WhoPostedThisFeed;
}
