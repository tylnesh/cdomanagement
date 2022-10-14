package com.lordsoftech.cdomanagment.security;

import com.lordsoftech.cdomanagment.filter.CdoAuthenticationFilter;
import com.lordsoftech.cdomanagment.filter.CdoAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;


@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CdoAuthenticationFilter cdoAuthenticationFilter = new CdoAuthenticationFilter(authenticationManagerBean());
        cdoAuthenticationFilter.setFilterProcessesUrl("/api/login");

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().and().authorizeRequests().antMatchers("/api/login/**", "/api/token/refresh/**").permitAll();
        http.cors().and().authorizeRequests().antMatchers(GET, "/api/user/**").hasAnyAuthority("ROLE_USER");
        http.cors().and().authorizeRequests().antMatchers(POST, "/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.cors().and().authorizeRequests().antMatchers(POST, "/api/**").hasAnyAuthority("ROLE_ADMIN");
        http.cors().and().authorizeRequests().antMatchers(PUT, "/api/**").hasAnyAuthority("ROLE_ADMIN");
        http.cors().and().authorizeRequests().antMatchers(DELETE, "/api/**").hasAnyAuthority("ROLE_ADMIN");

        http.cors().and().authorizeRequests().anyRequest().authenticated();
        http.addFilter(cdoAuthenticationFilter);
        http.addFilterBefore(new CdoAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
