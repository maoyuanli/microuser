package com.maotion.microuser.controllers;

import com.maotion.microuser.entities.UserAccount;
import com.maotion.microuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserAccount setupUser(@RequestBody UserAccount userAccount) {
        return userService.save(userAccount);
    }
}
