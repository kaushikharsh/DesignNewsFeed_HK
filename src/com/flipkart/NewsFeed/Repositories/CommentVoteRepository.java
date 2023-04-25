package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.dto.VoteRequest;

import java.util.HashMap;
import java.util.List;

public class CommentVoteRepository extends VoteRepository{

    private FeedRepository _feedRepository;
    public CommentVoteRepository(FeedRepository feedRepository)
    {
        _feedRepository = feedRepository;
    }

    @Override
    public Feed Vote(VoteRequest voteRequest) {
        return null;
    }
}
//    HashMap<Long,List<User>> UpVotes = new HashMap<>();  // Number of Users had given Votes to the comment
//    HashMap<Long,List<User>> DownVotes = new HashMap<>(); //Number of User had Given Down Votes to the Comment