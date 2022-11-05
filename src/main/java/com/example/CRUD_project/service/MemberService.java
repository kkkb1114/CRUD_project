package com.example.CRUD_project.service;

import com.example.CRUD_project.model.MemberModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    List<MemberModel> printMember();
}
