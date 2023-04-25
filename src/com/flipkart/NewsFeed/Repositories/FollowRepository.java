package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.dto.FollowRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FollowRepository {

    //User -> Has List of Following By User : List<Users>
    private UserRepository _userRepository;
    public FollowRepository(UserRepository userRepository)
    {
        _userRepository = userRepository;
    }
    HashMap<Long, List<User>> UserFollowing  = new HashMap<>(); //  User Following

    //User -> Has List of Followers : List<User>
    HashMap<Long,List<User>> UserFollowers = new HashMap<>();  // User Followers

    //UserToBeFollowed by UserID ->  get the list of the Following List of that user then add one more entry of User in that.
    public void followUser(Long userTobeFollow , Long FollowByUser)
    {
        User userToBeFollowed = _userRepository.getUserById(userTobeFollow);
        User CurrUser = _userRepository.getUserById(FollowByUser);
        if(userTobeFollow == null || CurrUser == null)
        {
            System.out.println("Internal Server Error : NO User Found to be Followed");
            return;
        }
        Long ByUserId = CurrUser.getId();
        if(!UserFollowing.containsKey(ByUserId)) // Means User is not Following anyone
        {
            //Create A List<User> and add into that
            List<User> userFollowing = new ArrayList<>();
            userFollowing.add(userToBeFollowed);
            UserFollowing.put(ByUserId,userFollowing);
            //Add This User Followers int the Follower list of Other User
            AddToTheFollowersForUser(userToBeFollowed,CurrUser);
            System.out.printf("%s Successfully Followed %s ",CurrUser.getName(),userToBeFollowed.getName());
            return;
        }
        List<User> CurrUserFollowing = UserFollowing.get(ByUserId);
        if(!CurrUserFollowing.contains(userToBeFollowed))
        {
            CurrUserFollowing.add(userToBeFollowed);
            UserFollowing.replace(ByUserId,CurrUserFollowing);
            AddToTheFollowersForUser(userToBeFollowed, CurrUser);
            System.out.printf("%s Successfully Followed %s ",CurrUser.getName(),userToBeFollowed.getName());
            return;
        }
        System.out.println("Already Followed");
    }
    //Adding User1 in follower for a User2 because User1 followed User2
    private void AddToTheFollowersForUser(User UserToBeAddInFollowers ,User CurrUser) {
        List<User> currFollowers = getUser(UserFollowers,UserToBeAddInFollowers.getId()); // CURRENT FOLLOWERS FOR THIS USER
        if(currFollowers.size() > 0) {
            currFollowers.add(CurrUser);
            UserFollowers.replace(UserToBeAddInFollowers.getId(), currFollowers);
            return;
        }
        currFollowers.add(CurrUser);
        UserFollowers.put(UserToBeAddInFollowers.getId(), currFollowers);
    }

    public List<User> getAllUserFollowers(Long UserId)
    {
        return getUser(UserFollowers,UserId);
    }
    public List<User> getAllUserFollowing(Long UserId)
    {
        return getUser(UserFollowing , UserId);
    }
    private List<User> getUser(HashMap<Long,List<User>> UserFollowOrUserFollowing , Long UserID)
    {
        if(!UserFollowOrUserFollowing.containsKey(UserID))
        {
            return new ArrayList<>();
        }
        return UserFollowOrUserFollowing.get(UserID);
    }
}
