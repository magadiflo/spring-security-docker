package com.magadiflo.app.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * El AuthenticacionProvider es lo que realmente hace la real autenticación,
 * verificando el username, password, etc..
 * Hay muchas implementaciones del AuthenticacionProvider, por defecto si
 * no especificamos Spring Security usará el DaoAuthenticationProvider.
 * En nuestro caso, nosotros usaremos el AbstractUserDetailsAuthenticationProviders
 */

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(null); //Definimos un proveedor de autenticación (por ahora no tenemos definido)

        http.csrf().disable();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/accounts/**").permitAll();
        http.authorizeRequests().anyRequest()
                .hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic(Customizer.withDefaults())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

}
