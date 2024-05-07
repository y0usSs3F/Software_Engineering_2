package com.Secuirty.secuirtyproject.Services.Implementation;

import com.Secuirty.secuirtyproject.Repository.UserRepository;
import com.Secuirty.secuirtyproject.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
               return (UserDetails) userRepository.findByEmail(username)
                       .orElseThrow(()->new UsernameNotFoundException("User not found"));
            }
        };
    }
}
