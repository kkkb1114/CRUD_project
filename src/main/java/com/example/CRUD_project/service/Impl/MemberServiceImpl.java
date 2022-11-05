package com.example.CRUD_project.service.Impl;

import com.example.CRUD_project.dao.MemberDao;
import com.example.CRUD_project.model.MemberModel;
import com.example.CRUD_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public List<MemberModel> printMember(){
        System.out.println("asdasas"+memberDao.getMemberList().toString());
        return memberDao.getMemberList();
    }
}
