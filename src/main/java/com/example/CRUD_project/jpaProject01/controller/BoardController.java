package com.example.CRUD_project.jpaProject01.controller;

import com.example.CRUD_project.jpaProject01.DTO.BoardDTO;
import com.example.CRUD_project.jpaProject01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jpaProject01/boardApi")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody BoardDTO boardDTO){
        return boardService.save(boardDTO);
    }

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("board", boardDTOList);
        return "board";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return boardService.deleteById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody BoardDTO boardDTO){
        return boardService.update(id, boardDTO);
    }

    @PatchMapping("/modify/{id}")
    public ResponseEntity modify(@PathVariable Long id, @RequestBody BoardDTO boardDTO){
        return boardService.modifyBoardData(id, boardDTO, "userName_1");
    }
}
