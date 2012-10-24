package com.mreapps.kvissnet.gaebackend.server.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationProvider implements AuthenticationProvider
{

    private static Map<String, String> users = new HashMap<String, String>();

    static
    {
        users.put("fabrizio", "javacodegeeks");
        users.put("justin", "javacodegeeks");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        if (true)
        {
            Authentication customAuthentication = new CustomUserAuthentication("ROLE_ADMIN", authentication);
            customAuthentication.setAuthenticated(true);

            return customAuthentication;
        }

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        if (users.get(username) == null)
            throw new UsernameNotFoundException("User not found");

        String storedPass = users.get(username);

        if (!storedPass.equals(password))
            throw new BadCredentialsException("Invalid password");

        Authentication customAuthentication = new CustomUserAuthentication("ROLE_USER", authentication);
        customAuthentication.setAuthenticated(true);

        return customAuthentication;

    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
