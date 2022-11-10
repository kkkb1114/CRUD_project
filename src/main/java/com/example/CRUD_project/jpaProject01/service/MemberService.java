package com.example.CRUD_project.jpaProject01.service;

import com.example.CRUD_project.jpaProject01.DTO.MemberDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    ResponseEntity save(MemberDTO memberDTO);
    List<MemberDTO> findAll();
    ResponseEntity deleteById(Long id);
    ResponseEntity update(Long id, MemberDTO memberDTO);
}
