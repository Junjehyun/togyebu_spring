package com.togyebu.yama331.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 설정 클래스
 * - Spring Boot 3.x 에서 WebSecurityConfigurerAdapter 대신 SecurityFilterChain 사용
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * SecurityFilterChain 빈 등록 메서드
     * @param http HttpSecurity 객체
     * @return 구성된 SecurityFilterChain
     * @throws Exception 보안 설정 중 발생 가능한 예외
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         // 1. URL 권한 설정: 모든 요청에 대해 인증 필요
         http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) // 인증된 사용자만 접근 허용
        .formLogin(form -> form
        .defaultSuccessUrl("/main", true) // 로그인 성공 시 /main 으로 리다이렉트
        .permitAll() // 로그인 페이지는 모두 접근 허용
      )
      // 3. Logout 설정 
      .logout(logout -> logout.permitAll());  // 로그아웃 처리도 인증 없이 접근 허용

    // 설정 적용 후 빌드
    return http.build();

    // 추후, 로그아웃을 하면 별도로 만들어둔 화면으로 리다이렉트 하는 작업 해야함. (커스텀 로그인 페이지가 아마 유력)
        
    }
    
}
