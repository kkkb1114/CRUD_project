package com.example.CRUD_project.jpaProject01_1.controller;

import com.example.CRUD_project.jpaProject01.domain.Board;
import com.example.CRUD_project.jpaProject01_1.DTO.Board_1DTO;
import com.example.CRUD_project.jpaProject01_1.DTO.Member_1DTO;
import com.example.CRUD_project.jpaProject01_1.domain.Board_1;
import com.example.CRUD_project.jpaProject01_1.service.Board_1_1Service;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpaProject01_1/boardApi")
@RequiredArgsConstructor
public class Board_1Controller {

    private final Board_1_1Service board_1_1Service;

    @PostMapping("/insert")
    public ResponseEntity save(@RequestBody Board_1DTO board_1DTO){
        return board_1_1Service.save(board_1DTO);
    }

    @GetMapping("/findAll")
    public List<Board_1> finaAll(){
        return board_1_1Service.findAll();
    }

    @PatchMapping("/findById/{id}")
    public Board_1 findById(@PathVariable Long id){
        return board_1_1Service.findById(id);
    }

    @PatchMapping("/findByIdSQL/{id}")
    public List<Board_1> findByIdSQL(@PathVariable Long id){
        return board_1_1Service.findByIdSQL(id);
    }

    @PatchMapping("/update")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Board_1DTO board_1DTO){
        return board_1_1Service.update(id, board_1DTO);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return board_1_1Service.delete(id);
    }
}
