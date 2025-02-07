package org.rtpserver.domain.board.domain;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.rtpserver.domain.user.domain.Users;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Type(StringArrayType.class)
    @Column(columnDefinition = "varchar[]")
    private List<String> tags;

//    @Type(StringArrayType.class)
//    @Column(columnDefinition = "varchar[]")
//    private List<String> imgs;

    public Board(Users user, String title, String contents, List<String> tags) {
        this.user = user;
        this.title = title;
        this.contents = contents;
        this.tags = tags;
    }

    public void update(String title, String contents, List<String> tags) {
        this.title = title;
        this.contents = contents;
        this.tags = tags;
    }

}
