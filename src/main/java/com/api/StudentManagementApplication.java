package com.api;

import com.api.auth.AuthenticationService;
import com.api.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.api.user.Role.*;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(AuthenticationService service){
//		return args -> {
////			var user = RegisterRequest.builder()
////					.firstname("firstname")
////					.lastname("lastname")
////					.email("stu1@gmail.com")
////					.password("pass2")
////					.role(USER)
////					.build();
////			System.out.println("User token: "+service.register(user).getToken());
//
//			var admin = RegisterRequest.builder()
//					.firstname("firstadmin")
//					.lastname("lastname")
//					.email("coll@gmail.com")
//					.password("pass3")
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token: "+service.register(admin).getToken());
//
//			var manager = RegisterRequest.builder()
//					.firstname("firstmanager")
//					.lastname("lastname")
//					.email("global1@gmail.com")
//					.password("pass4")
//					.role(MANAGER)
//					.build();
//			System.out.println("Manager token: "+service.register(manager).getToken());
//		};
//	}

}
