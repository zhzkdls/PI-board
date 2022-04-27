package com.pi.comments.model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long id;
    private String userId; //유저 아이디
    private String content; //유져가 쓴 내용
    private Long stat; // 상태 -> 0: 삭제  1: 사용중


    @Builder
    public Comment(Long id, String userId, String content, Long stat) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.stat = stat;
    }
}
