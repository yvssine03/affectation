package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/api/projects/**").hasAnyRole("MANAGER", "TECH_LEAD")
                .requestMatchers("/api/**").hasAnyRole("DEV", "TEST", "DEVOPS")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();

        var manager = User.withUsername("manager").password("{noop}password").roles("MANAGER").build();
        var techLead = User.withUsername("techlead").password("{noop}password").roles("TECH_LEAD").build();
        var dev = User.withUsername("dev").password("{noop}password").roles("DEV").build();
        var test = User.withUsername("test").password("{noop}password").roles("TEST").build();
        var devops = User.withUsername("devops").password("{noop}password").roles("DEVOPS").build();
        var user = User.withUsername("user").password("{noop}password").roles("USER").build();

        userDetailsManager.createUser(manager);
        userDetailsManager.createUser(techLead);
        userDetailsManager.createUser(dev);
        userDetailsManager.createUser(test);
        userDetailsManager.createUser(devops);
        userDetailsManager.createUser(user);

        return userDetailsManager;
    }
}
