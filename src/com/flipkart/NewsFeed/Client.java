package com.flipkart.NewsFeed;

import com.flipkart.NewsFeed.Controllers.*;
import com.flipkart.NewsFeed.Models.Comment;
import com.flipkart.NewsFeed.Repositories.*;
import com.flipkart.NewsFeed.Services.*;
import com.flipkart.NewsFeed.Strategies.ShowFeedBasedOnOptionFactory;
import com.flipkart.NewsFeed.Strategies.ShowFeedBasedOnOptionSortingStrategy;
import com.flipkart.NewsFeed.dto.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        //User Register
        SessionRepository sessionRepository = new SessionRepository();
        SessionService sessionService = new SessionService(sessionRepository);
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(sessionService, userRepository);
        UserController userController = new UserController(userService);

        //4 Commands Are There\

        System.out.println();
        System.out.println();

        //GenerateRequestForRegister // User1
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setName("Harsh Kaushik");
        userRegisterRequest.setEmail("kaushikharsh9897@gmail.com");
        userRegisterRequest.setDob(new Date(1999, 06, 01));
        userRegisterRequest.setPassword("Hk1234@");
        userRegisterRequest.setPhoneNumber(9897467097L);

        userController.registerUser(userRegisterRequest);

        System.out.println();
        System.out.println();

        //User Login
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("kaushikharsh9897@gmail.com");
        loginRequest.setPassword("Hk1234@");
        LoginResponse loginResponse = userController.loginUser(loginRequest);

        System.out.println();
        System.out.println();

        //POST A Feed
        FeedRepository feedRepository = new FeedRepository();
        FollowRepository followRepository = new FollowRepository(userRepository);
        ShowFeedBasedOnOptionFactory showFeedBasedOnOptionFactory = new ShowFeedBasedOnOptionFactory(feedRepository,followRepository);
        FeedService feedService = new FeedService(sessionService, feedRepository,showFeedBasedOnOptionFactory);  //
        FeedController feedController = new FeedController(feedService);

        FeedRequest feedRequest = new FeedRequest();
        feedRequest.setText("Hi All I am Malking My First Post");
        feedRequest.setUserId(loginResponse.getUserId());
        FeedResponse feedResponse = feedController.PostFeed(feedRequest);

        System.out.println();
        System.out.println();


        //User2
        UserRegisterRequest userRegisterRequest2 = new UserRegisterRequest();
        userRegisterRequest2.setName("Alok Singh");
        userRegisterRequest2.setEmail("Alok9897@gmail.com");
        userRegisterRequest2.setDob(new Date(1996, 06, 01));
        userRegisterRequest2.setPassword("Alok1234@");
        userRegisterRequest2.setPhoneNumber(6797467097L);

        userController.registerUser(userRegisterRequest2);

        System.out.println();
        System.out.println();

        //User2 Login
        LoginRequest loginRequest2 = new LoginRequest();
        loginRequest2.setEmail("Alok9897@gmail.com");
        loginRequest2.setPassword("Alok1234@");
        LoginResponse loginResponse2 = userController.loginUser(loginRequest2);

        System.out.println();
        System.out.println();

        //User3 Login
        UserRegisterRequest userRegisterRequest3 = new UserRegisterRequest();
        userRegisterRequest3.setName("Karan Singh");
        userRegisterRequest3.setEmail("Karan9897@gmail.com");
        userRegisterRequest3.setDob(new Date(1995, 06, 01));
        userRegisterRequest3.setPassword("Karan1234@");
        userRegisterRequest3.setPhoneNumber(6997467097L);

        userController.registerUser(userRegisterRequest3);

        System.out.println();
        System.out.println();

        //user3 Login as well
        LoginRequest loginRequest3 = new LoginRequest();
        loginRequest3.setEmail("Karan9897@gmail.com");
        loginRequest3.setPassword("Karan1234@");
        LoginResponse loginResponse3 = userController.loginUser(loginRequest3);

        System.out.println();
        System.out.println();


        //User2 wants to Follow User1
        FollowService followService = new FollowService(followRepository);
        FollowController followController = new FollowController(followService);

        FollowRequest followRequest = new FollowRequest();
        followRequest.setUserToBeFollowed(loginResponse.getUserId()); //TobeFollowed i.e. User1
        followRequest.setUserFollowed(loginResponse2.getUserId()); //Follow User1 buy User2 : Who followed user1 is user2

        //Making Follow Request
        followController.FollowUser(followRequest);

        System.out.println();
        System.out.println();

        //Get Request For Followers of user1
        //Get the Followers ->  Show the follower List of User1
        //Get the Following ->  Show the Following List of User1
        GetFollowersRequest getFollowersRequest = new GetFollowersRequest();
        getFollowersRequest.setUserId(loginResponse.getUserId());
        GetFollowersResponse getFollowersResponse = followController.getAllFollowersByUser(getFollowersRequest);

        //Display Response Objects
        System.out.print("User Followers Details: ");
        System.out.println("User : " + getFollowersResponse.getUserId());
        System.out.println("Followers : " + getFollowersResponse.getFollowersNames());
        System.out.println("Following : " + getFollowersResponse.getFollowingNames());
        System.out.println("NoOfFollowers : " + getFollowersResponse.getNoOfFollowers());

        System.out.println();
        System.out.println();

        //Followers and Following of User2
        GetFollowersRequest getFollowersRequest2 = new GetFollowersRequest();
        getFollowersRequest2.setUserId(loginResponse2.getUserId());
        GetFollowersResponse getFollowersResponse2 = followController.getAllFollowersByUser(getFollowersRequest2);

        //Display Response Objects
        System.out.print("User Followers Details: ");
        System.out.println("User : " + getFollowersResponse2.getUserId());
        System.out.println("Followers : " + getFollowersResponse2.getFollowersNames());
        System.out.println("Following : " + getFollowersResponse2.getFollowingNames());
        System.out.println("NoOfFollowers : " + getFollowersResponse2.getNoOfFollowers());

        System.out.println();
        System.out.println();

        //Comment Done By User2 on User 1st Post
        CommentRepository commentRepository = new CommentRepository(feedRepository,userRepository);
        CommentService commentService = new CommentService(commentRepository);
        CommentController commentController = new CommentController(commentService);

        //Comment Request By Client
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setCommentDoneByUser(loginResponse2.getUserId()); //Assume user2 is doing Comment on User1's Post
        commentRequest.setUserId(loginResponse.getUserId());
        commentRequest.setText("I like your Thoughts in the Post");
        commentRequest.setFeedId(feedResponse.getFeed().getId());

        CommentResponse commentResponse = commentController.postCommentOnFeed(commentRequest);

        //GetFeedForUser
        //Current Feed For User
        System.out.println("Current Feed Fetched From DB : ");
        System.out.println("Feed Id : " + commentResponse.getFeed().getId());
        System.out.println("Feed Content : " + commentResponse.getFeed().getText());
        System.out.println();
        System.out.println("Comments On Post : ->  ");
        var CommentsOnPost = commentResponse.getFeed().getComments();
        for(Comment c : CommentsOnPost)
        {
            System.out.println("Comment ID : " + c.getId());
            System.out.println("Content : " + c.getText());
            System.out.println("Commented By User : " + "ID -> " + c.getUserId());
            System.out.println("Commented BY UserName : " + c.getUserName());
        }
        System.out.println();
        System.out.println("Feed NoOfLikes : " + commentResponse.getFeed().getNo_Of_UpVotes());
        System.out.println("Feed NoOFDislikes : "+ commentResponse.getFeed().getNo_Of_DownVotes());
        System.out.println("Feed Posted By User: " + commentResponse.getFeed().getUserId());

        System.out.println();
        System.out.println();

        //UpVote or DownVote a Post
        //1.We can UPVOTE OR DOWN_VOTE A POST OR A COMMENT
        VoteRepository voteRepository = new FeedVoteRepository(feedRepository);
        VoteService voteService = new VoteService(voteRepository);
        VoteController voteController = new VoteController(voteService);

        //Create Vote Request
        VoteRequest voteRequest = new VoteRequest();
        voteRequest.setFeedId(feedResponse.getFeed().getId());
        voteRequest.setLike(true);
        voteRequest.setUserId(loginResponse2.getUserId());
        voteRequest.setWhoPostedThisFeedId(loginResponse.getUserId());

        VoteResponse voteResponse = voteController.VoteFeed(voteRequest);

        System.out.println("user2 is upvoted the post of User 1");
        System.out.println("Here is updated Feed for you: ");
        System.out.println("FeedId : " + voteResponse.getFeedId());
        System.out.println("Feed Content : " + voteResponse.getFeedContent());
        List<Comment> comments = voteResponse.getComments();
        System.out.println("Comment Done on This Post : ");
        for(Comment c : comments)
        {
            System.out.println("Comment : " + c.getText());
            System.out.println("By User : " + c.getUserName());
        }
        System.out.println("NoOfLikes On Feed : " + voteResponse.getNoOFLikes());
        System.out.println("NoOfDisLikes On Feed :" + voteResponse.getNoOfDislikes());
        System.out.println("Posted By User : " + voteResponse.getUserId());

        System.out.println();
        System.out.println();

        //User 3 making request to follow  User1
        FollowRequest followRequest2 = new FollowRequest();
        followRequest2.setUserToBeFollowed(loginResponse.getUserId()); //TobeFollowed i.e. User1
        followRequest2.setUserFollowed(loginResponse3.getUserId()); //Follow User1 buy User2 : Who followed user1 is user2

        //Making Follow Request
        followController.FollowUser(followRequest2);

        System.out.println();
        System.out.println();

        //


        //post some feeds
//        FeedRequest feedRequest = new FeedRequest();
//        feedRequest.setText("Hi All I am Malking My First Post");
//        feedRequest.setUserId(loginResponse.getUserId());
//        FeedResponse feedResponse = feedController.PostFeed(feedRequest);


        //Show Feeds based on Option Providing By Client
        //1.Show Feed Based ON FOLLOW USER -> posts by followed users appear first.























        // FOR RUNNING THE COMMANDS HAVING INSIDE THE SYSTEM LIKE LOGIN, SIGNUP, POST, FOLLOW, REPLY ,SHOWSFEED
//        Scanner sc = new Scanner(System.in);
//
//        String check = "Y";
//        do {
//            if(check.equals("y") || check.equals("y"))
//            {
//                System.out.println("1.Login");
//                System.out.println("2.SignUp");
//                int input = sc.nextInt();
//                if(input == 2)
//                {
//                    //Do login Part
//                    System.out.println("Enter your Full Name : ");
//                    String Name = sc.next();
//                    System.out.println("Enter your Email : ");
//                    String Email = sc.next();
//                    System.out.println("Enter your DOB : ");
//                    System.out.println("Enter Birth Year : ");
//                    int Year = sc.nextInt();
//                    System.out.println("Enter Birth Month : ");
//                    int Month = sc.nextInt();
//                    System.out.println("Enter Birth Day ex 01,02,15,14 etc : ");
//                    int day  = sc.nextInt();
//                    System.out.print("Enter the Phone Number : ");
//                    Long Phone = sc.nextLong();
//                    System.out.println("Enter The Password : ");
//                    String Password = sc.nextLine();
//                    UserRegisterRequest userRegisterRequestInput = new UserRegisterRequest();
//                    userRegisterRequestInput.setName(Name);
//                    userRegisterRequestInput.setEmail(Email);
//                    userRegisterRequestInput.setDob(new Date(Year,Month,day));
//                    userRegisterRequestInput.setPhoneNumber(Phone);
//                    userRegisterRequestInput.setPassword(Password);
//                    userController.registerUser(userRegisterRequestInput);
//                }
//                else
//                {
//                    //Do Sign Up
//                }
//            }
//            System.out.println("Do you want to Logout??");
//            System.out.println("Press Y or y if you want to continue or press N or n , if don't want to continue");
//            check = sc.next();
//        } while (check.equals("Y") || check.equals("Y"));
    }
}
