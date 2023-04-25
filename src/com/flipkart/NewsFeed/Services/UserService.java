package com.flipkart.NewsFeed.Services;

import com.flipkart.NewsFeed.Repositories.FollowRepository;
import com.flipkart.NewsFeed.Repositories.UserRepository;
import com.flipkart.NewsFeed.dto.FollowRequest;
import com.flipkart.NewsFeed.dto.LoginRequest;
import com.flipkart.NewsFeed.dto.LoginResponse;
import com.flipkart.NewsFeed.dto.UserRegisterRequest;

import java.sql.SQLOutput;

public class UserService
{
    private UserRepository _user;
    private SessionService _sessionService;
    public UserService(SessionService sessionService , UserRepository userRepo) {
        _sessionService = sessionService;
        _user = userRepo;
    }

    public void register(UserRegisterRequest NewUser) {
        _user.saveUser(NewUser);
    }

    public LoginResponse login(LoginRequest LoginUser) {
        return _sessionService.CreateSession(_user.LoginUserWithSession(LoginUser));
    }
}
