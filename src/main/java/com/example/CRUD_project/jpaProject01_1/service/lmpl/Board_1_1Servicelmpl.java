package com.example.CRUD_project.jpaProject01_1.service.lmpl;

import com.example.CRUD_project.jpaProject01_1.DTO.Board_1DTO;
import com.example.CRUD_project.jpaProject01_1.domain.Board_1;
import com.example.CRUD_project.jpaProject01_1.repository.Board_1Repository;
import com.example.CRUD_project.jpaProject01_1.service.Board_1_1Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Board_1_1Servicelmpl implements Board_1_1Service {

    private final Board_1Repository board_1Repository;

    @Override
    public ResponseEntity save(Board_1DTO board_1DTO) {
        try {
            Board_1 board_1 = Board_1.builder()
                    .title(board_1DTO.getTitle())
                    .content(board_1DTO.getContent())
                    .build();
            board_1Repository.save(board_1);
            return new ResponseEntity("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity update(Long id, Board_1DTO board_1DTO) {
        return null;
    }

    @Override
    public List<Board_1> findAll() {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }
}
