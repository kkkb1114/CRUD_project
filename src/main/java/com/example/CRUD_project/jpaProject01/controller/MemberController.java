package com.example.CRUD_project.jpaProject01.controller;

import com.example.CRUD_project.jpaProject01.DTO.MemberDTO;
import com.example.CRUD_project.jpaProject01.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jpaProject01/memberApi")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/insert")
    public ResponseEntity save(@RequestBody MemberDTO memberDTO) {
        return memberService.save(memberDTO); // return ResponseEntity
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("member", memberDTOList);
        return "member";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return memberService.deleteById(id); // return ResponseEntity
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        return memberService.update(id, memberDTO);
    }
}
