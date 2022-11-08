package com.example.CRUD_project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired // 자동 생성자 생성
    BoardRepository boardRepository;

    @Test
    void findByTitle() {
        System.out.println("BoardRepositoryTest_findByTitle: "+boardRepository.findByTitle("boardTitle_5").getContent());
    }
}