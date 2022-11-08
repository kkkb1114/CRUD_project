package com.example.CRUD_project.service;

import com.example.CRUD_project.DTO.BoardDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    ResponseEntity save(BoardDTO boardDTO);
    List<BoardDTO> findAll();
    ResponseEntity deleteById(Long _id);
    ResponseEntity update(Long _id, BoardDTO boardDTO);
}
