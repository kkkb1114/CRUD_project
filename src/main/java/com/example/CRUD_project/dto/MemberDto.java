package com.example.CRUD_project.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MemberDto implements Serializable {
    private Long _id;
    private String userName;
    private String userPassword;
    private String userGender;
}
