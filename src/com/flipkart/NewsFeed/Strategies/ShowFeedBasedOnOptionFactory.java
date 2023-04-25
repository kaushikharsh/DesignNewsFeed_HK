package com.flipkart.NewsFeed.Strategies;

import com.flipkart.NewsFeed.Repositories.FeedRepository;
import com.flipkart.NewsFeed.dto.GetALLFeedRequest;
import com.flipkart.NewsFeed.dto.OptionRequest;

public class ShowFeedBasedOnOptionFactory {

    private FeedRepository _feedRepository;
    public ShowFeedBasedOnOptionFactory(FeedRepository feedRepository)
    {
        _feedRepository = feedRepository;
    }
    public ShowFeedBasedOnOptionSortingStrategy getShowFeedBasedOnOption(OptionRequest optionRequest)
    {
        return (switch (optionRequest)
        {
            case FollowedUser -> new ShowFeedsBasedOnFollowedUserStrategy(_feedRepository);
            case NOOFCOMMENTS -> new ShowFeedsBasedOnNoOfCommentStrategy(_feedRepository);
            case SCORE -> new ShowFeedsBasedOnScoreStrategy(_feedRepository);
            case TIMESTAMP -> new  ShowFeedsBasedOnTimeStampStrategy(_feedRepository);
        });
    }
}
