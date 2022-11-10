package com.example.CRUD_project.jpaProject01.service;

import com.example.CRUD_project.jpaProject01.DTO.BoardDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardService {
    ResponseEntity save(BoardDTO boardDTO);
    List<BoardDTO> findAll();
    ResponseEntity deleteById(Long id);
    ResponseEntity update(Long id, BoardDTO boardDTO);
    ResponseEntity modifyBoardData(Long id, BoardDTO boardDTO, String memberName);
}
