package com.codecastle.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableGlobalAuthentication
public class GlobalAuthenticationUserService extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService getUserDetailService() {

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        User user = new User("igorce", "igorce", authorities);
        List<UserDetails> users = new ArrayList<>();
        users.add(user);

        return new InMemoryUserDetailsManager(users);
    }

    @Override
    public void init(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        UserDetails result = userDetailsService.loadUserByUsername("igorce");

        authenticationManagerBuilder.userDetailsService(userDetailsService);
    }
}
