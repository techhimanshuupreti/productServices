package com.productservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;


/***
 * It is the latest version to implement the spring security.
 * */
@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {

    /***
     * It is responsible for config security filters, authenticate mechanize.
     * */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        final String[] excludeEndPoints = {
                "/v3/api-docs",
                "/v2/api-docs",
                "/v1/api-docs",
                "/swagger-resources/**",
                "/swagger-ui/**",
                "/webjars/**",
                "/api/v1/category/**",
                "/swagger-ui/index.html",
                "/swagger-ui/index.html/**",
                "/swagger-ui/index.html#/",
                "/swagger-ui/index.html#/**"

        };

        /***
         * It is responsible for skip security filters of define endpoint
         * by HttpSecurity with authorizeHttpRequests methods.
         *
         * If we add
         * .authorizeHttpRequests()
         *             .anyRequest().authenticated()
         *             .and()
         *  then all http request will authenticate with
         *  authentication provider like
         *  DAO, In memory DB, OAuth, LDAP
         * */

        http.authorizeHttpRequests().anyRequest().permitAll();
        return http.build();
    }

    /***
     * It is responsible for skip security filters of define endpoint by MVC Pattern.
     * */
/*  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> {
      web.ignoring().requestMatchers("/api/v1/category/**", "/api/v1/sub-category/**");
    };
  }*/

    /***
     * It gives UserDetails for login with password bcrypt encoded
     * */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("upreti")
                .password("$2a$12$W6Aeip.6fzQmP/1bVGi7Q.pj6jhYQpVCKb6oE2lp3S6SL/fst3rWi")// upreti
                .roles("USER").build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder getPassEncoded() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public CorsFilter corsFilter(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedOrigins(List.of("*"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("DELETE","PUT","PATCH","POST","GET"));
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        corsConfiguration.setAllowCredentials(true);
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
}