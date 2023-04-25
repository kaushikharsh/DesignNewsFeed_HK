package com.flipkart.NewsFeed.dto;

public enum OptionRequest {
    FollowedUser,    //  -> posts by followed users appear first.
    SCORE,          //  -> (upvotes - downvotes) : higher the better.
    NOOFCOMMENTS,  //  ->  higher the better.
    TIMESTAMP     //  ->   more recent the better.
}
