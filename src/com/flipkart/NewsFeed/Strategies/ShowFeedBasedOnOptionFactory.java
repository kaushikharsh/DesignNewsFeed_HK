package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Repositories.FeedRepository;
import com.flipkart.NewsFeed.Repositories.FollowRepository;
import com.flipkart.NewsFeed.dto.GetALLFeedRequest;
import com.flipkart.NewsFeed.dto.OptionRequest;

public class ShowFeedBasedOnOptionFactory {

    private FeedRepository _feedRepository;
    private FollowRepository _followRepository;
    public ShowFeedBasedOnOptionFactory(FeedRepository feedRepository, FollowRepository followRepository)
    {

        _feedRepository = feedRepository;
        _followRepository = followRepository;
    }
    public ShowFeedBasedOnOptionSortingStrategy getShowFeedBasedOnOption(OptionRequest optionRequest)
    {
        return (switch (optionRequest)
        {
            case FollowedUser -> new ShowFeedsBasedOnFollowedUserStrategy(_feedRepository,_followRepository);
            case NOOFCOMMENTS -> new ShowFeedsBasedOnNoOfCommentStrategy(_feedRepository);
            case SCORE -> new ShowFeedsBasedOnScoreStrategy(_feedRepository);
            case TIMESTAMP -> new  ShowFeedsBasedOnTimeStampStrategy(_feedRepository);
        });
    }
}
