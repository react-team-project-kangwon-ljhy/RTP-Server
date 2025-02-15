package org.rtpserver.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.auth.service.dto.CustomUserDetails;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Users user = userRepository.findByUserName(userName);

        if (user != null) {

            return new CustomUserDetails(user);
        }

        return null;
    }
}
