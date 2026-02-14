package com.ymsli.bank.inhouse.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // 1️⃣ Allow OPTIONS preflight requests
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // 2️⃣ Public auth endpoints
                .requestMatchers("/auth/**").permitAll()

                // 3️⃣ Manager endpoints
                .requestMatchers("/transactions/pending**",
                                 "/transactions/approve**",
                                 "/transactions/create**")
                        .hasAuthority("ROLE_MANAGER")

                // 4️⃣ Clerk endpoints
                .requestMatchers("/transactions/deposit",
                                 "/transactions/withdraw",
                                 "/transactions/transfer")
                        .hasAuthority("ROLE_CLERK")

                // 5️⃣ Any other request requires authentication
                .anyRequest().authenticated()
            )
            // 6️⃣ Add JWT filter before Spring Security authentication filter
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration c = new CorsConfiguration();
        c.setAllowedOrigins(List.of("http://localhost:4200"));
        c.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        c.setAllowedHeaders(List.of("*"));
        c.setExposedHeaders(List.of("Authorization"));
        c.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource s = new UrlBasedCorsConfigurationSource();
        s.registerCorsConfiguration("/**", c);
        return s;
    }
}
