package com.example.CRUD_project.jpaProject01_1.service;

import com.example.CRUD_project.jpaProject01_1.DTO.Member_1DTO;
import com.example.CRUD_project.jpaProject01_1.domain.Member_1;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface Member_1Service {
    ResponseEntity save(Member_1DTO memberDTO);
    List<Member_1> findAll();
    Optional<Member_1> findById(Long id);
    ResponseEntity update(Long id, Member_1DTO memberDTO);
    ResponseEntity delete(Long id);
}
