package com.flipkart.NewsFeed.Controllers;

import com.flipkart.NewsFeed.Services.CommentService;
import com.flipkart.NewsFeed.dto.CommentRequest;
import com.flipkart.NewsFeed.dto.CommentResponse;
import com.flipkart.NewsFeed.dto.FeedResponse;

public class CommentController {
    private CommentService _commentService;
    public CommentController(CommentService commentService)
    {
        _commentService = commentService;
    }
    public CommentResponse postCommentOnFeed(CommentRequest commentRequest)
    {
        return _commentService.PostComment(commentRequest);
    }
}
