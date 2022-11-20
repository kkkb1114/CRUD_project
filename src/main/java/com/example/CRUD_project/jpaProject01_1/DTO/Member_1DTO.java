package com.example.CRUD_project.jpaProject01_1.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
public class Member_1DTO {
    Long id;
    String member_1Id;
    String member_1Password;
    String member_1Name;

    @Builder
    public Member_1DTO(Long id, String member_1Id, String member_1Password, String member_1Name){
        this.id = id;
        this.member_1Id = member_1Id;
        this.member_1Password = member_1Password;
        this.member_1Name = member_1Name;
    }
}
