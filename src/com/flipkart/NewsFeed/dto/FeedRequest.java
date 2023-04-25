package com.flipkart.NewsFeed.dto;

import com.flipkart.NewsFeed.Models.Comment;
import com.flipkart.NewsFeed.Models.User;

import java.util.Map;

public class FeedRequest {
    public String getText() {
        return Text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setText(String text) {
        Text = text;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private String Text; // we are considering only Text Feed Now FOR MINIMAL VIABLE PRODUCT
    private Long userId;
}
