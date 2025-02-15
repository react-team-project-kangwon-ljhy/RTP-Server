package org.rtpserver.domain.auth.domain.repository;

import org.rtpserver.domain.auth.domain.Refresh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshRepository extends JpaRepository<Refresh, Long> {
    Boolean existsByRefreshToken(String refreshToken);

    void deleteByRefreshToken(String refreshToken);
}
