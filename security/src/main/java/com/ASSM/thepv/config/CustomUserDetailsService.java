package com.ASSM.thepv.config;

import com.ASSM.thepv.entity.Account;
import com.ASSM.thepv.repository.AccountRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author thepvph20110
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Account user = accountRepository.findAccountByUsername(usernameOrEmail);

        if (user != null) {
            return new User(user.getUsername()
                    , user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
            );
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
