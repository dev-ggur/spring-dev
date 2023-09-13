package com.devspringboot.config;

import com.devspringboot.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final MemberDetailService memberService;

    private final CustomFailureHandler customFailureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/login","/","/join","/static/**","/sms/send").permitAll()
                        .anyRequest().authenticated())
                .formLogin((form) ->
                        form.loginPage("/login")
                                .defaultSuccessUrl("/")
                                .failureHandler(customFailureHandler)
                                .usernameParameter("memberEmail")
                                .passwordParameter("memberPassword"))
                .logout((logout) -> logout.logoutSuccessUrl("/").invalidateHttpSession(true))
                .csrf((csrf) -> csrf.disable());

        return http.build();
    }


    /**
     * h2데이터베이스 개발용
     */
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers(PathRequest.toH2Console()).permitAll()
//                        .requestMatchers(
//                                AntPathRequestMatcher.antMatcher("/login"),
//                                AntPathRequestMatcher.antMatcher("/"),
//                                AntPathRequestMatcher.antMatcher("/join"),
//                                AntPathRequestMatcher.antMatcher("/static/**")).permitAll()
//                        .anyRequest().authenticated())
//                .formLogin((formLogin) ->
//                        formLogin.loginPage("/login")
//                                .defaultSuccessUrl("/")
//                                .failureHandler(customFailureHandler)
//                                .usernameParameter("memberEmail")
//                                .passwordParameter("memberPassword"))
//                .logout((logout) -> logout.logoutSuccessUrl("/").invalidateHttpSession(true))
//                .csrf((csrf) -> csrf.disable())
//                .headers((header) -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
//
//        return http.build();
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
