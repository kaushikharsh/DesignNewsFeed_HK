package com.flipkart.NewsFeed.dto;

import com.flipkart.NewsFeed.Models.Comment;

import java.util.List;

public class VoteResponse {
    public Long getFeedId() {
        return FeedId;
    }

    public void setFeedId(Long feedId) {
        FeedId = feedId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getFeedContent() {
        return FeedContent;
    }

    public void setFeedContent(String feedContent) {
        FeedContent = feedContent;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getNoOFLikes() {
        return NoOFLikes;
    }

    public void setNoOFLikes(int noOFLikes) {
        NoOFLikes = noOFLikes;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getNoOfDislikes() {
        return NoOfDislikes;
    }

    public void setNoOfDislikes(int noOfDislikes) {
        NoOfDislikes = noOfDislikes;
    }

    private Long FeedId;  //id of the POST which User Liked
    private Long UserId;  // Feed Posted By this User
    private String FeedContent; //Only Considering Text Content Right now
    private List<Comment> comments;  // Comments on the Post // we have number of likes/Dislikes In Comment as well
    private int NoOFLikes;         // likes on the Post
    private int NoOfDislikes;   //No of DownVotes On the Post
    private String Message;      // Message ->  for ex -> Post Liked or Unliked By This User
}
