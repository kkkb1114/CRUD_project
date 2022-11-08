package com.example.CRUD_project.DTO;

import com.example.CRUD_project.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    Long id;
    String title;
    String content;
    String views;
    String likes;
    Member member;

    @Builder
    public BoardDTO(Long id, String title, String content, String views, String likes, Member member){
        this.id = id;
        this.title = title;
        this.content = content;
        this.views = views;
        this.likes = likes;
        this.member = member;
    }
}
