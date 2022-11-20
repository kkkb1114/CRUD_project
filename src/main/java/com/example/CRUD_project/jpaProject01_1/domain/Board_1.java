package com.example.CRUD_project.jpaProject01_1.domain;

import com.example.CRUD_project.jpaProject01_1.DTO.Board_1DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@DynamicUpdate
@AllArgsConstructor
public class Board_1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 255, nullable = false)
    Long id;

    //@Column(name = "member", nullable = false)
    //Member_1 member_1;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "content", nullable = false)
    String content;

    @Builder
    public Board_1(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(Board_1DTO board_1DTO){
        this.title = board_1DTO.getTitle();
        this.content = board_1DTO.getContent();
    }
}
