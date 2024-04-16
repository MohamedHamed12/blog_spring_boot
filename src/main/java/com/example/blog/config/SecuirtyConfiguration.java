package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;




@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecuirtyConfiguration {
    private static final String [] WHITELIST = {
            "/auth/**",
            "/posts/**"
    };
      private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  
    @Bean 
    public SecurityFilterChain  secuirtyFilterChain(HttpSecurity http) throws Exception {
    
        http
            .csrf().disable() // Disable CSRF protection
            .authorizeRequests()
                .requestMatchers(WHITELIST).permitAll() // Permit access to /posts/** without authentication
                .anyRequest().authenticated() // Require authentication for all other requests
            .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Set session management to stateless
            .and()
            .authenticationProvider(authenticationProvider) // Set authentication provider
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT authentication filter
    


    return http.build();
    }

}


