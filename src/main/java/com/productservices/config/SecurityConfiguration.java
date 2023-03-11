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

import static org.springframework.security.config.Customizer.withDefaults;


/***
 * It is the latest version to implement the spring security.
 * */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  /***
   * It is responsible for config security filters, authenticate mechanize.
   * */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
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
    http.authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests
            .requestMatchers("/api/v1/category/**").permitAll())
            .authorizeHttpRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin(withDefaults());
    return http.build();
  }

  /***
   * It is responsible for skip security filters of define endpoint by MVC Pattern.
   * */
//  @Bean
//  public WebSecurityCustomizer webSecurityCustomizer() {
//    return (web) -> {
//      web.ignoring().requestMatchers("/api/v1/category/**", "/api/v1/sub-category/**");
//    };
//  }

  /***
   * It gives UserDetails for login with password bcrypt encoded
   * */
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User
                        .withUsername("upreti")
                        .password("$2a$12$/.cJcgeRCEbt0iARRe7Q6utWXfZPsCCIEzkP8f58fDJAEkg3XE7I.")
                        .roles("USER").build();

    return new InMemoryUserDetailsManager(user);
  }

  @Bean
  public PasswordEncoder getPassEncoded(){
    return new BCryptPasswordEncoder();
  }
}