package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Models.Vote;
import com.flipkart.NewsFeed.Models.VoteType;
import com.flipkart.NewsFeed.dto.VoteRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeedVoteRepository extends VoteRepository{
    private FeedRepository _feedRepository;
    public FeedVoteRepository(FeedRepository feedRepository)
    {
        _feedRepository = feedRepository;
    }

    @Override
    public Feed Vote(VoteRequest voteRequest) {
        //get the feed
        Feed DbFeed = _feedRepository.getFedByFeedId(voteRequest.getFeedId(),voteRequest.getWhoPostedThisFeedId());

        //add a vote to the Feed //means create Object in Vote and also increase the no. of likes
        //check if user is already voted
        if(!UserVotes.containsKey(voteRequest.getUserId()))
        {
            Vote v = new Vote();
            v.setId(1L);
            if(voteRequest.isLike()) {
                v.setVoteType(VoteType.UPVOTE);
                DbFeed.setNo_Of_UpVotes(DbFeed.getNo_Of_UpVotes() + 1);
            }
            else
            {
                v.setVoteType(VoteType.DOWNVOTE);
                DbFeed.setNo_Of_DownVotes(DbFeed.getNo_Of_DownVotes() + 1);
            }
            v.setUserId(voteRequest.getUserId());
            v.setPostId(DbFeed.getId());
            List<Vote> Votes = new ArrayList<>();
            Votes.add(v);
            UserVotes.put(voteRequest.getUserId(), Votes);
            //Adding Feed into the DB
            _feedRepository.AddFeedToDb(DbFeed, voteRequest.getWhoPostedThisFeedId());
            return _feedRepository.getFedByFeedId(voteRequest.getFeedId(),voteRequest.getWhoPostedThisFeedId());
        }
        List<Vote> Votes = UserVotes.get(voteRequest.getUserId());
        Vote v = new Vote();
        v.setId(Votes.get(Votes.size() - 1).getId() + 1);
        if(voteRequest.isLike()) {
            v.setVoteType(VoteType.UPVOTE);
            DbFeed.setNo_Of_UpVotes(DbFeed.getNo_Of_UpVotes() + 1);
        }
        else
        {
            v.setVoteType(VoteType.DOWNVOTE);
            DbFeed.setNo_Of_DownVotes(DbFeed.getNo_Of_DownVotes() + 1);
        }
        v.setUserId(voteRequest.getUserId());
        v.setPostId(DbFeed.getId());
        Votes.add(v);
        UserVotes.replace(voteRequest.getUserId(), Votes);
        _feedRepository.AddFeedToDb(DbFeed, voteRequest.getWhoPostedThisFeedId());
        //return the updated Feed
        return _feedRepository.getFedByFeedId(voteRequest.getFeedId(),voteRequest.getWhoPostedThisFeedId());
    }
}
