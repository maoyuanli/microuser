package com.maotion.microuser.services;


import com.maotion.microuser.entities.UserAccount;
import com.maotion.microuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAccount save(UserAccount userAccount) {
        return userRepository.save(userAccount);
    }
}
