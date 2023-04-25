package com.flipkart.NewsFeed.Controllers;

import com.flipkart.NewsFeed.Services.SessionService;
import com.flipkart.NewsFeed.Services.UserService;
import com.flipkart.NewsFeed.dto.FollowRequest;
import com.flipkart.NewsFeed.dto.LoginRequest;
import com.flipkart.NewsFeed.dto.LoginResponse;
import com.flipkart.NewsFeed.dto.UserRegisterRequest;

public class UserController {
    private UserService _userService;
    public UserController(UserService userService)
    {
        _userService = userService;
    }
    public void registerUser(UserRegisterRequest NewUser)
    {
        _userService.register(NewUser);
    }
    public LoginResponse loginUser(LoginRequest user)
    {
        return _userService.login(user);
    }
}
