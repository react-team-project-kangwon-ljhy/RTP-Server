package org.rtpserver.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.presentation.dto.res.UserResponse;
import org.rtpserver.domain.user.presentation.dto.res.UsersResponse;
import org.rtpserver.domain.user.service.implementation.UserReader;
import org.rtpserver.global.jwt.decode.JWTPayloadDecoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryUserService {

    private final UserReader userReader;
    private final JWTPayloadDecoder jWTPayloadDecoder;

    public UserResponse getUserByAccessToken(String accessToken){
        Users user = userReader.findById(jWTPayloadDecoder.jwtPayloadDecodeToUserId(
                accessToken
        ));

        return new UserResponse(
                user.getUserName(),
                user.getUserDescription()
        );
    }

    public UserResponse getUserByUserName(String userName){
        Users user = userReader.findByUsername(userName);

        return new UserResponse(
                user.getUserName(),
                user.getUserDescription()
        );
    }

    public UsersResponse getUsers(){
        List<Users> users = userReader.findAll();
        List<UserResponse> usersResponse = new ArrayList<>();

        for(Users user : users){
            usersResponse.add(new UserResponse(
                    user.getUserName(),
                    user.getUserDescription()
            ));
        }

        return new UsersResponse(usersResponse);
    }

}
