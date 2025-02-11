package org.rtpserver.domain.user.service.implementation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.domain.repository.UserRepository;
import org.rtpserver.domain.user.domain.value.Authority;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdater {

    private final UserRepository userRepository;

    public void update(Users updatableUser, Users users){
        updatableUser.update(
                users.getUserName(),
                users.getPassword(),
                users.getUserDescription(),
                users.getAuthority()
        );

        userRepository.save(updatableUser);
    }

    public void updateAuthority(Users updatableUser, Authority authority){
        updatableUser.updateAuthority(
                authority
        );

        userRepository.save(updatableUser);
    }

    public void updatePassword(Users updatableUser, String password){
        updatableUser.updatePassword(
                password
        );

        userRepository.save(updatableUser);
    }

    public void updateUserName(Users updatableUser, String userName){
        updatableUser.updateUserName(
                userName
        );

        userRepository.save(updatableUser);
    }

    public void updateUserDescription(Users updatableUser, String userDescription){
        updatableUser.updateUserDescription(
                userDescription
        );

        userRepository.save(updatableUser);
    }

}
