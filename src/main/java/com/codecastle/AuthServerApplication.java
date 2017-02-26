package com.codecastle;

import com.codecastle.models.AppUser;
import com.codecastle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.sql.Date;

@SpringBootApplication
@RestController
@EnableResourceServer
public class AuthServerApplication {

	@Autowired
	public UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@PostConstruct
	public void createDummyUser() {
		AppUser appUser = new AppUser();
		appUser.setUsername("igorce");
		appUser.setPassword("igorce");
		appUser.setCreationDate(new Date(new java.util.Date().getTime()));
		appUser.setEnabled(true);
		appUser.setLocked(false);

		userService.create(appUser);
	}
}
