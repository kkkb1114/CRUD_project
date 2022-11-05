package com.example.CRUD_project.controller;

import com.example.CRUD_project.model.MemberModel;
import com.example.CRUD_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/getMemberList")
    public String getMemberList(Model model){
        List<MemberModel> memberModelList = memberService.printMember();
        model.addAttribute("memberList", memberModelList);
        return "";
    }
}
