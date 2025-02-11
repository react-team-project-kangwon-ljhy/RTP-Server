package org.rtpserver.domain.user.domain.repository;

import org.rtpserver.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);
}
