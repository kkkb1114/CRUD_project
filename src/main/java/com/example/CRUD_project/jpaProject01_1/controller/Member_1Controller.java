package com.example.CRUD_project.jpaProject01_1.controller;

import com.example.CRUD_project.jpaProject01_1.DTO.Member_1DTO;
import com.example.CRUD_project.jpaProject01_1.domain.Member_1;
import com.example.CRUD_project.jpaProject01_1.service.Member_1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("/jpaProject01_1/memberApi")
@RequiredArgsConstructor
public class Member_1Controller {

    private final Member_1Service member1Service;

    @PostMapping("/insert")
    public ResponseEntity memberSave(@RequestBody Member_1DTO memberDTO){
        return member1Service.save(memberDTO);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Member_1DTO member_1DTO){
        return member1Service.update(id, member_1DTO);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return member1Service.delete(id);
    }

    @GetMapping("/findAll")
    public List<Member_1> findAll(){
        return member1Service.findAll();
    }

    @PatchMapping("/findById/{id}")
    public Member_1 findById(@PathVariable Long id){
        Optional<Member_1> member_1Optional = member1Service.findById(id);
        Member_1 member_1 = member_1Optional.orElseGet(null);
        System.out.println("3333333333: "+member_1.getMemberId());
        return member_1;
    }
}
