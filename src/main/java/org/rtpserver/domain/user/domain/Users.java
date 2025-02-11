package org.rtpserver.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rtpserver.domain.user.domain.value.Authority;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

    private String password;

    private String userDescription;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void updateAuthority(Authority authority) {
        this.authority = authority;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }

    public void updateUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public void update(String userName, String password, String userDescription, Authority authority) {
        this.userName = userName;
        this.password = password;
        this.userDescription = userDescription;
        this.authority = authority;
    }

}
