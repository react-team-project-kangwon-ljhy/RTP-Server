package org.rtpserver.global.jwt.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rtpserver.domain.auth.service.dto.CustomUserDetails;
import org.rtpserver.domain.user.domain.value.Authority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthenticationUtil {


    public static Long getMemberId() {
        var anonymous = String.valueOf(isAnonymous());
        log.warn(anonymous);
        if (isAnonymous()) {
            return null;
        }
        return (Long) getAuthentication().getPrincipal();
    }

    public static Authority getMemberAuthority() {
        if (isAnonymous()) {
            log.info("Anonymous user detected");
            return Authority.USER;
        }

        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails) {
            return extractAuthorityFromAuthorities(authentication.getAuthorities());
        }

        return extractAuthorityFromAuthorities(authentication.getAuthorities());
    }

    private static Authority extractAuthorityFromAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .map(Authority::valueOf)
                .findFirst()
                .orElse(Authority.USER);
    }

    public static boolean isAnonymous() {
        Authentication authentication = getAuthentication();
        return authentication == null || authentication.getPrincipal().equals("anonymousUser");
    }

    private static Authentication getAuthentication() {
        var context = SecurityContextHolder.getContext();
        log.info("Context :"+ context);
        var result = context.getAuthentication();
        log.info("result : " + result);
        return result;
    }
}
