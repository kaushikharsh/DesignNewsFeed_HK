package com.flipkart.NewsFeed.Models;

import java.time.LocalDateTime;

public class Activity extends  BaseModel {
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

    public LocalDateTime getWhenIsVoted() {
        return WhenIsVoted;
    }

    public void setWhenIsVoted(LocalDateTime whenIsVoted) {
        WhenIsVoted = whenIsVoted;
    }

    // this class is Used for Directly Access the NoOFLikes from The DB so That we don't need to have NoOfLikes and Dislikes in Comment and Post/Feed Table
    private int NoOfLikes;
    private int NoOfDislikes;
    private LocalDateTime WhenIsVoted;
    private ActivityType ActivityType;
}
