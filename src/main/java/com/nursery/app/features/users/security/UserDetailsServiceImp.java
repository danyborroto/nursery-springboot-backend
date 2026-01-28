package com.nursery.app.features.users.security;

import com.nursery.app.features.users.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findUserByUserName(username)
                .map(UserDetailsImp::new)
                .orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));
    }
}
