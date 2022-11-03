package com.example.CRUD_project.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Getter: 메소드를 생성해준다.
 * @Setter: 가급적 사용 ㄴㄴ 데이터가 변경되면 어느지점에서 변경되는지 추적이 어렵기 때문이다. Entity를 변경할일 있으면 비즈니스 메서드를 만들어서 사용하도록 한다.
 * @Entity: JPA를 사용해서 테이블과 매핑할 클래스는 @Entity를 필수로 붙여야 한다. Entity와 테이블 명을 다르게 하고 싶다면 @Table을 사용한다.
 * @Builder: 빌더 패턴을 자동으로 생성해준다. builder():빌더 클래스의 인스턴스 생성, build(): 실제 생성자 호출하여 객체 생성성
 * @DynamicUpdate: 실제 값이 변경된 컬럼으로만 update 쿼리를 만들어주는 어노테이션
 * @AllArgsConstructor:
 * @Id: PK(기본키)를 직접 할당할 필드에 적용한다.
 * */
@Getter
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_id", length = 20,nullable = false)
    private Long _id;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "userPassword", nullable = false)
    private String userPassword;

    @Column(name = "userGender", nullable = true)
    private String userGender;
}
