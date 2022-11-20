package com.example.CRUD_project.jpaProject01_1.controller;

import com.example.CRUD_project.jpaProject01_1.DTO.Board_1DTO;
import com.example.CRUD_project.jpaProject01_1.DTO.Member_1DTO;
import com.example.CRUD_project.jpaProject01_1.service.Board_1_1Service;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpaProject01_1/boardApi")
@RequiredArgsConstructor
public class Board_1Controller {

    private final Board_1_1Service board_1_1Service;

    @PostMapping("/insert")
    public ResponseEntity save(@RequestBody Board_1DTO board_1DTO){
        return board_1_1Service.save(board_1DTO);
    }

}
