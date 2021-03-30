package fi.reseptiAppi.resapp;

import fi.reseptiAppi.resapp.domain.AppUser;
import fi.reseptiAppi.resapp.domain.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResappApplication.class, args);
	}
        @Bean
	public CommandLineRunner bookDemo(AppUserRepository userRepository) {
		return (args) -> {

			// security: create new application users with the role info
			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$10$eBe.euY5ukBOCZY1g5psEuXC3hfOith5ksx41lWTn9l.Faq1xBQCu", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$S5JgORJQ9HE/lfsIypI8E.677KVfSJ.trviQ.ktL4licqvkJGEeUu", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}

}
