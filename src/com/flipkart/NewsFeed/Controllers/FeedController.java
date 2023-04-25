package com.flipkart.NewsFeed.Controllers;

import com.flipkart.NewsFeed.Services.FeedService;
import com.flipkart.NewsFeed.dto.*;

import java.util.List;

public class FeedController {

    private FeedService _feedService;

    public FeedController(FeedService feedService)
    {
        _feedService = feedService;
    }

    public FeedResponse PostFeed(FeedRequest feedToBePost)
    {
        return _feedService.feedPost(feedToBePost);
    }

    public List<GetAllFeedResponse> GetAllFeedByUser(GetALLFeedRequest getALLFeedRequest)
    {
        return _feedService.getAllFeedPostedByUser(getALLFeedRequest);
    }

}
