package com.example.CRUD_project.controller;

import com.example.CRUD_project.DTO.MemberDTO;
import com.example.CRUD_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/memberApi")
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

    @DeleteMapping("/delete/{_id}")
    public ResponseEntity delete(@PathVariable Long _id) {
        return memberService.deleteById(_id); // return ResponseEntity
    }

    @PatchMapping("/update/{_id}")
    public ResponseEntity update(@PathVariable Long _id, @RequestBody MemberDTO memberDTO) {
        return memberService.update(_id, memberDTO);
    }
}
