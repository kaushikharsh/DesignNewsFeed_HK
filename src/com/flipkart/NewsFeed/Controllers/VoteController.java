package com.flipkart.NewsFeed.Controllers;

import com.flipkart.NewsFeed.Services.VoteService;
import com.flipkart.NewsFeed.dto.VoteRequest;
import com.flipkart.NewsFeed.dto.VoteResponse;

public class VoteController {
    private VoteService _voteService;
    public VoteController(VoteService voteService)
    {
        _voteService = voteService;
    }

    public VoteResponse VoteFeed(VoteRequest voteRequest)
    {
        return _voteService.VoteFeedOrPost(voteRequest);
    }
}
