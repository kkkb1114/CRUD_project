package com.example.CRUD_project.jpaProject01_1.repository;

import com.example.CRUD_project.jpaProject01_1.domain.Board_1;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Board_1Repository extends JpaRepository<Board_1, Long> {
    //@Query(value = "SELECT b FROM Board_1 b join b.member_1 m where m.member_1_id = :memberId")
    //List<Board_1> findByIdSQL(@Param("memberId") Long id);
    //where b.Board_1_id = 87
    @Query(value = "SELECT b FROM Board_1 b join b.member_1 m where m.member_1_id = 82") 우선 조인문에서 막힌 상태이다.
    List<Board_1> findByIdSQL();
}
