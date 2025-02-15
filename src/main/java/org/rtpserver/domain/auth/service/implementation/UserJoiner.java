package org.rtpserver.domain.auth.service.implementation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.auth.presentation.dto.JoinUserRequest;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.domain.repository.UserRepository;
import org.rtpserver.domain.user.domain.value.Authority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserJoiner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void joinProcess(JoinUserRequest joinUserRequest) {

        Users user = new Users(
                joinUserRequest.username(),
                joinUserRequest.password(),
                joinUserRequest.description(),
                Authority.USER
        );

        userRepository.save(user);
    }
}
