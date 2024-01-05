package com.api.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.api.user.Permission.*;
import static com.api.user.Role.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**")
                .permitAll()
                .requestMatchers("/api/v1/student/**").hasAnyRole(COLLEGE.name(),STUDENT.name(), GLOBAL.name())
                .requestMatchers(GET,"/api/v1/student").hasAnyAuthority(COLLEGE_READ.name(), STUDENT_READ.name(), GLOBAL_READ.name())
                .requestMatchers(PUT,"/api/v1/student").hasAnyAuthority(COLLEGE_UPDATE.name(), STUDENT_UPDATE.name(), GLOBAL_UPDATE.name())
                .requestMatchers(POST,"/api/v1/student").hasAnyAuthority(COLLEGE_CREATE.name(), STUDENT_CREATE.name(), GLOBAL_CREATE.name())
                .requestMatchers(DELETE,"/api/v1/student").hasAnyAuthority(COLLEGE_DELETE.name(), STUDENT_DELETE.name(), GLOBAL_DELETE.name())

                .requestMatchers("/api/v1/global/**").hasRole(GLOBAL.name())
                .requestMatchers(GET,"/api/v1/global").hasAuthority(GLOBAL_READ.name())
                .requestMatchers(PUT,"/api/v1/global").hasAuthority(GLOBAL_UPDATE.name())
                .requestMatchers(POST,"/api/v1/global").hasAuthority(GLOBAL_CREATE.name())
                .requestMatchers(DELETE,"/api/v1/global").hasAuthority(GLOBAL_DELETE.name())
//                .requestMatchers("/api/v1/college/**").hasRole(COLLEGE.name())
//                .requestMatchers(GET,"/api/v1/college").hasAuthority(COLLEGE_READ.name())
//                .requestMatchers(PUT,"/api/v1/college").hasAuthority(COLLEGE_UPDATE.name())
//                .requestMatchers(POST,"/api/v1/college").hasAuthority(COLLEGE_CREATE.name())
//                .requestMatchers(DELETE,"/api/v1/college").hasAuthority(COLLEGE_DELETE.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}
