package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.Session;
import com.flipkart.NewsFeed.Models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SessionRepository {
    List<Session> UserSessions  = new ArrayList<Session>();
    public Session create(User user)   //Create Session For Current User
    {
        if(!(user == null))
        {
            Long userId = user.getId();
            //check if Session is Already there or not
            Session previousSession = getSessionByUser(userId);
            if(previousSession == null)
            {
                //Session Object Creation
                return createUserSession(userId);
            }
            UserSessions.remove(previousSession); //Previous Session should be deleted
            return createUserSession(userId); // Re-Instanciated the Session for new user Login
        }
        System.out.println("User Session Revoked!!! User is not Authenticated");
        return null;
    }
    public Session getSessionByUser(Long userId)
    {
        for(Session s : UserSessions)
        {
            if(s.getUserId() == userId)
            {
                return s;
            }
        }
        return null;
    }
    private Session createUserSession(Long userID)
    {
        Session s = new Session();
        s.setCreatedAt(LocalDateTime.now());

        if(UserSessions.size() > 0)
            s.setId(UserSessions.get(UserSessions.size() -1).getId() + 1);
        else
            s.setId(1L);

        s.setUserId(userID);

        //Session Saved
        UserSessions.add(s);
        System.out.println("Session is Created....");
        return s;
    }
}
