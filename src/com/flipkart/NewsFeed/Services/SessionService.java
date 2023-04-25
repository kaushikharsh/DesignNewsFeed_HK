package com.flipkart.NewsFeed.Services;

import com.flipkart.NewsFeed.Models.Session;
import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.Repositories.SessionRepository;
import com.flipkart.NewsFeed.dto.LoginResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SessionService {
    private SessionRepository _Session;
    public SessionService(SessionRepository sessionRepo)
    {
        _Session = sessionRepo;
    }
    public LoginResponse CreateSession(User user)
    {
       Session s = _Session.create(user);
       LoginResponse loginResponse = new LoginResponse();
       loginResponse.setSessionId(s.getId());
       loginResponse.setSessionTime(s.getCreatedAt());
       loginResponse.setUserId(s.getUserId());
       return loginResponse;
    }
    public Session GetSessionByUser(Long UserId)
    {
        return _Session.getSessionByUser(UserId);
    }
}
