package com.demo.camel.demo.service;

import com.demo.camel.demo.com.demo.camel.User;
import org.apache.camel.Handler;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private HashMap<Integer, User> users;

    public UserService() {
        users = new HashMap<Integer, User>();
        users.put(100, new User(100, "Austin", "Powers"));
    }

    @Handler
    public User get(int id) {
        User foundUser = users.get(id);
        return foundUser;
    }
}
