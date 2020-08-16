package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringbootHibernateOneOneMappingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneOneMappingApplication.class, args);
	}

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//creating user object
		
		User user = new User();
		user.setName("Yash");
		user.setEmail("zodeyash@gmail.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Pune");
		userProfile.setBirthOfDate(LocalDate.of(1998, 02, 01));
		userProfile.setGender(Gender.Male);		
		userProfile.setPhoneNumber("9822383033");
		
		//now setting userprofile to user object and vide versa
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		
		userRepository.save(user);
		
		
		}

}
