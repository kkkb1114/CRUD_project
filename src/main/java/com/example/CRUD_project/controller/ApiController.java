package com.example.CRUD_project.controller;

import com.example.CRUD_project.DTO.MemberDTO;
import com.example.CRUD_project.domain.Member;
import com.example.CRUD_project.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @PostMapping("/insert")
    public ResponseEntity save(@RequestBody MemberDTO memberDTO) {
        return apiService.save(memberDTO); // return ResponseEntity
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = apiService.findAll();
        model.addAttribute("member", memberDTOList);
        return "hello";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return apiService.deleteById(id); // return ResponseEntity
    }
}
