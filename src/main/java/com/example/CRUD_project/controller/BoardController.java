package com.example.CRUD_project.controller;

import com.example.CRUD_project.DTO.BoardDTO;
import com.example.CRUD_project.domain.Board;
import com.example.CRUD_project.service.BoardService;
import com.example.CRUD_project.service.Impl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boardApi")
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

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity delete(@PathVariable Long _id){
        return boardService.deleteById(_id);
    }

    @PatchMapping("/update/{_id}")
    public ResponseEntity update(@PathVariable Long _id, @RequestBody BoardDTO boardDTO){
        return boardService.update(_id, boardDTO);
    }
}
