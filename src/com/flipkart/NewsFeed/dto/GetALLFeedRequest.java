package com.flipkart.NewsFeed.dto;

public class GetALLFeedRequest {
    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public OptionRequest getOptions() {
        return Options;
    }

    public void setOptions(OptionRequest options) {
        Options = options;
    }

    private OptionRequest Options;   // Option Request By The User to sort the Feeds on the Basis of the Parameter
    private Long UserId;
}
