package com.example.CRUD_project.jpaProject01_1.service;

import com.example.CRUD_project.jpaProject01_1.DTO.Board_1DTO;
import com.example.CRUD_project.jpaProject01_1.domain.Board_1;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Board_1_1Service {
    ResponseEntity save(Board_1DTO board_1DTO);
    ResponseEntity update(Long id, Board_1DTO board_1DTO);
    List<Board_1> findAll();
    ResponseEntity delete(Long id);
}
