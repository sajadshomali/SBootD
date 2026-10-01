package org.example.springbootdenis.config;

import org.example.springbootdenis.service.user.UserService;
import org.example.springbootdenis.service.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringBootSecurity {

    private final UserServiceImpl userService;

    public SpringBootSecurity(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
        return httpSecurity.csrf(r->r.disable()).authorizeHttpRequests(request ->
                        request.requestMatchers("/book/listAll").permitAll()
                                .requestMatchers(HttpMethod.POST,"/book/save").permitAll()
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider provider(UserServiceImpl userServiceImpl){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userServiceImpl);
        provider.setPasswordEncoder(encoder());
        return provider;
    }
}
