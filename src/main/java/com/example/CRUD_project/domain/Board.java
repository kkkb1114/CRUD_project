package com.example.CRUD_project.domain;

import com.example.CRUD_project.DTO.BoardDTO;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.w3c.dom.Text;

import javax.persistence.*;

@Getter
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 20, nullable = false)
    Long id;

    @Column(name = "title", columnDefinition = "TEXT", nullable = false)
    String title;
    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    String content;

    @Column(name = "views", columnDefinition = "TEXT", nullable = false)
    String views;

    @Column(name = "likes", columnDefinition = "TEXT", nullable = false)
    String likes;

    // member 테이블과 member_id를 기준으로 join
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = true)
    Member member;

    @Builder
    public Board(String title, String content, String views, String likes, Member member) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.likes = likes;
        this.member = member;
    }

    public void update(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.views = boardDTO.getViews();
        this.likes = boardDTO.getLikes();
        this.member = boardDTO.getMember();
    }
}
