package com.example.CRUD_project.jpaProject01.repository;

import com.example.CRUD_project.jpaProject01.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void InsertMember(){
        for (int i=6; i<=15; i++){
            Member member = Member.builder()
                    .userName("userName_"+i)
                    .userPassword("userPassword"+i)
                    .userGender("userGender"+i)
                    .build();
            memberRepository.save(member);
        }
    }
}