package com.flipkart.NewsFeed.Services;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Repositories.FeedRepository;
import com.flipkart.NewsFeed.Strategies.ShowFeedBasedOnOptionFactory;
import com.flipkart.NewsFeed.Strategies.ShowFeedBasedOnOptionSortingStrategy;
import com.flipkart.NewsFeed.dto.*;

import java.util.ArrayList;
import java.util.List;

public class FeedService {

    private SessionService _sessionService;
    private FeedRepository _feedRepository;
    private ShowFeedBasedOnOptionFactory _showFeedBasedOnOptionFactory;

    public FeedService(SessionService sessionService,FeedRepository feedRepository,ShowFeedBasedOnOptionFactory showFeedBasedOnOptionFactory)
    {
        _sessionService = sessionService;
        _feedRepository = feedRepository;
        _showFeedBasedOnOptionFactory = showFeedBasedOnOptionFactory;
    }
    public FeedResponse feedPost(FeedRequest feedRequest)
    {
        if(_sessionService.GetSessionByUser(feedRequest.getUserId()) == null){
            System.out.println("User is not Logged In , You must be login to Create A Post!!!");
            return null;
        }
        Feed feed = _feedRepository.createFeed(feedRequest);
        FeedResponse feedResponse = new FeedResponse();
        feedResponse.setFeed(feed);
        return feedResponse;
    }
    public List<GetAllFeedResponse> getAllFeedPostedByUser(GetALLFeedRequest getAllFeedRequest)
    {
        List<GetAllFeedResponse> getAllFeedResponses = new ArrayList<>();
        List<Feed> feeds = _showFeedBasedOnOptionFactory.getShowFeedBasedOnOption(getAllFeedRequest.getOptions()).Sort(getAllFeedRequest.getUserId());
        for(Feed f : feeds)
        {
            GetAllFeedResponse getAllFeedResponse  = new GetAllFeedResponse();
            getAllFeedResponse.setFeedId(f.getId());
            getAllFeedResponse.setWhoPostedThisFeed(f.getUserId());
            getAllFeedResponse.setContent(f.getText());
            getAllFeedResponse.setComments(f.getComments());
            getAllFeedResponse.setNoOfLikes(f.getNo_Of_UpVotes());
            getAllFeedResponse.setNoOfDislikes(f.getNo_Of_DownVotes());
            getAllFeedResponses.add(getAllFeedResponse);
        }
        return getAllFeedResponses;
    }
    //getAllFeeds OF The User Followed By this.user (Current User)
    public List<Feed> getAllFeedOfTheUserById(Long UserId)
    {
       return _feedRepository.getAllFeedsForUserWhoHavePosted(UserId);
    }


}
