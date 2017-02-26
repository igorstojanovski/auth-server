package com.codecastle.services;

import com.codecastle.models.AppUser;
import com.codecastle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void create(AppUser appUser) {
        userRepository.save(appUser);
    }
}
