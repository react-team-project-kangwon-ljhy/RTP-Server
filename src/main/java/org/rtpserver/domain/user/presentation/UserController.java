package org.rtpserver.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.user.presentation.dto.req.UpdateUserAuthorityRequest;
import org.rtpserver.domain.user.presentation.dto.res.UserResponse;
import org.rtpserver.domain.user.presentation.dto.res.UsersResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public UsersResponse getUsers() {
        return queryUserService.getUsers();
    }

    @GetMapping("/{userName}")
    public UserResponse getUser(
            @PathVariable String userName
    ) {
        return queryUserService.getUser(userName);
    }

    @PutMapping("/username")
    public void updateUserName(
            @RequestHeader String accessToken,
            @RequestBody String userName
    ){
        commandUserService.updateUserName(accessToken, userName);
    }

    @PutMapping("/userpassword")
    public void updateUserPassword(
            @RequestHeader String accessToken,
            @RequestBody String userPassword
    ){
        commandUserService.updateUserPassword(accessToken, userPassword);
    }

    @PutMapping("/authority")
    public void updateUserAuthority(
            @RequestHeader String accessToken,
            @RequestBody UpdateUserAuthorityRequest updateUserAuthorityRequest
    ){
        commandUserService.updateUserAuthority(accessToken, updateUserAuthorityRequest);
    }

    @DeleteMapping
    public void deleteUser(
            @RequestHeader String accessToken
    ){
        commandUserService.deleteUser(accessToken);
    }

}
