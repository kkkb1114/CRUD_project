package com.example.CRUD_project.dao;

import com.example.CRUD_project.model.MemberModel;

import java.util.List;

public interface MemberDao {
    List<MemberModel> getMemberList();
}
