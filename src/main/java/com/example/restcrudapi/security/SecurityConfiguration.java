package com.example.restcrudapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        var userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        userDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return  userDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/magic-api/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/magic-api/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/magic-api/members/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/magic-api/members/*").hasRole("ADMIN")
        );

        // use http basic auth
        httpSecurity.httpBasic(Customizer.withDefaults());

        // disable CSRF - not required for stateless APIs
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
