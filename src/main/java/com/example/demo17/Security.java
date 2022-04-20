package com.example.demo17;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {
    @Autowired
    public void globalconfig(AuthenticationManagerBuilder auth) throws Exception{
        /*auth.inMemoryAuthentication().withUser("admin").password("1234").roles("Admin");
        auth.inMemoryAuthentication().withUser("user").password("user").roles("Autre");
        auth.inMemoryAuthentication().withUser("useradmin").password("useradmin");*/
    }
}
