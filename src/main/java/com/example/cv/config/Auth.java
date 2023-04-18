package com.example.cv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter {

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("test").password(passwordEncoder().encode("test")).roles("USER").
                and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/", "/education", "/awards", "/experience", "/interests", "/skills")
                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
//                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")
                .defaultSuccessUrl("/")
                .and()
                .logout() //
                .logoutSuccessUrl("/");
    }

}
