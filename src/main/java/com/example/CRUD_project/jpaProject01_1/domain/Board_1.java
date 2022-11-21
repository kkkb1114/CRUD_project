package com.example.CRUD_project.jpaProject01_1.domain;

import com.example.CRUD_project.jpaProject01_1.DTO.Board_1DTO;
import com.example.CRUD_project.jpaProject01_1.DTO.Member_1DTO;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board_1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Board_1_id", length = 255, nullable = false)
    Long Board_1_id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "content", nullable = false)
    String content;

    @ManyToOne
    @JoinColumn(name = "member_1_id")
    Member_1 member_1;

    @Builder
    public Board_1(String title, String content, Member_1 member_1){
        this.title = title;
        this.content = content;
        this.member_1 = member_1;
    }

    public void update(Board_1DTO board_1DTO){
        this.title = board_1DTO.getTitle();
        this.content = board_1DTO.getContent();
        this.member_1 = board_1DTO.getMember_1();
    }
}
