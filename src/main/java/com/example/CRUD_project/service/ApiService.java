package com.example.CRUD_project.service;

import com.example.CRUD_project.DTO.MemberDTO;
import com.example.CRUD_project.domain.Member;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApiService {
    ResponseEntity save(MemberDTO memberDTO);
    List<MemberDTO> findAll();
    ResponseEntity deleteById(Long id);
}
