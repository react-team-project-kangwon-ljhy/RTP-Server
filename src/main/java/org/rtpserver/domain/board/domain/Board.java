package org.rtpserver.domain.board.domain;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "users_id")
//    private User user;

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

}
