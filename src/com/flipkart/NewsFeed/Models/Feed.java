package com.flipkart.NewsFeed.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feed extends BaseModel
{
    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getNo_Of_UpVotes() {
        return No_Of_UpVotes;
    }

    public void setNo_Of_UpVotes(int no_Of_UpVotes) {
        No_Of_UpVotes = no_Of_UpVotes;
    }

    public int getNo_Of_DownVotes() {
        return No_Of_DownVotes;
    }

    public void setNo_Of_DownVotes(int no_Of_DownVotes) {
        No_Of_DownVotes = no_Of_DownVotes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getPostedAt() {
        return PostedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        PostedAt = postedAt;
    }

    private LocalDateTime PostedAt;
    private String Text; // we are considering only Text Feed Now FOR MINIMAL VIABLE PRODUCT
    private List<Comment> comments;
    private int No_Of_UpVotes;
    private int No_Of_DownVotes;
    private Long userId;

    public Feed()
    {
        comments = new ArrayList<>();
    }
}
