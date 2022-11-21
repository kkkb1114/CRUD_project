package com.example.CRUD_project.jpaProject01_1.DTO;

import com.example.CRUD_project.jpaProject01_1.domain.Member_1;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board_1DTO {
    String title;
    String content;
    Member_1 member_1;
}
