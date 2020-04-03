package com.maotion.microuser.services;


import com.maotion.microuser.entities.UserAccount;
import com.maotion.microuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAccount save(UserAccount userAccount) {
        return userRepository.save(userAccount);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAccount userAccount = userRepository.findByUserName(s);
        if(userAccount==null) throw new UsernameNotFoundException("user not found");
        return new User(userAccount.getUserName(), userAccount.getPassword(),
                true,true,true,true,
                new ArrayList<>());
    }

    public UserAccount getUserByUsername(String username){
        return userRepository.findByUserName(username);
    }
}
