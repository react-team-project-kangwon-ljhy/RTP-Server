package org.rtpserver.domain.auth.presentation;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rtpserver.domain.auth.presentation.dto.JoinUserRequest;
import org.rtpserver.domain.auth.service.implementation.ReIssuer;
import org.rtpserver.domain.auth.service.implementation.UserJoiner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserJoiner userJoiner;
    private final ReIssuer reIssuer;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public void joinProcess(
            @RequestBody JoinUserRequest joinUserRequest
    ) {
        userJoiner.joinProcess(joinUserRequest);
    }

    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.OK)
    public void reissue(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        reIssuer.reissue(request, response);
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public void checkAuthStatus() {
        log.warn("AuthController : /check 성공");
    }

}
