package com.flipkart.NewsFeed.Models;

import java.time.LocalDateTime;

public class Reply extends BaseModel {
    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public LocalDateTime getWhenIsReplied() {
        return WhenIsReplied;
    }

    public void setWhenIsReplied(LocalDateTime whenIsReplied) {
        WhenIsReplied = whenIsReplied;
    }

    public Long getCommentID() {
        return CommentID;
    }

    public void setCommentID(Long commentID) {
        CommentID = commentID;
    }

    public String getCommentReplyContent() {
        return CommentReplyContent;
    }

    public void setCommentReplyContent(String commentReplyContent) {
        CommentReplyContent = commentReplyContent;
    }

    private Long UserId;
    private LocalDateTime WhenIsReplied;
    private Long CommentID;
    private String CommentReplyContent; // Right now Taking Text only for Minimal Viable Design

}
