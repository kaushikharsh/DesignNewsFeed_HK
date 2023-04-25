package com.flipkart.NewsFeed.Services;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.VoteRepository;
import com.flipkart.NewsFeed.dto.VoteRequest;
import com.flipkart.NewsFeed.dto.VoteResponse;

public class VoteService {

    private VoteRepository _iVoteRepository;  // Abstract Class Vote Repository
    public VoteService(VoteRepository iVoteRepository)
    {
        _iVoteRepository = iVoteRepository;
    }

    public VoteResponse VoteFeedOrPost(VoteRequest voteRequest)
    {
        VoteResponse voteResponse = new VoteResponse();
        Feed votedFeed = _iVoteRepository.Vote(voteRequest);
        voteResponse.setFeedId(votedFeed.getId());
        voteResponse.setComments(votedFeed.getComments());
        voteResponse.setFeedContent(votedFeed.getText());
        voteResponse.setUserId(votedFeed.getUserId());
        voteResponse.setNoOFLikes(votedFeed.getNo_Of_UpVotes());
        return voteResponse;
    }
}
