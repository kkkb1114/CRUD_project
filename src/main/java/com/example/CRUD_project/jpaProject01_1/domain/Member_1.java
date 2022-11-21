package com.example.CRUD_project.jpaProject01_1.domain;

import com.example.CRUD_project.jpaProject01_1.DTO.Member_1DTO;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Entity: Entity클래스로 지정하는 어노테이션으로 Entity클래스는 하나의 테이블로 인식한다.
 * Getter: 해당 클래스에 저장되어있는 데이터를 읽기 위한 어노테이션
 * AllArgsConstructor: 자동으로 생성자를 만들어 생성자를 만들떄 변수에 대한 값 또한 넣을 수 있게 한다. ex) this.userName = userName;
 * DynamicUpdate: 해당 클래스의 변경된 데이터값만 대응하기 위한 어노테이션으로 jpa는 전체 필드를 업데이트 하는 방식에 대해 대응하기 위해 생긴 어노테이션이다. (보통 update에 사용됨.)
 * Builder: 아직 정확히 아는 것은 아니나 해당 어노테이션이 있으면 타 클래스에서 생성자를 만들때 Builder() 함수를 사용이 가능하다.
 */
@Entity
@Getter
@AllArgsConstructor
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member_1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Member_1_id", length = 255, nullable = false)
    Long Member_1_id;

    @Column(name = "memberId", nullable = false)
    String memberId;

    @Column(name = "memberPassword", nullable = false)
    String memberPassword;

    @Column(name = "memberName", nullable = false)
    String memberName;

    @Builder
    public Member_1(String memberId, String memberPassword, String memberName){
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
    }

    public void update(Member_1DTO member_1DTO){
        this.memberId = member_1DTO.getMember_1Id();
        this.memberPassword = member_1DTO.getMember_1Password();
        this.memberName = member_1DTO.getMember_1Name();
    }
}
