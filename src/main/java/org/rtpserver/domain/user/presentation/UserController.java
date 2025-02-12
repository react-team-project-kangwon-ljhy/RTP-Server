package org.rtpserver.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.user.domain.value.Authority;
import org.rtpserver.domain.user.presentation.dto.req.UpdateUserAuthorityRequest;
import org.rtpserver.domain.user.presentation.dto.req.UpdateUserRequest;
import org.rtpserver.domain.user.presentation.dto.res.UserResponse;
import org.rtpserver.domain.user.presentation.dto.res.UsersResponse;
import org.rtpserver.domain.user.service.CommandUserService;
import org.rtpserver.domain.user.service.QueryUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final CommandUserService commandUserService;
    private final QueryUserService queryUserService;

    @GetMapping
    public UsersResponse getUsers() {
        return queryUserService.getUsers();
    }

    @GetMapping
    public UserResponse getUserByAccessToken(
            @RequestHeader String accessToken
    ) {
        return queryUserService.getUserByAccessToken(accessToken);
    }

    @GetMapping("/{userName}")
    public UserResponse getUserByUserName(
            @PathVariable String userName
    ) {
        return queryUserService.getUserByUserName(userName);
    }

    @PutMapping
    public void updateUser(
            @RequestHeader String accessToken,
            @RequestBody UpdateUserRequest request
    ){
        commandUserService.updateUser(accessToken, request);
    }

    @PatchMapping("/name")
    public void updateUserName(
            @RequestHeader String accessToken,
            @RequestBody String userName
    ){
        commandUserService.updateUserName(accessToken, userName);
    }

    @PatchMapping("/password")
    public void updateUserPassword(
            @RequestHeader String accessToken,
            @RequestBody String userPassword
    ){
        commandUserService.updateUserPassword(accessToken, userPassword);
    }

    @PatchMapping("/description")
    public void updateUserAuthority(
            @RequestHeader String accessToken,
            @RequestBody String description
    ){
        commandUserService.updateUserDescription(accessToken, description);
    }

    @PatchMapping("/authority")
    public void updateUserAuthority(
            @RequestHeader String accessToken,
            @RequestBody UpdateUserAuthorityRequest request
    ){
        commandUserService.updateUserAuthority(accessToken, request);
    }

    @DeleteMapping
    public void deleteUser(
            @RequestHeader String accessToken
    ){
        commandUserService.deleteUser(accessToken);
    }

}
