package com.flipkart.NewsFeed.Services;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.CommentRepository;
import com.flipkart.NewsFeed.dto.CommentRequest;
import com.flipkart.NewsFeed.dto.CommentResponse;

public class CommentService {

    private CommentRepository _commentRepository;
    public CommentService(CommentRepository commentRepository)
    {
        _commentRepository = commentRepository;
    }

    public CommentResponse PostComment(CommentRequest commentRequest)
    {
        CommentResponse commentResponse = new CommentResponse();
        Feed feed = _commentRepository.CommentOnPost(commentRequest);
        commentResponse.setFeed(feed);
        return commentResponse;
    }
}
