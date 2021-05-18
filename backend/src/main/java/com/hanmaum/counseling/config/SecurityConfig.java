package com.hanmaum.counseling.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanmaum.counseling.error.ErrorResponse;
import com.hanmaum.counseling.security.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper mapper;
    private final JwtFilter jwtFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/asset/**","/v2/api-docs", "/configuration/**",
                "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/swagger-ui/**", "/swagger/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .httpBasic().disable()
                .cors().configurationSource(corsConfigurationSource())

                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers(
                        "/signup", "/login", "/verify-check", "/email-check", "/find-password", "/email-verify").permitAll()
                .antMatchers(HttpMethod.POST, "/bans").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/bans/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/bans").hasRole("ADMIN")
                .anyRequest().hasRole("USER")

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(this::authenticationEntryPoint)

                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    public void authenticationEntryPoint(HttpServletRequest request, HttpServletResponse response,
                                         AuthenticationException authenticationException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(mapper.writeValueAsString(new ErrorResponse(authenticationException.getMessage(), "auth.exception")));
    }
}
