package com.alexmarques.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.alexmarques.helpdesk.api.entity.User;
import com.alexmarques.helpdesk.api.enums.ProfileEnum;
import com.alexmarques.helpdesk.api.repository.UserRepository;

@SpringBootApplication
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder ) {
		return args -> {
			initUsers(userRepository, passwordEncoder);
		};
	}
	
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("alexmarques2003@gmail.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLLE_ADMIN);
		
		User find = userRepository.findByEmail("alexmarques2003@gmail.com");
		if(find == null) {
			userRepository.save(admin);
		} else {
			System.out.println("Admin não encontrado");
		}
	}
	
	
}
