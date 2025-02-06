package com.tushar007d.secure.notes.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(
                (requests) ->
                        requests.requestMatchers("/contact").permitAll()
                                .anyRequest().authenticated()
                               // .requestMatchers("/admin").denyAll() //this denyAll is used in-case the admin functionality is under maintainance.
        );
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.httpBasic(Customizer.withDefaults()); //this is for basic authentication

        //below sessionManagement functionality is used to make session stateless,
        //which will not store session details
//        httpSecurity.sessionManagement(
//                (session) ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }

}
