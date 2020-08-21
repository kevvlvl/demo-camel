package com.kevvlvl.demo.camel.service;

import com.kevvlvl.demo.camel.model.User;
import org.apache.camel.Handler;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private HashMap<Integer, User> users;

    public UserService() {
        this.users = new HashMap<Integer, User>();
        this.users.put(100, new User(100, "Austin", "Powers"));
    }

    @Handler
    public User get(int id) {
        User foundUser = this.users.get(id);
        return foundUser;
    }

    @Handler
    public void setRandomNumber(User user, int num) {
        this.users.get(user.getUserId()).setRandomNumber(num);
    }
}
