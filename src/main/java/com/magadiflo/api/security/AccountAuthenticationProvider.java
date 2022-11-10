package com.magadiflo.api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * El AuthenticacionProvider es lo que realmente hace la real autenticación,
 * verificando el username, password, etc..
 * Hay muchas implementaciones del AuthenticacionProvider, por defecto si
 * no especificamos Spring Security usará el DaoAuthenticationProvider.
 * En nuestro caso, nosotros usaremos el AbstractUserDetailsAuthenticationProvider
 * <p>
 * En el método additionalAuthenticationChecks(...), el objeto userDetails es lo que recuperamos de la base de datos
 * con el username proporcionado. El objeto UsernamePasswordAuthenticationToken es lo que pasa el usuario que intenta iniciar sesión.
 */

@RequiredArgsConstructor
@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final UserDetailsService userDetailsService; // Usará nuestra clase de servicio UserDetailsServiceImpl
    private final PasswordEncoder passwordEncoder; // Definido como un bean en la clase de configuración SecurityConfiguration

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        if (authentication.getCredentials() == null || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials may no be null");
        }

        if (!passwordEncoder.matches((String) authentication.getCredentials(), userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        return this.userDetailsService.loadUserByUsername(username);
    }
}
