package com.flipkart.NewsFeed.Repositories;

import com.flipkart.NewsFeed.Models.Login;
import com.flipkart.NewsFeed.Models.User;
import com.flipkart.NewsFeed.dto.LoginRequest;
import com.flipkart.NewsFeed.dto.UserRegisterRequest;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users = new ArrayList<>();


    //User Register
    public void saveUser(UserRegisterRequest user) {
        User NewUser = new User();
        if(users.size() > 0)
        NewUser.setId(users.get(users.size()-1).getId() +  1);
        else
        NewUser.setId(1L);
        NewUser.setEmail(user.getEmail());
        NewUser.setName(user.getName());
        NewUser.setPhoneNumber(user.getPhoneNumber());
        NewUser.setDob(user.getDob());
        NewUser.setPassword("abcdefg" + user.getPassword() + "zyxwvu"); //This can be Improved , we have to store password as HashedValue Encrypted Value
        //Save to the userCollection
        users.add(NewUser);
        System.out.println("User is SuccessFully Registered.........");
    }


    //User login
    public User LoginUserWithSession(LoginRequest user) {
        User userDb = checkUser(user);
        if(userDb.equals(null))
        {
            System.out.println("User is not Found, Please Register User");
        }
        return userDb;
    }

    private User checkUser(LoginRequest user) {
        String Email = user.getEmail();
        String Password = user.getPassword();
        for(User userDb : users)
        {
            if(userDb.getEmail().equals(Email) && user.getPassword().equals(Password))
            {
                return userDb;
            }
        }
        return null;
    }

    public User getUserById(Long userId) {
        for(User u : users)
        {
            if(u.getId() == userId)
            {
                return u;
            }
        }
        return null;
    }
}
