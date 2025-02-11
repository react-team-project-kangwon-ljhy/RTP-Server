package org.rtpserver.domain.user.service.implementation;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleter {

    private final UserRepository userRepository;

    public void delete(Users user) {
        userRepository.delete(user);
    }
}
