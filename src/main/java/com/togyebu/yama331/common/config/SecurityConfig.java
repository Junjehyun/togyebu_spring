package com.togyebu.yama331.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         http
      .authorizeRequests(auth -> auth.anyRequest().authenticated())
      .formLogin(form -> form
        .defaultSuccessUrl("/main", true)   // 로그인 성공 후 무조건 /main
        .permitAll()
      )
      .logout(logout -> logout.permitAll());
    return http.build();
        
    }
    
}
