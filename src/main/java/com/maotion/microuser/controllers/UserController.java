package com.maotion.microuser.controllers;

import com.maotion.microuser.entities.UserAccount;
import com.maotion.microuser.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private Logger logger = LogManager.getLogger(UserController.class);
    Environment environment;
    private UserService userService;

    @Autowired
    public UserController(UserService userService,Environment environment) {
        this.userService = userService;
        this.environment = environment;
    }

    @PostMapping("/user")
    public UserAccount setupUser(@RequestBody UserAccount userAccount) {
        logger.debug(String.format("--------the bus.refresh.test value is : %s --------",environment.getProperty("bus.refresh.test")));
        return userService.save(userAccount);
    }
}
