package com.example.CRUD_project.jpaProject01.repository;

import com.example.CRUD_project.jpaProject01.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByTitle(String title);
}
