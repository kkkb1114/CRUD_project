package com.example.CRUD_project.jpaProject01.repository;

import com.example.CRUD_project.jpaProject01.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
