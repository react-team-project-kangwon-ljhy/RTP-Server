package org.rtpserver.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.domain.value.Authority;
import org.rtpserver.domain.user.presentation.dto.req.UpdateUserAuthorityRequest;
import org.rtpserver.domain.user.presentation.dto.req.UpdateUserRequest;
import org.rtpserver.domain.user.service.implementation.UserDeleter;
import org.rtpserver.domain.user.service.implementation.UserReader;
import org.rtpserver.domain.user.service.implementation.UserUpdater;
import org.rtpserver.global.jwt.decode.JWTPayloadDecoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandUserService {

    private final UserUpdater userUpdater;
    private final UserDeleter userDeleter;
    private final UserReader userReader;
    private final JWTPayloadDecoder jWTPayloadDecoder;

    public void updateUser(String accessToken, UpdateUserRequest request) {
        userUpdater.update(
                userReader.findById(jWTPayloadDecoder.jwtPayloadDecodeToUserId(
                        accessToken
                )),
                request
        );
    }

    public void updateUserName(String accessToken, String userName) {
        userUpdater.updateUserName(
                userReader.findById(jWTPayloadDecoder.jwtPayloadDecodeToUserId(
                        accessToken
                )),
                userName
        );
    }

    public void updateUserPassword(String accessToken, String password) {
        userUpdater.updateUserName(
                userReader.findById(jWTPayloadDecoder.jwtPayloadDecodeToUserId(
                        accessToken
                )),
                password
        );
    }

    public void updateUserDescription(String accessToken, String description) {
        userUpdater.updateUserName(
                userReader.findById(jWTPayloadDecoder.jwtPayloadDecodeToUserId(
                        accessToken
                )),
                description
        );
    }

    public void updateUserAuthority(String accessToken, UpdateUserAuthorityRequest authority) {
        Users user = userReader.findById(jWTPayloadDecoder.jwtPayloadDecodeToUserId(
                accessToken
        ));

        if(user.getAuthority().equals(Authority.TEACHER)) {
            userUpdater.updateAuthority(
                    userReader.findById(authority.userId()),
                    authority.authority()
            );
        }
    }

    public void deleteUser(String accessToken){
        userDeleter.delete(
                userReader.findById(jWTPayloadDecoder.jwtPayloadDecodeToUserId(
                        accessToken
                ))
        );
    }

}
