package com.flipkart.NewsFeed.Models;

public class Vote extends BaseModel{
    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getPostId() {
        return PostId;
    }

    public void setPostId(Long postId) {
        PostId = postId;
    }

    public com.flipkart.NewsFeed.Models.VoteType getVoteType() {
        return VoteType;
    }

    public void setVoteType(com.flipkart.NewsFeed.Models.VoteType voteType) {
        VoteType = voteType;
    }

    private Long UserId;  // Who liked the post
    private Long PostId; // Which Post is liked or it can be a Comment Id as well! we can say it as a Parent Id
    private VoteType VoteType; //Which Type of Likes is there either is a UpVote OR DownVote
}
