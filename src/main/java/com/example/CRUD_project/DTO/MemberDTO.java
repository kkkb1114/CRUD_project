package com.example.CRUD_project.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDTO {
    private Long _id;
    private String userName;
    private String userPassword;
    private String userGender;
}
