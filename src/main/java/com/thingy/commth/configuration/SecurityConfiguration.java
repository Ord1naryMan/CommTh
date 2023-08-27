package com.thingy.commth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final String[] allowedUrls =
            {"/", "index.html", "public/*.html",
                    "/error", "/webjars/**"};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req -> req.requestMatchers(allowedUrls).permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(c -> c
                        .disable())
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .formLogin(form -> form.loginPage("/login"))
                .logout(l -> l
                        .logoutSuccessUrl("/").permitAll())
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}
