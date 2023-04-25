package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.Comment;
import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.dto.CommentRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CommentRepository {

    private FeedRepository  _feedRepository;
    private UserRepository _userRepository;
    HashMap<Long, List<Comment>> CommentsOnPost = new HashMap<>();
    public CommentRepository(FeedRepository feedRepository,UserRepository userRepository)
    {
        _feedRepository = feedRepository;
        _userRepository = userRepository;
    }
    public Feed CommentOnPost(CommentRequest commentRequest)
    {
        //get the feed from the feed ID
        Feed DbFeed = _feedRepository.getFedByFeedId(commentRequest.getFeedId(),commentRequest.getUserId());
        User DbUser = _userRepository.getUserById(commentRequest.getCommentDoneByUser());

        //add the comment to the list
        List<Comment> DbComments = DbFeed.getComments(); // Currently Considering Only Single comment Done By User on the Post
        Comment c = new Comment();
        c.setId(1L);
        c.setText(commentRequest.getText());
        c.setUserId(DbUser.getId());
        c.setUserName(DbUser.getName());
        c.setFeedId(DbFeed.getId());
        c.setCommentedAt(LocalDateTime.now());
        c.setNoOFLikes(0);
        c.setNoOfDislike(0);

        //then add back to the Database
        DbComments.add(c);
        DbFeed.setComments(DbComments);
        _feedRepository.AddFeedToDb(DbFeed,commentRequest.getUserId());

        //then return the current Feed Updated Inside the DB
        return _feedRepository.getFedByFeedId(commentRequest.getFeedId(),commentRequest.getUserId());
    }
    public List<Comment> getCommentOnPost(Long PostId)
    {
        return new ArrayList<>();
    }
}
