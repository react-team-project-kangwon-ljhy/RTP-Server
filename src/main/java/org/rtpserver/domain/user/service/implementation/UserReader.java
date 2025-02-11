package org.rtpserver.domain.user.service.implementation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserReader {

    private final UserRepository userRepository;

    public Users findById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Users findByUsername(String userName){
        return userRepository.findByUserName(userName);
    }

}
