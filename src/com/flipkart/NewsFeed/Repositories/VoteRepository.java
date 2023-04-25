package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Models.Vote;
import com.flipkart.NewsFeed.dto.VoteRequest;

import java.util.HashMap;
import java.util.List;

public abstract class VoteRepository {
    HashMap<Long, List<Vote>> UserVotes = new HashMap<>();  // User ->  List<Votes>  that he did on a post by other Users
    public abstract Feed Vote(VoteRequest voteRequest);
}
