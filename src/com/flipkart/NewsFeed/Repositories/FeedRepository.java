package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.Feed;
import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.dto.FeedRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedRepository {
    HashMap<Long, List<Feed>> Feeds = new HashMap<>();
    public Feed createFeed(FeedRequest feed)
    {
        //logic to add the feeds
        Long UserId = feed.getUserId();
        if(!Feeds.containsKey(UserId))
        {
            //Create A Feed
            Feed newFeed = new Feed();
            newFeed.setId(1L);
            newFeed.setUserId(UserId);
            newFeed.setNo_Of_DownVotes(0);
            newFeed.setNo_Of_UpVotes(0);
            newFeed.setText(feed.getText());
            newFeed.setPostedAt(LocalDateTime.now());
            //Add to the Feed List
            List<Feed> UserFeed = new ArrayList<>();
            UserFeed.add(newFeed);

            //Then Add to the Map
            Feeds.put(UserId,UserFeed);
            ShowFeed(newFeed);
            return newFeed;
        }
        //Create the Object of Feed
        //Add to the List
        //Then Add to the Map
        List<Feed> CurrValue = Feeds.get(UserId);

        Feed newFeed = new Feed();
        newFeed.setId(CurrValue.get(CurrValue.size()-1).getId() + 1);
        newFeed.setUserId(UserId);
        newFeed.setNo_Of_DownVotes(0);
        newFeed.setNo_Of_UpVotes(0);
        newFeed.setText(feed.getText());
        newFeed.setPostedAt(LocalDateTime.now());
        //Add to the list
        CurrValue.add(newFeed);
        //Replace the existing data in the map
        Feeds.replace(UserId,CurrValue);
        ShowFeed(newFeed);
        return newFeed;
    }
    private void ShowFeed(Feed feed)
    {
        System.out.println("Your Feed is Posted");
        System.out.println("Content : " + feed.getText());
        System.out.println("No. Of Likes : " + feed.getNo_Of_UpVotes());
        System.out.println("No. Of Dislikes : " + feed.getNo_Of_DownVotes());
        System.out.println("Comments : " + feed.getComments());
    }
    public List<Feed> getAllFeedsForUserWhoHavePosted(Long UserId)
    {
        return Feeds.get(UserId);
    }

    public Feed getFedByFeedId(Long feedId, Long userId) {
        List<Feed> feeds = Feeds.get(userId);
        for(Feed f : feeds)
        {
            if(f.getId() == feedId)
            {
                return f;
            }
        }
        return null;
    }

    public void AddFeedToDb(Feed dbFeed, Long userId) {
        Feeds.get(userId).add(dbFeed);
    }
}
