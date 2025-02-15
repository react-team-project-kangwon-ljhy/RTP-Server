package org.rtpserver.domain.auth.service.dto;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.user.domain.Users;
import org.rtpserver.domain.user.domain.value.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Users user;


    private GrantedAuthority getAuthority(Authority role) {
        return new SimpleGrantedAuthority("ROLE_" + role.name());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();

        switch (user.getAuthority()) {
            case STUDENT:
                authorityList.add(getAuthority(Authority.STUDENT));
                break;
            case USER:
                authorityList.add(getAuthority(Authority.USER));
                break;
            case TEACHER:
                authorityList.add(getAuthority(Authority.TEACHER));
                break;
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public Long getId() { return user.getUserId(); }
}
