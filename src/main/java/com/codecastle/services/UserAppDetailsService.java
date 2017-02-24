package com.codecastle.services;


import com.codecastle.models.AppUser;
import com.codecastle.models.AppUserDetails;
import com.codecastle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAppDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepository.findByUsername(username);
        UserDetails userDetails = null;
        if(user !=null) {
             userDetails = new AppUserDetails(user);
        }

        return userDetails;
    }
}
